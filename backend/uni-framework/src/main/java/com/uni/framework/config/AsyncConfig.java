package com.uni.framework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import java.util.concurrent.*;

/**
 * 开启异步配置
 *
 * @author zhuzw
 * @date 2024/8/12 09:47
 */
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer{
    @Override
    public Executor getAsyncExecutor() {
        return new ThreadPoolExecutor(
            10,
            20,
            60,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(2000),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy()
        );
    }
}
