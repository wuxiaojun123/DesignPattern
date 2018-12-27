package com.wxj.datastructure.http.presenter;

import android.util.Log;
import android.view.View;

import com.wxj.datastructure.bean.HttpResult;
import com.wxj.datastructure.bean.ZhuangbiImage;
import com.wxj.datastructure.http.callback.ApiCallBack;
import com.wxj.datastructure.http.view.IView;

import java.util.List;

/**
 *
 * 不同的网络请求，返回的实体类不一样 如果根据tag来获取不同的实体类呢？
 *
 * Created by wuxiaojun on 2018/12/26.
 */

public class HttpPresenter extends BasePresenter {

	public HttpPresenter(IView view) {
		attachView(view);
	}

	public void requestZhuangbi() {
		request(apiService.search("装逼"), "zhuangbi");

		request(apiService.search("可爱"), "keai");
	}

	// @Override
	// public void onSuccess(String tag, Object model) {
	// super.onSuccess(tag, model);
	// Log.e("HttpPresenter", "tag=" + tag + "--model=" + model);
	// }

	@Override public void onSuccess(String tag, Object model) {
		super.onSuccess(tag, model);
		if (tag.equals("zhuangbi")) {
			List<ZhuangbiImage> zhuangbiImages = (List<ZhuangbiImage>) model;
			for (ZhuangbiImage zhuangbiImage : zhuangbiImages) {
				Log.e("zhuangbi", zhuangbiImage.image_url);
			}
		}

	}

	//

}
