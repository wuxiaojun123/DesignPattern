package com.wxj.datastructure.http.callback;

/**
 * Created by wuxiaojun on 2018/12/26.
 */

public interface HttpCallback<M> {

    public void onSuccess(String tag, M model);

    public void onFail(String tag, Throwable errormsg);

    public void onFinish(String tag);

}
