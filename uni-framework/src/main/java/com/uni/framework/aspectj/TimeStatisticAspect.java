package com.uni.framework.aspectj;

import com.uni.common.annotation.TimeStatistic;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 自定义日志切面
 *
 * @author zhuzw
 * @date 2024/8/5 14:36
 */

@Component
@Aspect
public class TimeStatisticAspect {
    @Around("@annotation(timeStatistic)")
    public Object around(ProceedingJoinPoint jp, TimeStatistic timeStatistic) throws Throwable {
        long start = System.currentTimeMillis();
        Object result =  jp.proceed();
        long end = System.currentTimeMillis();
        System.out.println("方法执行耗时:" +(end - start) + "ms");
        return result;
    }
}
