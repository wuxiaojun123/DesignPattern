package com.example.java_designpattern_test.abstractFactory;

/**
 * Created by wuxiaojun on 2018/11/19.
 */

public class Client {

    public static void main(String[] args) {

        AbstractFactory af = new ConcreateFactory1();
        af.createProductA();
        af.createProductB();

    }

}
