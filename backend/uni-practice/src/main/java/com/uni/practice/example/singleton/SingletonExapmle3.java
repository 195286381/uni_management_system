package com.uni.practice.example.singleton;

import com.uni.practice.annotation.NotRecommend;
import com.uni.practice.annotation.NotThreadSafe;
import com.uni.practice.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * 线程安全的懒汉模式1 单例的实例在第一次使用时获取.在多线程环境下可能有问题.
 * @author zhuzw
 * @date 2024/11/18 15:18
 */
@Slf4j
@ThreadSafe
@NotRecommend
public class SingletonExapmle3 {
    // 构造器私有
    private SingletonExapmle3() {

    }

    // 维护一个单例对象
    private static SingletonExapmle3 instance = null;

    // 静态的工厂方法获取一个对象
    // 这里线程不安全.
    public static synchronized SingletonExapmle3 getInstance() {
        if (instance == null) {
            instance = new SingletonExapmle3();
        }
        return instance;
    }
}
