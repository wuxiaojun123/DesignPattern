package com.wxj.design.pattern.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuxiaojun on 2018/12/28.
 */

public class DecorRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

	// 原来的recyclerview.Adapter，并不支持头部和底部的添加
	private RecyclerView.Adapter	mRealAdapter;

	private List<View>				mHeadViewList	= new ArrayList<>();

	private List<View>				mFooterList		= new ArrayList<>();

	public DecorRecyclerAdapter(RecyclerView.Adapter adapter) {
		this.mRealAdapter = adapter;

		mRealAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {

			@Override public void onChanged() {
				notifyDataSetChanged();
			}
		});
	}

	@Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
		// 头部返回头部的viewHolder

		// 真实的adapter返回真实的viewHolder

		// 底部返回底部的viewHolder

		int numHeaders = getHeadersCount();
		if (position < numHeaders) {
			return createHeaderOrFooterViewHolder(mHeadViewList.get(position));
		}

		// Adapter
		final int adjPosition = position - numHeaders;
		int adapterCount = 0;
		if (mRealAdapter != null) {
			adapterCount = mRealAdapter.getItemCount();
			if (adjPosition < adapterCount) {
				return mRealAdapter.onCreateViewHolder(parent, mRealAdapter.getItemViewType(adjPosition));
			}
		}

		// Footer (off-limits positions will throw an IndexOutOfBoundsException)
		return createHeaderOrFooterViewHolder(mFooterList.get(adjPosition - adapterCount));
	}

	private RecyclerView.ViewHolder createHeaderOrFooterViewHolder(View view) {
		return new RecyclerView.ViewHolder(view) {};
	}

	public int getHeadersCount() {
		return mHeadViewList.size();
	}

	/***
	 * 将position作为viewType传递给onCreateViewHolder
	 * 
	 * @param position
	 *            位置
	 * @return viewType
	 */
	@Override public int getItemViewType(int position) {
		return position;
	}

	@Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		int numHeaders = getHeadersCount();
		if (position < numHeaders) {
			return;
		}

		// Adapter
		final int adjPosition = position - numHeaders;
		int adapterCount = 0;
		if (mRealAdapter != null) {
			adapterCount = mRealAdapter.getItemCount();
			if (adjPosition < adapterCount) {
				mRealAdapter.onBindViewHolder(holder, position);
			}
		}
	}

	@Override public int getItemCount() {
		return mHeadViewList.size() + mRealAdapter.getItemCount() + mFooterList.size();
	}

	public void addHeadView(View headView) {
		if (!mHeadViewList.contains(headView)) {
			mHeadViewList.add(headView);
			notifyDataSetChanged();
		}
	}

	public void addFooterView(View footerView) {
		if (!mFooterList.contains(footerView)) {
			mFooterList.add(footerView);
			notifyDataSetChanged();
		}
	}

	public void removeHeadView(View headView) {
		if (mHeadViewList.contains(headView)) {
			mHeadViewList.remove(headView);
			notifyDataSetChanged();
		}
	}

	public void removeFooterView(View footerView) {
		if (mFooterList.contains(footerView)) {
			mFooterList.remove(footerView);
			notifyDataSetChanged();
		}
	}

}
