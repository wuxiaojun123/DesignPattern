package com.wxj.design.pattern.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wxj.design.pattern.R;

/**
 * Created by wuxiaojun on 2019/1/4.
 */

public class RippleActivity extends Activity {

	@Override protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ripple);

	}

}
