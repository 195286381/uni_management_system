package com.uni.practice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationSpringPractice {
    // 测试注解配置d4e
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PracticeConfiguration.class);
        TestBean bean = context.getBean(TestBean.class);
        bean.test();
    }
}
