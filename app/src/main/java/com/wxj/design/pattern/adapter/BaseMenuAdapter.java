package com.wxj.design.pattern.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.wxj.design.pattern.observe.MenuObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 筛选菜单 Created by wuxiaojun on 2018/12/18.
 */

public abstract class BaseMenuAdapter {

	// 微信公众号
	private MenuObserver menuObserver;

	public void registerMenuObserver(MenuObserver menuObserver) {
		this.menuObserver = menuObserver;
	}

	public void unRegisterMenuObserver() {
		this.menuObserver = null;
	}

	public void closeMenu() {
		if (menuObserver != null) {
			menuObserver.closeMenu();
		}
	}

	// 获取总共有多少条
	public abstract int getCount();

	// 获取当前的TabView
	public abstract View getTabView(int position, ViewGroup parent);

	// 获取当前的菜单内容
	public abstract View getMenuView(int position, ViewGroup parent);

	/***
	 * 菜单打开
	 * 
	 * @param tabView
	 */
	public void menuOpen(View tabView) {

	}

	/**
	 * 8 菜单关闭
	 * 
	 * @param childAt
	 */
	public void menuClose(View childAt) {

	}

}
