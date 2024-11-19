package com.uni.practice.example.singleton;

import com.uni.practice.annotation.NotThreadSafe;
import com.uni.practice.annotation.Recommend;
import com.uni.practice.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;



/**
 *
 * 线程安全的懒汉模式2 单例的实例在第一次使用时获取.在多线程环境下可能有问题.
 * volatile + 双重检测保证线程安全.
 * @author zhuzw
 * @date 2024/11/18 15:18
 */
@Slf4j
@ThreadSafe
@Recommend
public class SingletonExapmle5 {
    // 构造器私有
    private SingletonExapmle5() {

    }

    // 维护一个单例对象
    private volatile static  SingletonExapmle5 instance = null;



    // 创建对象的三个步骤. 分配对象的内存空间/初始化/分配内存空间.

    // 1. memory = allocate() 分配对象的内存空间
    // 2. ctorInstance() 初始化对象
    // 3. instance = memory 设置 instance指向刚分配的内存.


    // JVM和CPU优化, 发生了指令重排.
    // 1. memory = allocate() 分配对象的内存空间
    // 3. instance = memory 设置 instance指向刚分配的内存.
    // 2. ctorInstance() 初始化对象


    // 这里2/3步骤可能会发生重排.

    // 静态的工厂方法获取一个对象
    // 这里线程不安全.
    public static SingletonExapmle5 getInstance() {
        if (instance == null) { // 双重检测机制
            synchronized(SingletonExapmle5.class) {
                if (instance == null) { // 同步锁
                    instance = new SingletonExapmle5();
                }
            }
        }
        return instance;
    }
}
