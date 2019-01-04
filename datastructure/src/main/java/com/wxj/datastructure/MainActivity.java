package com.wxj.datastructure;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.wxj.datastructure.aop.AOPActivity;
import com.wxj.datastructure.constraint.ConstraintActivity;
import com.wxj.datastructure.http.HttpActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/****
 * 
 * 系统架构篇
 * 
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	@BindView(R.id.id_tv_http) TextView		id_tv_http;

	@BindView(R.id.id_tv_aspectj) TextView	id_tv_aspectj;

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

	}

	@Override protected void onStart() {
		super.onStart();

		EventBus.getDefault().register(this);
	}

	@OnClick({ R.id.id_tv_http, R.id.id_tv_aspectj, R.id.id_tv_constraint }) public void onClick(View v) {
		int id = v.getId();
		switch (id) {
			case R.id.id_tv_http:
				startActivity(new Intent(MainActivity.this, HttpActivity.class));

				break;
			case R.id.id_tv_aspectj:
				startActivity(new Intent(MainActivity.this, AOPActivity.class));

				break;
			case R.id.id_tv_constraint:
				startActivity(new Intent(MainActivity.this, ConstraintActivity.class));

				break;
		}
	}

	@Subscribe(threadMode = ThreadMode.MAIN,priority = 100) private void updateText(String msg) {
		id_tv_http.setText(msg);
	}

	@Override protected void onStop() {
		super.onStop();

		EventBus.getDefault().unregister(this);
	}
}
