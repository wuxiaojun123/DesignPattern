package com.wxj.datastructure.aop;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wxj.datastructure.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wuxiaojun on 2018/12/22.
 */

public class AOPActivity extends AppCompatActivity {

	@Override protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aop);
	}

	@CheckNet public void myclick(View view) {
		startActivity(new Intent(AOPActivity.this, AOPActivity.class));
	}

}
