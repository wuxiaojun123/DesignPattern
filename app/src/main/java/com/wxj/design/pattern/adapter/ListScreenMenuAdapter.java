package com.wxj.design.pattern.adapter;

import android.content.Context;
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
		return view;
	}

	@Override public View getMenuView(int position, ViewGroup parent) {
		LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.ui_list_data_screen_menu, parent, false);
		TextView id_tv_content = (TextView) linearLayout.findViewById(R.id.id_tv_content);
		id_tv_content.setText(mItems[position]);
		return linearLayout;
	}

}
