package com.uni.web.controller.system;

import com.uni.common.annotation.TimeStatistic;
import com.uni.practice.annotation.MyTestLogAnnotation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import java.util.Set;
import com.uni.common.security.RsaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.uni.common.constant.Constants;
import com.uni.common.core.domain.AjaxResult;
import com.uni.common.core.domain.entity.SysMenu;
import com.uni.common.core.domain.entity.SysUser;
import com.uni.common.core.domain.model.LoginBody;
import com.uni.common.utils.SecurityUtils;
import com.uni.framework.web.service.SysLoginService;
import com.uni.framework.web.service.SysPermissionService;
import com.uni.system.service.ISysMenuService;

/**
 * 登录验证
 *
 * @author uni
 */
@Api(tags = {"系统：登录接口"})
@RestController
public class SysLoginController
{
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private RsaUtils rsaUtils;

    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @ApiOperation(value = "账户密码登录", notes = "通过用户名和密码登录系统")
    @PostMapping("/login")
    public AjaxResult login(
            @ApiParam(value = "登录信息", required = true)
            @RequestBody LoginBody loginBody) {
        System.out.println("loginBody = " + loginBody);
        AjaxResult ajax = AjaxResult.success();
        // 对前端传入的密码进行解密
        try {
            loginBody.setPassword(rsaUtils.decryptByPrivateKey(loginBody.getPassword()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 手机号码登录
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @ApiOperation(value = "手机号码登录", notes = "通过手机号和验证码登录系统")
    @PostMapping("/smsLogin")
    public AjaxResult smsLogin(@ApiParam(value = "登录信息", required = true) @RequestBody LoginBody loginBody) {
        System.out.println("loginBody = " + loginBody);
        AjaxResult ajax = AjaxResult.success();
        String token = loginService.smsLogin(loginBody.getTelephone(), loginBody.getCode(),
                loginBody.getUuid());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @ApiOperation(value = "获取当前登录用户信息", notes = "返回当前登录用户的详细信息")
    @GetMapping("/getInfo")
    public AjaxResult getInfo() {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @ApiOperation(value = "获取当前登录用户菜单树", notes = "返回当前登录用户的菜单树信息")
    @GetMapping("/getRouters")
    @TimeStatistic
    @MyTestLogAnnotation(moduleName = "system", type = "get")
    public AjaxResult getRouters() {
        Long userId = SecurityUtils.getUserId();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
        return AjaxResult.success(menuService.buildMenus(menus));
    }
}
