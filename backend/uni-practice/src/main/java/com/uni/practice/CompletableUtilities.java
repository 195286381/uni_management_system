package com.uni.practice;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author zhuzw
 * @date 2024/11/17 11:43
 */
public class CompletableUtilities {
    // 获取并展示CF中存储的值
    public static void showr(CompletableFuture<?> completableFuture) {
        try {
            System.out.println(completableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public static void voidr(CompletableFuture<?> completableFuture) {
        try {
           completableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
