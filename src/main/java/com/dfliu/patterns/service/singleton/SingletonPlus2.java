package com.dfliu.patterns.service.singleton;

/**
 * 通过枚举方式实现单例
 */
public enum SingletonPlus2 {
    INSTANCE;

    public void sayHi() {
        System.out.println(String.format("sayHi,from %s", this.getClass().toString()));
    }
}
