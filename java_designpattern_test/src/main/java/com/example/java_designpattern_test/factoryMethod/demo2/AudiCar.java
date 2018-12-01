package com.example.java_designpattern_test.factoryMethod.demo2;

/**
 * Created by wuxiaojun on 2018/11/15.
 */

public abstract class AudiCar {

    /**
     * 汽车的抽象产品类
     *  可以驾驶
     */
    public abstract void drive();

    /***
     * 汽车的抽象产品类
     *  可以自动驾驶
     */
    public abstract void selfNavigation();

}
