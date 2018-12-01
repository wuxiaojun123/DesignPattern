package com.example.java_designpattern_test.factoryMethod.demo1;

/**
 * Created by wuxiaojun on 2018/11/15.
 */

public class Client {

    public static void main(String[] args) {

        Factory factory = new ConcreateFactory();
        Product product = factory.createProduct(ConcreateProductA.class);
        product.method();

        product = factory.createProduct(ConCreateProductB.class);
        product.method();

    }

}
