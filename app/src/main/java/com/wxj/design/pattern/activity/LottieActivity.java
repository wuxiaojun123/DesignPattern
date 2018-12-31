package com.wxj.design.pattern.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.airbnb.lottie.LottieAnimationView;
import com.wxj.design.pattern.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wuxiaojun on 2018/12/31.
 */

public class LottieActivity extends Activity {

	@BindView(R.id.id_liwu)
	LottieAnimationView id_liwu;

	@Override protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lottie);
		ButterKnife.bind(this);

		id_liwu.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
//				Log.e("update",animation.getAnimatedValue()+"");
			}
		});

		id_liwu.addAnimatorListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				Log.e("zhixing","动画执行完成");
			}

			@Override
			public void onAnimationStart(Animator animation) {
				super.onAnimationStart(animation);
				Log.e("zhixing","动画开始执行");
			}
		});
	}

}
