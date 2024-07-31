package com.uni.framework.security.authentication;

import com.uni.common.core.domain.entity.SysUser;
import com.uni.common.core.domain.model.LoginUser;
import com.uni.common.enums.UserStatus;
import com.uni.common.exception.ServiceException;
import com.uni.common.utils.StringUtils;
import com.uni.framework.web.service.SysPermissionService;
import com.uni.system.service.ISysUserService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 基于短信验证的用户验证处理
 *
 * @author zhuzw57
 */
@Slf4j
@Service("smsCodeUserDetailsServiceImpl")
public class SmsCodeUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private ISysUserService userService;
    @Autowired
    private SysPermissionService permissionService;
    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        // 通过手机号查询用户
        long number = Long.parseLong(phoneNumber);
        SysUser user = userService.selecUserByPhone(number);
        if (StringUtils.isNull(user)) {
            log.info("登录用户：{} 不存在.", phoneNumber);
            throw new ServiceException("登录用户：" + phoneNumber+ " 不存在");
        } else if (UserStatus.DELETED.getCode().equals(user.getDelFlag())) {
            log.info("登录用户：{} 已被删除.", phoneNumber);
            throw new ServiceException("对不起，您的账号：" + phoneNumber+ " 已被删除");
        } else if (UserStatus.DISABLE.getCode().equals(user.getStatus())) {
            log.info("登录用户：{} 已被停用.", phoneNumber);
            throw new ServiceException("对不起，您的账号：" + phoneNumber+ " 已停用");
        }
        return createLoginUser(user);
    }
    public UserDetails createLoginUser(SysUser user) {
        return new LoginUser(user.getUserId(), user.getDeptId(), user, permissionService.getMenuPermission(user));
    }

}
