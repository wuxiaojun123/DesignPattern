package com.wxj.design.pattern.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;

import com.wxj.design.pattern.R;

/**
 * 58加载数据 Created by wuxiaojun on 2018/12/17.
 */

public class WuBaLoadingView extends LinearLayout {

	private final int	DURATION	= 500;

	private ShapeView	mShapeView;			// 形状

	private View		mShadowView;		// 中间的阴影

	private float		mTranslationY;

	private boolean		mIsStopAnimator;

	public WuBaLoadingView(Context context) {
		this(context, null);
	}

	public WuBaLoadingView(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public WuBaLoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		mTranslationY = dipToPx(100);
		initLayout();
	}

	private void initLayout() {
		// 加载写好的loading_view
		// 1.1实例化view
		// View loadingView = inflate(getContext(), R.layout.layout_wuba_anim, null);
		// addView(loadingView);
		// 这里传的this代表把layout_wuba_anim添加到WuBaLoadingView中
		// 1.2添加到该view
		inflate(getContext(), R.layout.layout_wuba_anim, this);
		mShapeView = (ShapeView) findViewById(R.id.id_shape_view);
		mShadowView = findViewById(R.id.id_shadow_view);

		post(new Runnable() {

			@Override public void run() {
				// onResume之后view绘制流程执行完毕之后 (view的绘制流程源码分析那一章)
				startFallAnimator();
			}
		});
	}

	/***
	 * 下落动画
	 */
	private void startFallAnimator() {
		if (mIsStopAnimator) {
			return;
		}
		ObjectAnimator translation = ObjectAnimator.ofFloat(mShapeView, "translationY", 0, mTranslationY);

		ObjectAnimator scaleAnimation = ObjectAnimator.ofFloat(mShadowView, "scaleX", 1f, 0.3f);

		// 组合动画
		AnimatorSet animatorSet = new AnimatorSet();
		animatorSet.setInterpolator(new AccelerateInterpolator());
		animatorSet.setDuration(DURATION);
		animatorSet.playTogether(translation, scaleAnimation);
		animatorSet.start();

		// 下落完之后就上抛
		animatorSet.addListener(new AnimatorListenerAdapter() {

			@Override public void onAnimationEnd(Animator animation) { // 开启上抛动画
				mShapeView.exchange();
				startUpAnimator();

			}
		});
	}

	private void startUpAnimator() {
		if (mIsStopAnimator) {
			return;
		}
		ObjectAnimator translation = ObjectAnimator.ofFloat(mShapeView, "translationY", mTranslationY, 0);
		ObjectAnimator rotation = startRotationAnimator();

		ObjectAnimator scaleAnimation = ObjectAnimator.ofFloat(mShadowView, "scaleX", 0.3f, 1f);
		AnimatorSet animatorSet = new AnimatorSet();
		animatorSet.setInterpolator(new DecelerateInterpolator());
		animatorSet.setDuration(DURATION);
		animatorSet.playTogether(translation, scaleAnimation, rotation);

		animatorSet.addListener(new AnimatorListenerAdapter() {

			@Override public void onAnimationEnd(Animator animation) {
				// 下落动画
				startFallAnimator();
			}
		});

		animatorSet.start();
	}

	private ObjectAnimator startRotationAnimator() {
		int angle = 0;
		switch (mShapeView.getShape()) {
			case Circle:
			case Square:
				angle = 180;

				break;
			case Triangle:
				angle = -180;

				break;
		}
		ObjectAnimator rotation = ObjectAnimator.ofFloat(mShapeView, "rotation", 0, angle);
		return rotation;
	}

	@Override public void setVisibility(int visibility) {
		// 虽然把view设置为gone了，但是动画还在运行，需要取消
		super.setVisibility(View.INVISIBLE); // 不要再去摆放和计算，少走一些系统的源码(view的绘制流程)
		// 清理动画
		mShapeView.clearAnimation();
		mShadowView.clearAnimation();
		// 将loadingView从父布局移除
		ViewGroup viewGroup = (ViewGroup) getParent();
		if (viewGroup != null) {
			viewGroup.removeView(this);
			removeAllViews();
		}

		mIsStopAnimator = true;
	}

	private float dipToPx(int i) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, i, getResources().getDisplayMetrics());
	}

}
