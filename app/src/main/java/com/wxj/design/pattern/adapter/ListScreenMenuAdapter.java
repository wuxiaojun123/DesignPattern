package com.wxj.design.pattern.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wxj.design.pattern.R;

/**
 * Created by wuxiaojun on 2018/12/18.
 */

public class ListScreenMenuAdapter extends BaseMenuAdapter {

	private String[]	mItems	= { "类型", "品牌", "价格", "更多" };

	private Context		mContext;

	public ListScreenMenuAdapter(Context context) {
		this.mContext = context;
	}

	@Override public int getCount() {
		return mItems.length;
	}

	@Override public View getTabView(int position, ViewGroup parent) {
		TextView view = (TextView) LayoutInflater.from(mContext).inflate(R.layout.ui_list_data_screen_tab, parent, false);
		view.setText(mItems[position]);
		view.setTextColor(Color.BLACK);
		return view;
	}

	@Override public View getMenuView(int position, ViewGroup parent) {
		LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.ui_list_data_screen_menu, parent, false);
		TextView id_tv_content = (TextView) linearLayout.findViewById(R.id.id_tv_content);
		id_tv_content.setText(mItems[position]);
		id_tv_content.setOnClickListener(new View.OnClickListener() {

			@Override public void onClick(View v) {
				// 通知ListDataScreenView去关闭菜单，如何做呢？

				// 第一种：可以在Activity中监听点击事件，因为Activity中有ListDataScreenView和ListScreenMenuAdapter两个对象，这样就可以轻松达到目标

				// 第二种：可以把ListDataScreenView传递到ListScreenMenuAdapter中，这样也可以达到目标，但是耦合度很高

				// 第三种：通过观察者模式来解决(有观察者和被观察者)
				closeMenu();
			}
		});

		return linearLayout;
	}

	@Override public void menuOpen(View tabView) {
		TextView textView = (TextView) tabView;
		textView.setTextColor(Color.RED);
	}

	@Override public void menuClose(View tabView) {
		TextView textView = (TextView) tabView;
		textView.setTextColor(Color.BLACK);
	}

}
