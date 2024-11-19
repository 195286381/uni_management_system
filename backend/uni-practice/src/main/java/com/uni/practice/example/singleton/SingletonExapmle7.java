package com.uni.practice.example.singleton;

import com.uni.practice.annotation.Recommend;
import com.uni.practice.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;
/**
 *
 * 基于枚举的单例类, 防止反射攻击.
 *
 * @author zhuzw
 * @date 2024/11/18 15:18
 */
@Slf4j
@ThreadSafe
@Recommend
public class SingletonExapmle7 {
    // 构造器私有
    private SingletonExapmle7() {

    }

    // 维护一个单例对象
    private volatile static SingletonExapmle7 instance = null;

    public static SingletonExapmle7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExapmle7 singleton;

        Singleton() {
            singleton = new SingletonExapmle7();
        }

        public SingletonExapmle7 getInstance() {
            return singleton;
        }
    }
}
