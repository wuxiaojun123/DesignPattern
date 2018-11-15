package com.example.java_designpattern.factoryMethod;

/**
 * Created by wuxiaojun on 2018/11/15.
 */

public abstract class ExportOperate {

    public boolean export(String data) {
        ExportFileApi api = factoryMethod();
        return api.export(data);
    }

    protected abstract ExportFileApi factoryMethod();

}
