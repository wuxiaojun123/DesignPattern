package com.wxj.design.pattern.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.wxj.design.pattern.adapter.DecorRecyclerAdapter;

/**
 * Created by wuxiaojun on 2018/12/28.
 */

public class DecorRecyclerview extends RecyclerView {

	private DecorRecyclerAdapter decorRecyclerAdapter;

	public DecorRecyclerview(Context context) {
		this(context, null);
	}

	public DecorRecyclerview(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public DecorRecyclerview(Context context, @Nullable AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override public void setAdapter(Adapter adapter) {
		decorRecyclerAdapter = new DecorRecyclerAdapter(adapter);
		super.setAdapter(decorRecyclerAdapter);
	}

	public void addHeadView(View view) {
		if (decorRecyclerAdapter != null) {
			decorRecyclerAdapter.addHeadView(view);
		}
	}

	public void addFooterView(View view) {
		if (decorRecyclerAdapter != null) {
			decorRecyclerAdapter.addFooterView(view);
		}
	}

}
