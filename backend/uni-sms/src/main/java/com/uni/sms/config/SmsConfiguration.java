package com.uni.sms.config;


import com.uni.sms.anotation.SmsEnabledCondition;
import com.uni.sms.service.AliyunSmsCodeService;
import com.uni.sms.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SmsConfiguration {



    @Autowired
    private SmsProperties smsProperties;


    @Bean
    @Conditional(SmsEnabledCondition.class)
    public SmsService smsService() {
            return new AliyunSmsCodeService(smsProperties.getAliyunAccessKeyId(), smsProperties.getAliyunAccessKeySecret());
    }
}
