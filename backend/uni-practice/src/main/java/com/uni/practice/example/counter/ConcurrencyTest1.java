package com.uni.practice.example.counter;

import com.uni.practice.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author zhuzw
 * @date 2024/11/17 20:28
 */

/**
 * 使用代码来模拟并发测试.
 */
@Slf4j
@NotThreadSafe
public class ConcurrencyTest1 {
    public static int clientTotal = 1000;
    public static int threadTotal = 50;
    public static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        // 创建一个缓冲线程池.
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                countDownLatch.countDown();
            });


        }
        countDownLatch.await();
        log.info("count:{}", count);
        System.out.println("count:{}" +  count); // 这里输出的数据不等于1000, 这个类是属于线程不安全的类.
    }

    public static void add() {
        count++;
    }
}
