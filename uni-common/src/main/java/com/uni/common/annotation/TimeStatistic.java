package com.uni.common.annotation;

import java.lang.annotation.*;

/**
 * @author zhuzw
 * @date 2024/8/5 14:37
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TimeStatistic {
    String value() default "";
}
