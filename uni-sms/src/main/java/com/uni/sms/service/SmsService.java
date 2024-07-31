package com.uni.sms.service;



public interface SmsService {
    /**
     * 发送短信验证码.
     * @return
     */
    void sendSms(String phoneNumber, String code);
}
