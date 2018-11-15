package com.example.java_designpattern.facade;

/**
 * 示意配置描述的数据model，真实的配置数据会很多
 * <p>
 * Created by wuxiaojun on 2018/11/9.
 */

public class ConfigModel {

    /***
     * 是否需要生成表现层
     */
    private boolean needGenPresentation = true;

    /***
     * 是否需要生成逻辑层
     */
    private boolean needGenBusiness = true;

    /**
     * 8
     * 是否需要生成Dao层
     */
    private boolean needGenDao = true;

    public boolean isNeedGenPresentation() {
        return needGenPresentation;
    }

    public void setNeedGenPresentation(boolean needGenPresentation) {
        this.needGenPresentation = needGenPresentation;
    }

    public boolean isNeedGenBusiness() {
        return needGenBusiness;
    }

    public void setNeedGenBusiness(boolean needGenBusiness) {
        this.needGenBusiness = needGenBusiness;
    }

    public boolean isNeedGenDao() {
        return needGenDao;
    }

    public void setNeedGenDao(boolean needGenDao) {
        this.needGenDao = needGenDao;
    }
}
