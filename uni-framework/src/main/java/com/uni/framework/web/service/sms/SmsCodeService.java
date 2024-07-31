package com.uni.framework.web.service.sms;

public interface SmsCodeService {
    /**
     * 发送短信验证码
     * @param phoneNumber
     * @return
     */
    public String sendSmsCode(String phoneNumber) throws RuntimeException;
}
