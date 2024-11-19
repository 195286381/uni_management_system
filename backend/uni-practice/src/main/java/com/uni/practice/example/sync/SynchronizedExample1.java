package com.uni.practice.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author zhuzw
 * @date 2024/11/18 11:16
 */
@Slf4j
public class SynchronizedExample1 {

    // 修饰一个代码块
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 - {} - {}", j,  i);
            }
        }
    }

    // 修饰一个方法
    public synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            log.info("test2 - {}", i);
        }
    }

    public static synchronized void test3() {
        for (int i = 0; i < 10; i++) {
            log.info("test3 - {}", i);
        }
    }

    public static void main(String[] args) {
        // 创建一个缓存线程池.
        ExecutorService executorService = Executors.newCachedThreadPool();

        SynchronizedExample1 synchronizedExample1 = new SynchronizedExample1();
        SynchronizedExample1 synchronizedExample2 = new SynchronizedExample1();

        log.info("---------------- {} ------------------", "test1");
        // 顺序执行
        executorService.execute(() -> synchronizedExample1.test1(1));
        executorService.execute(() -> synchronizedExample1.test1(1));

        // 开启线程来执行这个方法.
        // 执行这段代码可以看出, log交叉运行.
        log.info("---------------- {} ------------------", "test2");
        executorService.execute(() -> synchronizedExample1.test1(1));
        executorService.execute(() -> synchronizedExample2.test1(2));

        // 顺序执行. 因为是 static 修饰的. 对该类的所有对象都加锁.
        log.info("---------------- {} ------------------", "test3");
        executorService.execute(() -> synchronizedExample1.test3());
        executorService.execute(() -> synchronizedExample2.test3());
    }


}
