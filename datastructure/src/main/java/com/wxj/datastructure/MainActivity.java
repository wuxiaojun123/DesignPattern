package com.wxj.datastructure;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.wxj.datastructure.aop.AOPActivity;
import com.wxj.datastructure.http.HttpActivity;

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

	@OnClick({ R.id.id_tv_http, R.id.id_tv_aspectj }) public void onClick(View v) {
		int id = v.getId();
		switch (id) {
			case R.id.id_tv_http:
				startActivity(new Intent(MainActivity.this, HttpActivity.class));

				break;
			case R.id.id_tv_aspectj:
				startActivity(new Intent(MainActivity.this, AOPActivity.class));

				break;
		}
	}

}
