package com.uni.web.controller.system;

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
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        AjaxResult ajax = AjaxResult.success();
//      // 对前端传入的密码进行解密
//        try {
//            loginBody.setPassword(RsaUtils.decryptByPrivateKey(loginBody.getPassword()));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 获取用户信息
     * 
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo()
    {
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
    @GetMapping("getRouters")
    public AjaxResult getRouters()
    {
        Long userId = SecurityUtils.getUserId();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
        return AjaxResult.success(menuService.buildMenus(menus));
    }
}