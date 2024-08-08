package com.uni.practice.annotation;


import java.lang.annotation.*;

// 利用切面进行编程.
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyTestLogAnnotation {
    /**
     * 模块名
     * @return
     */
    String moduleName();

    /**
     * 类型
     * @return
     */
    String type();
}
