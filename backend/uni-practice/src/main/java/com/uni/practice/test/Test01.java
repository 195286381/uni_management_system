package com.uni.practice.test;

import org.checkerframework.checker.units.qual.C;

import java.io.FileInputStream;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author zhuzw
 * @date 2024/11/18 17:29
 */
public class Test01 {
    public static void main(String[] args) throws InterruptedException {

        // 执行次数
        int execTimes = 10000;
        int currentThreadNumber = Runtime.getRuntime().availableProcessors();
        System.out.println("计算机线程数：" + currentThreadNumber);
        //FileInputStream
        CountDownLatch countDownLatch = new CountDownLatch(execTimes);
        Semaphore semaphore = new Semaphore(currentThreadNumber);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        IntStream.rangeClosed(1, execTimes)
                .forEach(i -> {
                    CompletableFuture.runAsync(() -> {
                        System.out.println(Thread.currentThread().getName() + " : "  + atomicInteger.incrementAndGet());
                        countDownLatch.countDown();
                    });
                });
        countDownLatch.await();
        System.out.println("finished");
    }
}
