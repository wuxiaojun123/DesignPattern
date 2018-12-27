package com.wxj.datastructure.http.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.wxj.datastructure.bean.HttpResult;
import com.wxj.datastructure.http.callback.ApiCallBack;
import com.wxj.datastructure.http.callback.HttpCallback;
import com.wxj.datastructure.http.inter.HttpCallBack;
import com.wxj.datastructure.http.service.ApiService;
import com.wxj.datastructure.http.service.RetrofitManager;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

/**
 * Created by wuxiaojun on 2018/12/26.
 */

public class BasePresenter<V> implements HttpCallback {

	protected V					mView;

	protected ApiService		apiService;

	private CompositeDisposable	compositeDisposable;

	public void attachView(V view) {
		this.mView = view;
		apiService = RetrofitManager.getInstance().getRetrofit().create(ApiService.class);
	}

	protected void unSubscription() {
		if (null != compositeDisposable) {
			compositeDisposable.dispose();
		}
	}

	protected HttpResult errorHandler(Throwable errormsg) throws Exception {
		ResponseBody requestBody = ((HttpException) errormsg).response().errorBody();
		String result = requestBody.string();
		Gson gson = new Gson();
		HttpResult Response = gson.fromJson(result, HttpResult.class);
		return Response;
	}

	@SuppressWarnings("unchecked") protected void subscription(Observable observable, DisposableObserver disposableObserver) {
		if (null == compositeDisposable) {
			compositeDisposable = new CompositeDisposable();
		}
		compositeDisposable.add(disposableObserver);
		observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(disposableObserver);
	}

	public <M> void request(Flowable<M> flowable, String tag) {
		if (null == compositeDisposable) {
			compositeDisposable = new CompositeDisposable();
		}
		flowable = flowable.compose(new FlowableTransformer() {

			@Override public Publisher apply(Flowable upstream) {
				return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
			}
		});
		compositeDisposable.add(flowable.subscribeWith(new ApiCallBack<M>(tag, this)));
	}

	@Override public void onSuccess(String tag, Object model) {
		Log.e("BasePresenter", "tag=" + tag + "model=" + model);
	}

	@Override public void onFail(String tag, Throwable errormsg) {

	}

	@Override public void onFinish(String tag) {

	}

}
