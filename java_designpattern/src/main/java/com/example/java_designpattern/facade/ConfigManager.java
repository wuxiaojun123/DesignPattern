package com.example.java_designpattern.facade;

/**
 * Created by wuxiaojun on 2018/11/14.
 */

public class ConfigManager {

    private static ConfigManager manager = null;

    private static ConfigModel cm = null;


    public static ConfigManager getInstance() {
        if (manager == null) {
            manager = new ConfigManager();
            cm = new ConfigModel();
        }
        return manager;
    }

    public ConfigModel getConfigData() {
        return cm;
    }

}
