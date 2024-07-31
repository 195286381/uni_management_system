package com.uni.sms.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "sms")
@Data
public class SmsProperties {
    private Boolean enable = false;
    // 短信服务商, 默认设置为 aliyun
    private String smsProvider = "aliyun";
    // 阿里云id
    private String aliyunAccessKeyId;
    // 阿里云密钥
    private String aliyunAccessKeySecret;
}
