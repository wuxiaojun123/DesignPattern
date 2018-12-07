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

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// 解决显示不全的问题,具体在listview的源码里面
		// 为何要右移两位，因为Integer.MAC_VALUE是一个32位的值，只有加上测量模式才能拼成32位的值

		heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
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
