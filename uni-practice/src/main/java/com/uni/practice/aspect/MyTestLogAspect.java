package com.uni.practice.aspect;

import com.uni.practice.annotation.MyTestLogAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 我的日志切面
 *
 * @author zhuzw
 * @date 2024/8/7 09:08
 */
@Aspect
@Component
public class MyTestLogAspect {

    @Around("@annotation(myTestLogAnnotation)")
    public Object around(ProceedingJoinPoint joinPoint, MyTestLogAnnotation myTestLogAnnotation) throws Throwable
    {
        String moduleName = myTestLogAnnotation.moduleName();
        String type = myTestLogAnnotation.type();
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println(moduleName + ":" + type + ":" + (end - start));
        return result;
    }
}
