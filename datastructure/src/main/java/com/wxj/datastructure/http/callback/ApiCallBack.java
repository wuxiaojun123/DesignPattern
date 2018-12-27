package com.wxj.datastructure.http.callback;

import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by kenrich on 2018/11/8.
 */

public class ApiCallBack<M> extends ResourceSubscriber<M> {

	private String			tag;

	private HttpCallback	httpCallback;

	public ApiCallBack(String tag, HttpCallback<M> httpCallback) {
		this.tag = tag;
		this.httpCallback = httpCallback;
	}

	@Override public void onNext(M m) {
		httpCallback.onSuccess(tag, m);
	}

	@Override public void onError(Throwable e) {
		httpCallback.onFail(tag, e);
	}

	@Override public void onComplete() {
		httpCallback.onFinish(tag);
	}

}
