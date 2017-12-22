package com.example.java_jichu.yunsuanfu;

/**
 * Created by wuxiaojun on 2017/12/21.
 */

public class ChongZaiTestParent {

    public static void staticTest(){

    }

    public int test(int a) {
        System.out.println("输出参数：" + a);
        return a;
    }

    protected double test(double a) {
        return a;
    }

}
