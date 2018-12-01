package com.wxj.design.pattern.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.LinearInterpolator;

import com.wxj.design.pattern.R;

import java.util.Map;

/**
 *
 * 1.旋转动画 6个圆旋转
 *
 * 2.聚合动画 6个圆向中间聚合
 *
 * 3.扩散动画 扩散到整个界面 先绘制一个圆，圆的半径是屏幕对角线的一半
 *
 * Created by wuxiaojun on 2018/11/20.
 */

public class YahuView extends View {

	private final int		RATION_DURATION			= 2000;

	private final int		MERGE_DURATION			= 1000;

	private int[]			mCircleColors;

	private int				mSmallCircleRadius;							// 小圆半径

	private int				mBigCircleRadius;							// 大圆半径

	private int				circleCX, circleCY;							// 大圆的中心点

	private Paint			mPaint;										// 画笔

	private LoadingState	mLoadingState;

	private float			mCurrentRotationValue	= 0f;				// 旋转动画的值

	private float			mCurrentMergeRadius		= mBigCircleRadius;	// 当前聚合动画的半径

	private float			mDiagonalRadius;							// 屏幕的对角线的一半

	private float			mSpreadRadius;								// 扩散圆的半径

	public YahuView(Context context) {
		this(context, null);
	}

	public YahuView(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public YahuView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		mCircleColors = getContext().getResources().getIntArray(R.array.splash_circle_colors);

		mPaint = new Paint();
		mPaint.setStyle(Paint.Style.FILL);
	}

	@Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		mSmallCircleRadius = getMeasuredWidth() / 26;
		mBigCircleRadius = getMeasuredWidth() / 3;

		circleCX = getMeasuredWidth() / 2;
		circleCY = getMeasuredHeight() / 2;

		mDiagonalRadius = (float) Math.sqrt((circleCX * circleCY + circleCY * circleCY));
	}

	@Override protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (mLoadingState == null) {
			mLoadingState = new RotationAnimator();
		}

		mLoadingState.draw(canvas);
	}

	public void disapear() {
		// 关闭旋转动画
		if (mLoadingState instanceof RotationAnimator) {
			((RotationAnimator) mLoadingState).cancel();
		}
		// 开启聚合动画
		mLoadingState = new MergeAnimator();

	}

	private abstract class LoadingState {

		abstract void draw(Canvas canvas);
	}

	private class ExpendAnimator extends LoadingState {

		private ValueAnimator valueAnimator;

		public ExpendAnimator() {
			init();
		}

		private void init() {
			valueAnimator = ValueAnimator.ofFloat(0, mDiagonalRadius);
			valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

				@Override public void onAnimationUpdate(ValueAnimator animation) {
					mSpreadRadius = (float) animation.getAnimatedValue();
					invalidate();
				}
			});
			valueAnimator.setDuration(RATION_DURATION);
			valueAnimator.start();
		}

		@Override void draw(Canvas canvas) {
			mPaint.setColor(Color.WHITE);
			canvas.drawCircle(circleCX, circleCY, mSpreadRadius, mPaint);
		}

	}

	private class MergeAnimator extends LoadingState {

		private ValueAnimator valueAnimator;

		public MergeAnimator() {
			init();
		}

		private void init() {
			valueAnimator = ValueAnimator.ofFloat(mBigCircleRadius, 0);
			valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

				@Override public void onAnimationUpdate(ValueAnimator animation) {
					mCurrentMergeRadius = (float) animation.getAnimatedValue();
					invalidate();
				}
			});
			valueAnimator.addListener(new AnimatorListenerAdapter() {

				@Override public void onAnimationEnd(Animator animation) {
					mLoadingState = new ExpendAnimator();
				}
			});
			// 开始的时候向后，然后向前甩
			valueAnimator.setInterpolator(new AnticipateInterpolator(3f));
			valueAnimator.setDuration(MERGE_DURATION);
			valueAnimator.start();
		}

		@Override void draw(Canvas canvas) {
			/***
			 * 这里需要绘制6个圆，然后就得计算每个圆的圆心点，每个圆的x,y的位置该怎么计算呢？
			 * 首先把一个圆整分为6份(因为总共是6个颜色，你也可以根据你的需求划分)， 然后通过画图得知，第一个圆的x=大圆中心点x的坐标+（cosA * 半径）
			 * y=大圆中心点y+(sinA * 半径)
			 */
			double percent = 2 * Math.PI / mCircleColors.length;

			for (int i = 0; i < mCircleColors.length; i++) {
				// 当前的角度=初始角度+旋转角度（percent * i+mCurrentRotationValue）
				float cx = (float) (circleCX + (Math.cos(percent * i + mCurrentRotationValue) * mCurrentMergeRadius));
				float cy = (float) (circleCY + Math.sin(percent * i + mCurrentRotationValue) * mCurrentMergeRadius);

				mPaint.setColor(mCircleColors[i]);
				canvas.drawCircle(cx, cy, mSmallCircleRadius, mPaint);
			}
		}

	}

	private class RotationAnimator extends LoadingState {

		private ValueAnimator mValueAnimator;

		public RotationAnimator() {
			init();
		}

		private void init() {
			mValueAnimator = ValueAnimator.ofFloat(0f, (float) (2f * Math.PI));
			mValueAnimator.setDuration(RATION_DURATION);
			mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

				@Override public void onAnimationUpdate(ValueAnimator animation) {
					mCurrentRotationValue = (float) animation.getAnimatedValue();
					invalidate();
				}
			});
			mValueAnimator.setRepeatCount(ValueAnimator.INFINITE);
			mValueAnimator.setInterpolator(new LinearInterpolator());
			mValueAnimator.start();
		}

		@Override void draw(Canvas canvas) {
			/***
			 * 这里需要绘制6个圆，然后就得计算每个圆的圆心点，每个圆的x,y的位置该怎么计算呢？
			 * 首先把一个圆整分为6份(因为总共是6个颜色，你也可以根据你的需求划分)， 然后通过画图得知，第一个圆的x=大圆中心点x的坐标+（cosA * 半径）
			 * y=大圆中心点y+(sinA * 半径)
			 */
			double percent = 2 * Math.PI / mCircleColors.length;

			for (int i = 0; i < mCircleColors.length; i++) {
				// 当前的角度=初始角度+旋转角度（percent * i+mCurrentRotationValue）
				float cx = (float) (circleCX + (Math.cos(percent * i + mCurrentRotationValue) * mBigCircleRadius));
				float cy = (float) (circleCY + Math.sin(percent * i + mCurrentRotationValue) * mBigCircleRadius);

				mPaint.setColor(mCircleColors[i]);
				canvas.drawCircle(cx, cy, mSmallCircleRadius, mPaint);
			}
		}

		public void cancel() {
			mValueAnimator.cancel();
		}

	}

}
