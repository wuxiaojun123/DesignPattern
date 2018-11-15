package com.example.java_designpattern.factoryMethod;

/**
 * 导出文件对象的接口
 * Created by wuxiaojun on 2018/11/15.
 */

public interface ExportFileApi {

    /***
     * 导出内容成为文件
     * @param data:需要保存的文件
     * @return 是否导出成功
     */
    public boolean export(String data);

}
