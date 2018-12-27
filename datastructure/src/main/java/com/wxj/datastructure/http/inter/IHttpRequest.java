package com.wxj.datastructure.http.inter;

import android.content.Context;

import com.wxj.datastructure.http.inter.HttpCallBack;

import java.util.Map;

/**
 * Created by wuxiaojun on 2018/12/22.
 */

public interface IHttpRequest {

	<T> void get(Context context, String url, Map<String, Object> params, HttpCallBack<T> httpCallBack, final boolean cache);

	<T> void post(Context context, String url, Map<String, Object> params, HttpCallBack<T> httpCallBack, final boolean cache);



}
