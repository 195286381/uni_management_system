package com.uni.practice.example.singleton;

import com.uni.practice.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * 懒汉模式 单例的实例在第一次使用时获取.在多线程环境下可能有问题.
 * @author zhuzw
 * @date 2024/11/18 15:18
 */
@Slf4j
@NotThreadSafe
public class SingletonExapmle1 {
    // 构造器私有
    private SingletonExapmle1() {

    }

    // 维护一个单例对象
    private static SingletonExapmle1 instance = null;

    // 静态的工厂方法获取一个对象
    // 这里线程不安全.
    public static SingletonExapmle1 getInstance() {
        if (instance == null) {
            instance = new SingletonExapmle1();
        }
        return instance;
    }
}
