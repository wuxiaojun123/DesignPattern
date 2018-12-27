package com.wxj.datastructure.http;

import android.content.Context;

import com.wxj.datastructure.http.inter.HttpCallBack;
import com.wxj.datastructure.http.inter.IHttpRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuxiaojun on 2018/12/22.
 */

public class HttpUtils {

	private IHttpRequest		mHttpRequest;

	private final int			TYPE_POST	= 0x0011, TYPE_GET = 0x0022;

	private int					mType		= TYPE_GET;

	private Map<String, Object>	mParams;

	private String				mUrl;

	private Context				mContext;

	private HttpUtils(Context context) {
		this.mContext = context;
		mParams = new HashMap<>();
	}

	public static HttpUtils with(Context context) {
		return new HttpUtils(context);
	}

	public HttpUtils params(String key, String value) {
		mParams.put(key, value);
		return this;
	}

	public HttpUtils getUrl(String url) {
		mUrl = url;
		return this;
	}

	public HttpUtils cache(boolean cache) {
		return this;
	}

	public void request() {
		request();
	}

	public <T> void request(HttpCallBack<T> callBack) {
		mHttpRequest.get(mContext, mUrl, mParams, callBack, true);
	}

}
