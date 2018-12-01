package com.wxj.design.pattern.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wxj.design.pattern.R;
import com.wxj.design.pattern.view.MyListview;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.recyclerview.CommonAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuxiaojun on 2018/11/24.
 */

public class ViewDragHelperActivity extends Activity {

	private RecyclerView mRecyclerView;

	private List<String>	mItems;

	@Override protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewdraghelper);

		mRecyclerView = (RecyclerView) findViewById(R.id.id_listview);
		mItems = new ArrayList<>();
		for (int i = 0; i < 2000; i++) {
			mItems.add("i=" + i);
		}
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
		mRecyclerView.setAdapter(new CommonAdapter<String>(this, R.layout.item, mItems) {

			@Override public void convert(ViewHolder holder, String o) {
				holder.setText(R.id.id_info, o);
			}
		});

	}

}
