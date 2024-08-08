package com.uni.practice;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanLifecycle implements InitializingBean, DisposableBean, BeanNameAware {

    @PostConstruct
    public void init() {
        System.out.println("BeanLifecycle.init");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("BeanLifecycle.afterPropertiesSet");
    }

    @PostConstruct
    public void preConstruct() {
        System.out.println("BeanLifecycle.preConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("BeanLifecycle.destroy");
    }

    @Override
    public void destroy() {
        System.out.println("BeanLifecycle.destroy");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("BeanLifecycle 的 名字是123456 = " + s);
    }
}
