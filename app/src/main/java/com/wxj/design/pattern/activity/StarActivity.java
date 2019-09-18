package com.wxj.design.pattern.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.wxj.design.pattern.R;
import com.wxj.design.pattern.view.RingView;
import com.wxj.design.pattern.view.StarLayout;
import com.wxj.design.pattern.view.StarView;
import com.wxj.design.pattern.view.StarView2;
import com.wxj.design.pattern.view.StarView3;
import com.wxj.design.pattern.view.StarView4;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wuxiaojun on 2019/1/9.
 */

public class StarActivity extends AppCompatActivity {

	@BindView(R.id.id_fl_content) FrameLayout	id_fl_content;

	@BindView(R.id.id_starview) StarView4		id_starview;

	@BindView(R.id.id_star_layout) StarLayout	id_star_layout;

	@Override protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_star);
		ButterKnife.bind(this);

	}

	@OnClick({ R.id.id_start }) public void click(View view) {
		int id = view.getId();
		switch (id) {
			case R.id.id_start:
				 id_starview.clearAnimation();
				 id_starview.startAnimation(10, 3000, 0);
				id_star_layout.startRingAnim();

				break;
		}
	}

}
