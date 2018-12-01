package com.wxj.design.pattern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;

import java.util.List;

/**
 * Created by wuxiaojun on 2018/11/24.
 */

public class MyListview extends ListView {

	private static final String TAG = "MyListview";

	public MyListview(Context context) {
		this(context, null);
	}

	public MyListview(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public MyListview(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override public boolean dispatchTouchEvent(MotionEvent ev) {
		boolean flag = super.dispatchTouchEvent(ev);
//		Log.e(TAG, "dispatchTouchEvent==========" + flag);
		return flag;
	}

	@Override public boolean onInterceptTouchEvent(MotionEvent ev) {
		boolean flag = super.onInterceptTouchEvent(ev);
//		Log.e(TAG, "onInterceptTouchEvent==========" + flag);
		return flag;
	}

	@Override public boolean onTouchEvent(MotionEvent ev) {
		boolean flag = super.onTouchEvent(ev);
//		Log.e(TAG, "onTouchEvent==========" + flag);
		return flag;
	}

}
