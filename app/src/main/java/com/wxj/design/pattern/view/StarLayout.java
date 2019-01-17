package com.wxj.design.pattern.view;

import com.wxj.design.pattern.R;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 *
 * 改进的地方：1.小星星出现的有点突兀，需要在大星星下盖住小星星，然后先出现右上角的星星出去。
 *
 * Created by wuxiaojun on 2019/1/15.
 */

public class StarLayout extends FrameLayout {

	private ImageView	idIvBigStar;			// 大星星

	private RingView	idRingView;				// 圆环

	private StarView4	idSmallStarListView;	// 所有的小星星

	public StarLayout(@NonNull Context context) {
		this(context, null);
	}

	public StarLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public StarLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		inflate(context, R.layout.layout_star, this);

		idIvBigStar = (ImageView) findViewById(R.id.id_iv_big_star);
		idRingView = (RingView) findViewById(R.id.id_ringview);
		idSmallStarListView = (StarView4) findViewById(R.id.id_starview);
	}

	public void startRingAnim() {
		idIvBigStar.setAlpha(0f);
		idRingView.startAnim(400);
		startBigStarScaleAnim(1500,0).start();

		idSmallStarListView.startAnimation(10, 1500, 300);
	}

	private Animator startBigStarScaleAnim(int duration,int startDelay) {
		ValueAnimator valueAnimator = ValueAnimator.ofFloat(1f, 98f, 118f);

		valueAnimator.setInterpolator(new BounceInterpolator());
		valueAnimator.addListener(new AnimatorListenerAdapter() {

			@Override public void onAnimationEnd(Animator animation) {

			}

			@Override public void onAnimationStart(Animator animation) {
				idIvBigStar.setAlpha(1f);
			}
		});
		valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

			@Override public void onAnimationUpdate(ValueAnimator animation) {
				float value = (float) animation.getAnimatedValue();
				idIvBigStar.setScaleX(value);
				idIvBigStar.setScaleY(value);
			}
		});
		valueAnimator.setDuration(duration);
		valueAnimator.setStartDelay(startDelay);
		return valueAnimator;
	}

	// private Animator startBitStarAlphaAnim() {
	// final ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);
	// valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
	//
	// @Override public void onAnimationUpdate(ValueAnimator animation) {
	// float alpha = (float) valueAnimator.getAnimatedValue();
	// idIvBigStar.setAlpha(alpha);
	// }
	// });
	// valueAnimator.setDuration(1000);
	// valueAnimator.setStartDelay(500);
	// return valueAnimator;
	// }

}
