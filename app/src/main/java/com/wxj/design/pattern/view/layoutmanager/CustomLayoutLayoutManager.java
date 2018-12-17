package com.wxj.design.pattern.view.layoutmanager;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by wuxiaojun on 2018/12/12.
 */

public class CustomLayoutLayoutManager extends RecyclerView.LayoutManager {

	@Override public RecyclerView.LayoutParams generateDefaultLayoutParams() {
		return new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT);
	}

	@Override public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
		int offset = 0;
		for (int i = 0; i < getItemCount(); i++) {
			View view = recycler.getViewForPosition(i);
			addView(view);

			measureChildWithMargins(view, 0, 0);
			int width = getDecoratedMeasuredWidth(view);
			int height = getDecoratedMeasuredHeight(view);

			layoutDecorated(view, 0, offset, width, offset + height);
			offset += height;
		}
	}

	@Override public boolean canScrollVertically() {
		return true;
	}

	@Override public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
		offsetChildrenVertical(-dy);
		return dy;
	}



}
