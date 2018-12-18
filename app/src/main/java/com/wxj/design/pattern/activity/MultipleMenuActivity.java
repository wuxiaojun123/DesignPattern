package com.wxj.design.pattern.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.wxj.design.pattern.R;
import com.wxj.design.pattern.adapter.ListScreenMenuAdapter;
import com.wxj.design.pattern.view.ListDataScreenView;

/**
 *
 * Created by wuxiaojun on 2018/12/1.
 */

public class MultipleMenuActivity extends Activity {

	private ListScreenMenuAdapter	menuAdapter;

	private ListDataScreenView		id_listdata_screen_view;

	@Override protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multiple_menu);
		id_listdata_screen_view = (ListDataScreenView) findViewById(R.id.id_listdata_screen_view);
		menuAdapter = new ListScreenMenuAdapter(this);

		id_listdata_screen_view.setAdapter(menuAdapter);
	}

	public void click(View view) {
		Toast.makeText(getApplicationContext(), "aaa", Toast.LENGTH_SHORT).show();
	}

}
