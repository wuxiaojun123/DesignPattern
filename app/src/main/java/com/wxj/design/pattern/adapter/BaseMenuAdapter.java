package com.wxj.design.pattern.adapter;

import android.view.View;
import android.view.ViewGroup;

/**
 * 
 * 筛选菜单 Created by wuxiaojun on 2018/12/18.
 */

public abstract class BaseMenuAdapter {

	// 获取总共有多少条
	public abstract int getCount();

	// 获取当前的TabView
	public abstract View getTabView(int position, ViewGroup parent);

	// 获取当前的菜单内容
	public abstract View getMenuView(int position, ViewGroup parent);

}
