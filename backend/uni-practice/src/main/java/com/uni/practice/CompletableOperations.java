package com.uni.practice;

/**
 * @author zhuzw
 * @date 2024/11/17 11:45
 */

import java.sql.Time;
import java.util.Timer;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static com.uni.practice.CompletableUtilities.showr;
import static com.uni.practice.CompletableUtilities.voidr;

/**
 * CompletableOperations 操作类
 */
public class CompletableOperations {
    /**
     * 创建一个 Integer 的 CompletableFuture
     * @param i
     * @return
     */
    static CompletableFuture<Integer> cfi(int i) {
        return CompletableFuture.completedFuture(i);
    }

    public CompletableOperations() {
    }

    public static void main(String[] args) {
        showr(cfi(1));
        // runAsync 为静态方法
        voidr(cfi(2).runAsync(() -> {
            System.out.println("runAsync");
        }));
        voidr(cfi(3).thenRunAsync(() -> {
            System.out.println("thenRunAsync");
        }));
        voidr(CompletableFuture.runAsync(() -> {
            System.out.println("runAsync is static function");
        }));
        // supply 返回一个值.
        showr(CompletableFuture.supplyAsync(() -> {
            return 99;
        }));
        voidr(cfi(4).thenAcceptAsync(i -> {
            System.out.println("thenAcceptAsync : " + i);
        }));
        showr(cfi(5).thenApplyAsync(i -> i + 42));
        // thenComposeAsync 的用法和 thenApplyAsync 非常类似, 只是 thenApplyAsync 返回的是一个值, 而thenComposeAsync返回的是一个CompletableFuture
        showr(cfi(6).thenComposeAsync(i -> cfi(i + 42)));


        //CompletableFuture<Integer> completableFuture = CompletableFuture.

        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 1;
        });
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 2;
        });
        CompletableFuture<Integer> cf3 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 3;
        });
        // 等cf1 ,cf2, cf3 都完成, 取他们的返回值, 执行下一步操作
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(cf1, cf2, cf3).thenAccept(result -> {
            System.out.println("result = " + result);
        });

        CompletableFuture.anyOf(cf1, cf2, cf3).thenAccept(x -> {
            System.out.println("then accept!");
            System.out.println(x);
        });

        long l = System.currentTimeMillis();
        Void join = voidCompletableFuture.join();
        Integer join1 = cf1.join();
        Integer join2 = cf2.join();
        Integer join3 = cf2.join();
        System.out.println(join1 + join2);
        System.out.println(l - System.currentTimeMillis());
        System.out.println("finish");


        // accept 就是消费.
        // apply 就是有返回值.
        // run 就是记不需要也不需要.Z
    }
}
