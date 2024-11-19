package com.uni.practice.example.atomic;

import com.uni.practice.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author zhuzw
 * @date 2024/11/17 23:30
 */
@Slf4j
@ThreadSafe
public class AtomicExample4 {
    // 原子引用.
    private static AtomicReference<Integer> count = new AtomicReference<>(0);


    public static void main(String[] args) {
        count.compareAndSet(0, 2); // 正常执行
        count.compareAndSet(0, 2); // 不执行
        count.compareAndSet(1, 3); // 不执行
        count.compareAndSet(2, 4); // 执行
        count.compareAndSet(3, 5); // 不执行
       log.info("count {}", count.get()); // 因此输出为4
    }
}
