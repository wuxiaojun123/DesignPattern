package com.example.java_designpattern.abstractFactory;

/**
 * 产品对象
 *
 * Created by wuxiaojun on 2018/11/19.
 */

public class Schema1 implements AbstractFactory {

    @Override
    public CPUApi createCPUApi() {
        return new IntelCPU(1156);
    }

    @Override
    public MainBoardApi createMainBoardApi() {
        return new GAMainBoardApi(1156);
    }

}
