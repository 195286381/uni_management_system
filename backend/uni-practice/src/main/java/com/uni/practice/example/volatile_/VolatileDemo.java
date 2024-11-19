package com.uni.practice.example.volatile_;

import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * @author zhuzw
 * @date 2024/11/18 13:10
 */
public class VolatileDemo {
    public static boolean finishFlag = false;
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            CompletableFuture.runAsync(() -> {
                while(!finishFlag) {

                }
            });
        }
        Long time = System.currentTimeMillis();
        Thread.sleep(2000);//确保t1先进入while循环后主线程才修改finishFlag
        System.out.println("线程终止！");
        System.out.println(System.currentTimeMillis() - time);
        finishFlag = true;
        //Thread.sleep(10000000);
    }
}
