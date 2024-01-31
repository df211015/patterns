package com.dfliu.patterns.service.singleton;

/**
 * 单例加强版, 解决线程安全
 */
public class SingletonPlus {
    private static volatile SingletonPlus instance;

    private SingletonPlus() {
    }

    public static SingletonPlus getInstance() {
        if (null == instance) {
            synchronized (SingletonPlus.class) {
                if (null == instance) {
                    instance = new SingletonPlus();
                }
            }
        }
        return instance;
    }
}
