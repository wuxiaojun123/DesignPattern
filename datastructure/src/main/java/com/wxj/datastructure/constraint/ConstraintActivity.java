package com.wxj.datastructure.constraint;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.ViewDragHelper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.wxj.datastructure.DragTextView;
import com.wxj.datastructure.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wuxiaojun on 2019/1/2.
 */

public class ConstraintActivity extends AppCompatActivity {

	private final static String				TAG	= "ConstraintActivity";

	@BindView(R.id.id_tv_text)
	DragTextView id_tv_text;

	@BindView(R.id.id_btn_right) Button		id_btn_right;

	@BindView(R.id.id_btn_left) Button		id_btn_left;

	@BindView(R.id.id_webview) WebView		id_webview;

	@BindView(R.id.id_fl_video) FrameLayout	id_fl_video;

	@Override protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_constraint);
		ButterKnife.bind(this);

		id_webview.getSettings().setJavaScriptEnabled(true);
		id_webview.loadUrl("https://www.baidu.com/");

		ViewDragHelper viewDragHelper = ViewDragHelper.create(id_fl_video, 1.0f, new ViewCallback());
	}

	@OnClick({ R.id.id_btn_right, R.id.id_btn_left }) public void click(View view) {
		int id = view.getId();
		switch (id) {
			case R.id.id_btn_right:
				moveTextView(1);

				break;
			case R.id.id_btn_left:
				moveTextView(0);

				break;
		}
	}

	private void moveTextView(int direction) {
		int leftMargins;
		FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) id_tv_text.getLayoutParams();
		layoutParams.width = 200;
		layoutParams.height = 200;

		if (direction == 0) { // 左边
			leftMargins = layoutParams.leftMargin - 10;
			Log.e(TAG, "左边" + leftMargins);
			layoutParams.setMargins(leftMargins, layoutParams.topMargin, 0, 0);
			id_tv_text.setLayoutParams(layoutParams);

		} else if (direction == 1) { // 右边
			leftMargins = layoutParams.leftMargin + 10;
			Log.e(TAG, "左边" + leftMargins);
			layoutParams.setMargins(leftMargins, layoutParams.topMargin, 0, 0);
			id_tv_text.setLayoutParams(layoutParams);

		}
	}

	private class ViewCallback extends ViewDragHelper.Callback {

		@Override public boolean tryCaptureView(@NonNull View view, int i) {
			return false;
		}

	}

}
