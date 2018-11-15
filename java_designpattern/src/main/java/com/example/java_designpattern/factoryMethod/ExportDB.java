package com.example.java_designpattern.factoryMethod;

/**
 * Created by wuxiaojun on 2018/11/15.
 */

public class ExportDB implements ExportFileApi {

    @Override
    public boolean export(String data) {
        System.out.println("导出数据" + data
                + "到数据库中备份文件");
        return true;
    }


}
