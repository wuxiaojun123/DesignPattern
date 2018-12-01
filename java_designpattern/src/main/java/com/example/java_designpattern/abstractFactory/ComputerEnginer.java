package com.example.java_designpattern.abstractFactory;

/**
 * 组装电脑的类
 * <p>
 * Created by wuxiaojun on 2018/11/19.
 */

public class ComputerEnginer {

    private CPUApi cpu = null;

    private MainBoardApi mainBoardApi = null;

    /***
     * 组装电脑
     * @param schema 抽象工厂，主要创建cpu和主板
     */
    public void makeCompute(AbstractFactory schema) {
        prepareHardWares(schema);
    }

    private void prepareHardWares(AbstractFactory schema) {
        this.cpu = schema.createCPUApi();
        this.mainBoardApi = schema.createMainBoardApi();

        cpu.calculate();
        mainBoardApi.installCPU();
    }


}
