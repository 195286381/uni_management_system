package com.uni.practice;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BeanLifecycle implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {

    }

    @PostConstruct
    public void init() {
        System.out.println("BeanLifecycle.init");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BeanLifecycle.afterPropertiesSet");
    }
}
