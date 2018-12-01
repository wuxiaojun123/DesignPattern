package com.wxj.design.pattern.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

import com.wxj.design.pattern.R;
import com.wxj.design.pattern.view.YahuView;

/**
 * 仿照雅虎效果 Created by wuxiaojun on 2018/11/22.
 */

public class YahuActivity extends Activity {

	@Override protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_yahu);

		final YahuView yahuView = (YahuView) findViewById(R.id.id_yahuview);

		new Handler() {

			@Override public void handleMessage(Message msg) {
				yahuView.disapear();
			}
		}.sendEmptyMessageDelayed(1, 5000);
	}

}
