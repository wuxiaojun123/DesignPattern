package com.example.java_designpattern.facade;

/**
 * Created by wuxiaojun on 2018/11/14.
 */

public class Dao {

    public void generate() {
        ConfigModel cm = ConfigManager.getInstance().getConfigData();
        if (cm.isNeedGenDao()) {
            System.out.println("正在生成数据层代码文件");
        }
    }

}
