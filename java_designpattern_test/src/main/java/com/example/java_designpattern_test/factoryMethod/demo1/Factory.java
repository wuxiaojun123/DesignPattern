package com.example.java_designpattern_test.factoryMethod.demo1;

/**
 * Created by wuxiaojun on 2018/11/15.
 */

public abstract class Factory {

    /***
     * 抽象工厂方法
     * 具体生产什么由子类决定
     * @return
     */
    public abstract <T extends Product> T createProduct(Class<T> clz);

}
