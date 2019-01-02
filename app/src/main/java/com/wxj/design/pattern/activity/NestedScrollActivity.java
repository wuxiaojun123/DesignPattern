package com.wxj.design.pattern.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wxj.design.pattern.R;

import butterknife.ButterKnife;

/**
 * https://www.cnblogs.com/wjtaigwh/p/6398562.html
 *
 * https://blog.csdn.net/industriously/article/details/70337940
 *
 * https://blog.csdn.net/al4fun/article/details/53888990
 *
 * Created by wuxiaojun on 2019/1/1.
 */

public class NestedScrollActivity extends AppCompatActivity {

	@Override protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_scroll);

		ButterKnife.bind(this);


	}

}
