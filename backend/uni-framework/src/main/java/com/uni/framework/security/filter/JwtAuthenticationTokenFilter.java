package com.uni.framework.security.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.uni.common.core.domain.model.LoginUser;
import com.uni.common.utils.SecurityUtils;
import com.uni.common.utils.StringUtils;
import com.uni.framework.web.service.TokenService;

/**
 * token过滤器 验证token有效性
 *
 * 工作流程描述:
 * 1. 通过 tokenService.getUser 从 请求头的 Authorization 获取 token. 如果没有 则返回 null.
 * 2. 如果获取到 token. 那么会通过 jwt 解析 token. 找到对应的key. 之后尝试去 redis 中获取对应的用户信息.
 * 3. 如果获取不到也返回 null. 获取到则返回用户信息.
 * 4. 然后将用户信息设置到 securityContextHolder 中.
 *
 * 总之就是如果有凭证且用户登录了, 那么就直接将用户登录信息放到 securityContextHolder 中.后面就不需要登录.
 * 这个就是JwtAuthenticationTokenFilter的作用.
 * 
 * @author uni
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter
{
    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException
    {
        // 通过 tokenService 去获取用户信息.
        LoginUser loginUser = tokenService.getLoginUser(request);
        // 如果查询出来用户信息, 并且 securityContextHolder 中没有用户信息，就设置用户信息到 securityContextHolder 中.
        if (StringUtils.isNotNull(loginUser) && StringUtils.isNull(SecurityUtils.getAuthentication()))
        {
            tokenService.verifyToken(loginUser);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        chain.doFilter(request, response);
    }
}
