package com.uni.common.core.domain.model;

import lombok.Data;

/**
 * 用户登录对象
 * 
 * @author uni
 */

@Data
public class LoginBody
{
    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 手机号
     */
    private Long telephone;

    /**
     * 验证码
     */
    private String code;

    /**
     * 唯一标识
     */
    private String uuid;

}
