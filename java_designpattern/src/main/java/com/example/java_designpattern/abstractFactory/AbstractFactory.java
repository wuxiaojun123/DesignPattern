package com.example.java_designpattern.abstractFactory;

/**
 * 抽象工厂，创建cpu和主板
 * Created by wuxiaojun on 2018/11/19.
 */

public interface AbstractFactory {

    /****
     * 创建cpu的对象
     * @return
     */
    public CPUApi createCPUApi();

    /***
     * 创建主板的对象
     * @return
     */
    public MainBoardApi createMainBoardApi();

}
