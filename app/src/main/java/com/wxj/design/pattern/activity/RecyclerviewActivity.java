package com.wxj.design.pattern.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wxj.design.pattern.R;
import com.wxj.design.pattern.adapter.DecorRecyclerAdapter;
import com.wxj.design.pattern.view.DecorRecyclerview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuxiaojun on 2018/11/22.
 */

public class RecyclerviewActivity extends Activity {

	private DecorRecyclerview	id_recyclerview;

	private List<String>		mList	= new ArrayList<>();

	@Override protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recycler);

		for (int i = 0; i < 100; i++) {
			mList.add("position=" + i);
		}

		id_recyclerview = (DecorRecyclerview) findViewById(R.id.id_recyclerview);
		id_recyclerview.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
		id_recyclerview.setLayoutManager(new LinearLayoutManager(this));

		MyAdapter adapter = new MyAdapter();
		id_recyclerview.setAdapter(adapter);
		View view = LayoutInflater.from(this).inflate(R.layout.item_head, id_recyclerview, false);
		id_recyclerview.addHeadView(view);
		// 业务逻辑层，能分开就分开，比如说注册页面和绑定用户手机页面，就是非常相似的业务逻辑，一定不要去封装
		// 不包含业务逻辑的，一定要封装
	}

	private class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

		@Override public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text, parent, false);

			return new MyViewHolder(view);
		}

		@Override public void onBindViewHolder(MyViewHolder holder, final int position) {
			holder.textView.setText("position=" + mList.get(position));

			holder.textView.setOnClickListener(new View.OnClickListener() {

				@Override public void onClick(View v) {
					mList.remove(position);
					notifyDataSetChanged();
				}
			});
		}

		@Override public int getItemCount() {
			return mList.size();
		}

	}

	private class MyViewHolder extends RecyclerView.ViewHolder {

		public TextView textView;

		public MyViewHolder(View itemView) {
			super(itemView);

			textView = (TextView) itemView.findViewById(R.id.id_info);
		}
	}

}
