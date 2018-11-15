package com.example.java_designpattern.factoryMethod.operate;

import com.example.java_designpattern.factoryMethod.ExportFileApi;
import com.example.java_designpattern.factoryMethod.ExportOperate;
import com.example.java_designpattern.factoryMethod.ExportTxtFile;

/**
 * Created by wuxiaojun on 2018/11/15.
 */

public class ExportTxtFileOperate extends ExportOperate {

    @Override
    protected ExportFileApi factoryMethod() {
        // 创建导出成文本文件格式的对象
        return new ExportTxtFile();
    }

}
