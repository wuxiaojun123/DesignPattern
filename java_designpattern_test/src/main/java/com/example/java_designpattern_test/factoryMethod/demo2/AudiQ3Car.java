package com.example.java_designpattern_test.factoryMethod.demo2;

/**
 * Created by wuxiaojun on 2018/11/15.
 */

public class AudiQ3Car extends AudiCar {
    @Override
    public void drive() {
        System.out.println("Q3的驾驶");
    }

    @Override
    public void selfNavigation() {
        System.out.println("Q3自动驾驶");
    }
}
