package com.uni.practice.example.singleton;

import com.uni.practice.annotation.NotThreadSafe;
import com.uni.practice.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;
/**
 *
 * 饿汉模式 在类装载的时候创建.
 * 饿汉模式可能会造成资源浪费.
 * 肯定会被使用
 * @author zhuzw
 * @date 2024/11/18 15:18
 */
@Slf4j
@ThreadSafe
public class SingletonExapmle2 {
    // 构造器私有
    private SingletonExapmle2() {

    }

    // 维护一个单例对象
    private static SingletonExapmle2 instance = new SingletonExapmle2();

    // 静态的工厂方法获取一个对象
    // 这里线程不安全.
    public static SingletonExapmle2 getInstance() {
        return instance;
    }
}
