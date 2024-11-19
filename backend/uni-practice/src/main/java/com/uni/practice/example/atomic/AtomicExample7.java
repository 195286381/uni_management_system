package com.uni.practice.example.atomic;

import com.uni.practice.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicStampedReference;


/**
 * AtomicStampedReference 解决原子引用ABA问题.
 * @author zhuzw
 * @date 2024/11/17 23:30
 */
@Slf4j
@ThreadSafe
public class AtomicExample7 {

    // 是否发生.
    public static AtomicStampedReference stampedReference = new AtomicStampedReference<>(0, 1);



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

        log.info("reference:{}", stampedReference.getReference());
        log.info("stamp:{}", stampedReference.getStamp());
        executorService.shutdown();



    }

    public static void test() {
        // 原子操作保证 atomicBoolean 只执行一次, 不会错误.
       if (stampedReference.compareAndSet(0, 1, stampedReference.getStamp(), stampedReference.getStamp() + 1));
    }
}
