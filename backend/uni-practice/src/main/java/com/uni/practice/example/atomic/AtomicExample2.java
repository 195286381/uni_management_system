package com.uni.practice.example.atomic;

import com.uni.practice.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author zhuzw
 * @date 2024/11/17 23:30
 */
@Slf4j
@ThreadSafe
public class AtomicExample2 {
    public static int clientTotal = 1000;
    public static int threadTotal = 50;
    public static LongAdder count = new LongAdder();
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
        count.add(2);
    }
}
