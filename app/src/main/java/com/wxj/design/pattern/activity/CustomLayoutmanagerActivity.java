package com.wxj.design.pattern.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.wxj.design.pattern.R;
import com.wxj.design.pattern.view.layoutmanager.CustomLayoutLayoutManager;

/**
 * Created by wuxiaojun on 2018/12/10.
 */

public class CustomLayoutmanagerActivity extends AppCompatActivity {

	private RecyclerView recyclerView;

	@Override protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_layout);

		recyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
		recyclerView.setLayoutManager(new CustomLayoutLayoutManager());

	}

}
