package com.wxj.datastructure.http;

import android.content.Context;

import com.wxj.datastructure.http.inter.HttpCallBack;
import com.wxj.datastructure.http.inter.IHttpRequest;

import java.util.Map;

/**
 * Created by wuxiaojun on 2018/12/22.
 */

public class XUtilsRequest implements IHttpRequest {

	@Override public <T> void get(Context context, String url, Map<String, Object> params, HttpCallBack<T> httpCallBack, boolean cache) {

	}

	@Override public <T> void post(Context context, String url, Map<String, Object> params, HttpCallBack<T> httpCallBack, boolean cache) {

	}

}
