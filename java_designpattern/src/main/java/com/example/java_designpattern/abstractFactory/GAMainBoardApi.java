package com.example.java_designpattern.abstractFactory;

/**
 * Created by wuxiaojun on 2018/11/19.
 */

public class GAMainBoardApi implements MainBoardApi {

    private int count;

    public GAMainBoardApi(int count) {
        this.count = count;
    }

    @Override
    public void installCPU() {
        System.out.println("主板是 " + count);
    }


}
