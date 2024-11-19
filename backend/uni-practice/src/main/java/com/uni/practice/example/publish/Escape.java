package com.uni.practice.example.publish;

import com.uni.practice.annotation.NotRecommend;
import com.uni.practice.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 对象溢出
 * 还没有初始化之前就把对象发布. 导致初始化前的对象状态 和 初始化后的对象状态不一致. 在多线程环境下有问题.
 * @author zhuzw
 * @date 2024/11/18 14:45
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {
    private int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
        thisCanBeEscape = 1;
    }
    // 定义一个内部类.
    private class InnerClass {
        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        Escape escape = new Escape(); // 输出0

        System.out.println("escape.thisCanBeEscape = " + escape.thisCanBeEscape); // 输出 1

    }
}
