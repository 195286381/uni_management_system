package com.uni.practice.example.atomic;

import com.uni.practice.annotation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author zhuzw
 * @date 2024/11/17 23:30
 */
@Slf4j
@ThreadSafe
public class AtomicExample6 {

    // 是否发生.
    public static AtomicBoolean isHappend = new AtomicBoolean(false);



    public static int clientTotal = 1000;
    public static int threadTotal = 50;


    /**
     *  // 原子操作保证 atomicBoolean 只执行一次, 不会错误.
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // 创建一个缓冲线程池.
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                countDownLatch.countDown();
            });


        }
        countDownLatch.await();
        executorService.shutdown();

        log.info("isHappend:{}", isHappend);

    }

    public static void test() {
        // 原子操作保证 atomicBoolean 只执行一次, 不会错误.
       if (isHappend.compareAndSet(false, true)) {
           log.info("execute");
       }
    }
}
