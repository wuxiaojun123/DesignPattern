package com.example.java_designpattern.facade;

/**
 * Created by wuxiaojun on 2018/11/14.
 */

public class Presentation {

    public void generate() {
        ConfigModel cm = ConfigManager.getInstance().getConfigData();
        if(cm.isNeedGenPresentation()){
            System.out.println("正在生成表现层代码文件");
        }
    }

}
