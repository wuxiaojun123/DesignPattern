package com.wxj.datastructure.bean;

/**
 * Created by wuxiaojun on 2018/10/11.
 */

public class HttpResult<T> {

    private int errorCode;

    private String errorMsg;

    private T data;



    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg == null ? "" : errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
