package com.example.java_designpattern.easyFactory;

/**
 * Created by wuxiaojun on 2018/11/9.
 */

public class Impl implements API {


    @Override
    public void test1(String s) {
        System.out.println("Now In Impl.The input s==" + s);
    }


}
