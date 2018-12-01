package com.example.java_designpattern.abstractFactory;

/**
 * Created by wuxiaojun on 2018/11/19.
 */

public class IntelCPU implements CPUApi {

    private int count;

    public IntelCPU(int count) {
        this.count = count;
    }

    @Override
    public void calculate() {
        System.out.println("cpu 的指数是" + count);
    }

}
