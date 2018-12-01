package com.wxj.design.pattern.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by wuxiaojun on 2018/12/1.
 */

public class ListDataScreenView extends LinearLayout {



	public ListDataScreenView(Context context) {
		this(context, null);
	}

	public ListDataScreenView(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public ListDataScreenView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		initLayout();
	}

	/***
	 * 布局实例化(组合控件)
	 */
	private void initLayout() {

		// 1.1创建头部布局 存放tab

		// 1.2 创建FramLayout用来存放 = 阴影+菜单内容布局(FramLayout)

	}

}
