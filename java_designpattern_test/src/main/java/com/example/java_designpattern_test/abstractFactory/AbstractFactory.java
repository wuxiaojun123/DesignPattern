package com.example.java_designpattern_test.abstractFactory;

/**
 * Created by wuxiaojun on 2018/11/19.
 */

public interface AbstractFactory {

    /**
     * 创建抽象产品A的对象
     *
     * @return
     */
    public AbstractProductA createProductA();

    /***
     * 创建抽象产品B的对象
     * @return
     */
    public AbstractProductB createProductB();

}
