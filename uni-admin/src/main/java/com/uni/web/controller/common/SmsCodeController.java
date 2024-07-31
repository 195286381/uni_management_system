package com.uni.web.controller.common;


import com.uni.common.core.domain.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/smsCode")
public class SmsCodeController {
    @GetMapping
    public R<Object> send(String phoneNumber, String code, String uuid) {
        // 进行手机号码校验

        // 进行验证码校验

        // 发送验证码

        // 返回uuid 以及 短信验证码的值.
        return R.ok();
    }
}
