package com.wxj.design.pattern.view.nested;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingChild;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 *
 * Created by wuxiaojun on 2019/1/1.
 */

public class NestedScrollChildLayout extends LinearLayout implements NestedScrollingChild {

	public NestedScrollChildLayout(Context context) {
		this(context, null);
	}

	public NestedScrollChildLayout(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public NestedScrollChildLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);


	}



}
