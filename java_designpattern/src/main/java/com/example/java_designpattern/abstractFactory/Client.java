package com.example.java_designpattern.abstractFactory;

/**
 * Created by wuxiaojun on 2018/11/19.
 */

public class Client {

    public static void main(String[] args) {

        ComputerEnginer computerEnginer = new ComputerEnginer();
        AbstractFactory schema = new Schema1();
        computerEnginer.makeCompute(schema);

    }

}
