package com.example.java_designpattern.factoryMethod;

import com.example.java_designpattern.factoryMethod.operate.ExportDBOperate;
import com.example.java_designpattern.factoryMethod.operate.ExportTxtFileOperate;

/**
 * Created by wuxiaojun on 2018/11/15.
 */

public class Client {

    public static void main(String[] args) {

        ExportOperate operate = new ExportDBOperate();
        operate.export("数据库测试数据");

        operate = new ExportTxtFileOperate();
        operate.export("文件测试数据");

    }

}
