package com.uni.sms.anotation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class SmsEnabledCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 获取环境变量
        Environment env = context.getEnvironment();
        // 读取sms.enable属性
        boolean isSmsEnabled = env.getProperty("sms.enable", Boolean.class, false);
        // 返回属性值
        return isSmsEnabled;
    }
}