package com.example.java_designpattern.factoryMethod.operate;

import com.example.java_designpattern.factoryMethod.ExportDB;
import com.example.java_designpattern.factoryMethod.ExportFileApi;
import com.example.java_designpattern.factoryMethod.ExportOperate;

/**
 * Created by wuxiaojun on 2018/11/15.
 */

public class ExportDBOperate extends ExportOperate {


    @Override
    protected ExportFileApi factoryMethod() {
        return new ExportDB();
    }


}
