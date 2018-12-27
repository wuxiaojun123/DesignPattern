package com.wxj.datastructure.http.inter;

/**
 * Created by wuxiaojun on 2018/12/22.
 */

public abstract class HttpCallBack<T> {

	public abstract void onSuccess(String tag, T result);

	public abstract void onFailure(String tag, Exception e);

}
