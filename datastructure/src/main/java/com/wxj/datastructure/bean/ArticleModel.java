package com.wxj.datastructure.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuxiaojun on 2018/10/11.
 */

public class ArticleModel {

    private int curPage;

    private List<ArticleBean> datas;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public List<ArticleBean> getDatas() {
        if (datas == null) {
            return new ArrayList<>();
        }
        return datas;
    }

    public void setDatas(List<ArticleBean> datas) {
        this.datas = datas;
    }
}
