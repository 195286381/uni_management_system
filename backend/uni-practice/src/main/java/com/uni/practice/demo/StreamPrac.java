package com.uni.practice.demo;

import org.apache.poi.ss.formula.functions.T;

import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author zhuzw
 * @date 2024/11/17 08:51
 */
public class StreamPrac {
    public static final Deque<String> queue = new ConcurrentLinkedDeque<>();


    static class IntGenerator implements Supplier<Integer> {
        private final AtomicInteger current = new AtomicInteger(0);



        @Override
        public Integer get() {
            //int cu = current.get();
            //System.out.println("current: " + Thread.currentThread().getName());
            queue.add("current: " + Thread.currentThread().getName() + "\n");
            return current.getAndIncrement();
        }
    }
    public static void main(String[] args) {
        //demo01();
        //demo02();
        //demo03();
        demo04();
    }

    private static void demo04() {
        // 等待未来的任务.
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("休息一秒钟");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).thenRunAsync(() -> {
            System.out.println("休息一秒钟");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        // 合并到主线程.
        voidCompletableFuture.join();
    }

    /**
     * 测试CompletableFuture
     */
    private static void demo03() {
        // 多线程异步任务
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.completedFuture(1)
                .thenApplyAsync(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName());
                    return i + 1;
                }).thenApplyAsync(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName());
                    return i + 1;
                }).thenApplyAsync(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName());
                    return i + 1;
                }).thenApplyAsync(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName());
                    return i + 1;
                });

        integerCompletableFuture.join();
        System.out.println("finish!");
    }

    static Runnable runnable = () -> {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("runnable: " + Thread.currentThread().getName());
        queue.add("runnable: " + Thread.currentThread().getName() + "\n");
    };

    private static void demo02() {
        Timer timer = new Timer();
        List<CompletableFuture<Void>> collect = IntStream.rangeClosed(1, 10)
                // 创建10个CompletableFuture
                .mapToObj(x -> CompletableFuture.runAsync(runnable))
                //.peek(CompletableFuture::join)
                .collect(Collectors.toList());
        collect.forEach(CompletableFuture::join);
        System.out.println("finish");
    }

    private static void demo01() {
        //List<Integer> collect = Stream.generate(new IntGenerator()).parallel().limit(10).collect(Collectors.toList());
        List<Integer> collect = Stream.generate(new IntGenerator()).limit(100).parallel().collect(Collectors.toList());
        System.out.println("collect = " + collect);
        System.out.println("cu" + queue);
    }


}
