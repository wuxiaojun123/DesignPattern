package com.wxj.datastructure.http;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.wxj.datastructure.R;
import com.wxj.datastructure.http.presenter.HttpPresenter;
import com.wxj.datastructure.http.view.IView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 第一：每次都要写回调
 * 第二：
 *
 * Created by wuxiaojun on 2018/12/26.
 */

public class HttpActivity extends AppCompatActivity implements IView {

	@BindView(R.id.id_tv_content) TextView	id_tv_content;

	private HttpPresenter					httpPresenter;

	@Override protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_http);
		ButterKnife.bind(this);

		httpPresenter = new HttpPresenter(this);
	}

	@OnClick({ R.id.id_btn_request }) public void click(View view) {
		int id = view.getId();
		switch (id) {
			case R.id.id_btn_request:
				httpPresenter.requestZhuangbi();

				break;
		}
	}

}
