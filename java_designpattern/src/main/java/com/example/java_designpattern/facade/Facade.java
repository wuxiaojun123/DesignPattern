package com.example.java_designpattern.facade;

/**
 * Created by wuxiaojun on 2018/11/14.
 */

public class Facade {

    /***
     * 客户端需要的是一个简单的调用代码生成的功能
     */
    public void generate() {
        new Presentation().generate();
        new Business().generate();
        new Dao().generate();
    }

}
