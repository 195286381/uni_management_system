//package com.uni.practice;
//
//import org.springframework.beans.BeansException;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//
///**
// * 自定义工具类
// *
// * @author zhuzw
// * @date 2024/8/7 10:02
// */
//
//@SpringBootApplication
//@Component
//public class MyApplicationContextUtils implements ApplicationContextAware {
//    private static ApplicationContext applicationContext;
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }
//
//    /**
//     * 获取Bean的工具类
//     * @param clazz
//     * @return
//     * @param <T>
//     */
//    public static <T> T getBean(Class<T> clazz)
//    {
//        return applicationContext.getBean(clazz);
//    }
//
//}
//
//
//WebApplicationContextUtils