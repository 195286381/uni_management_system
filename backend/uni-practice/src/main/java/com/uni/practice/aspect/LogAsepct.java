package com.uni.practice.aspect;

import com.uni.framework.manager.AsyncManager;
import com.uni.practice.annotation.EnableLog;
import com.uni.practice.domain.PracticeLog;
import com.uni.practice.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.TimerTask;

/**
 * @author zhuzw
 * @date 2024/11/16 10:01
 */
@Slf4j
@Component
@Aspect
public class LogAsepct {

    @Resource
    private LogService logService;

    @Pointcut("@annotation(com.uni.practice.annotation.EnableLog)")
    public void pointcut() {};

    /**
     * 通过@annotaion可以直接获取到连接点和注解本身的信息, 然后再后面的代码对方法进行处理.
     * @param joinPoint
     * @param enableLog
     */
    @Before("pointcut() && @annotation(enableLog)")
    public void before(JoinPoint joinPoint, EnableLog enableLog) {
        String method = enableLog.method();
        String predix = enableLog.predix();
        // 异步插入日志.
        AsyncManager.me().execute(new TimerTask() {
            @Override
            public void run() {
                logService.addLog(new PracticeLog(null, method, predix));
                log.info("添加日志: {}", method);
            }
        });
        System.out.println("LogAsepct.before");
        System.out.println("获取到的注解信息:" + enableLog);
    }

    @After("pointcut()")
    public void after() {
        System.out.println("LogAsepct.after");
    }
}
