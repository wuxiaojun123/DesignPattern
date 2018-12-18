package com.wxj.design.pattern.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wuxiaojun on 2018/12/17.
 */

public class HuaweiLoadingView extends View {

	public HuaweiLoadingView(Context context) {
		this(context, null);
	}

	public HuaweiLoadingView(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public HuaweiLoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

	}

	@Override protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);


	}

}
