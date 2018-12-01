package com.example.java_designpattern_test.factoryMethod.demo2;

/**
 * Created by wuxiaojun on 2018/11/15.
 */

public class AudiQ7Car extends AudiCar {
    @Override
    public void drive() {
        System.out.println("Q7的驾驶");
    }

    @Override
    public void selfNavigation() {
        System.out.println("Q7自动驾驶");
    }
}
