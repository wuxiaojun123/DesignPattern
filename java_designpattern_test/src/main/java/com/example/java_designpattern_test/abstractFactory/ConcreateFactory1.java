package com.example.java_designpattern_test.abstractFactory;

/**
 * Created by wuxiaojun on 2018/11/19.
 */

public class ConcreateFactory1 implements AbstractFactory {


    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB();
    }


}
