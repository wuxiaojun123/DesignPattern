package com.wxj.design.pattern.view;

import com.wxj.design.pattern.R;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;

/**
 * Created by wuxiaojun on 2019/1/9.
 */

public class StarView3 extends View {

	private final static String	TAG	= "starView3";

	private Paint				mPaint;

	private ValueAnimator		mValueAnimator;

	private float				mCurrentProgress;	// 当前进度

	private int					mCenterX, mCenterY;	// 中心点

	private Bitmap				mStar;				// 星星图片

	private float				mRadius;			// 半径

	private StarBean[]			mStarBeans;

	public StarView3(Context context) {
		this(context, null);
	}

	public StarView3(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public StarView3(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		mPaint = new Paint();
		mPaint.setAntiAlias(true);

		mStar = BitmapFactory.decodeResource(getResources(), R.mipmap.stars1);
		// 图片宽和高是32x32
		Log.e(TAG, "2图片宽高是" + mStar.getWidth() + "--" + mStar.getHeight());
	}

	@Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		mCenterX = getMeasuredWidth() / 2 - mStar.getWidth() / 2; // 90
		mCenterY = getMeasuredHeight() / 2 - mStar.getHeight() / 2; // 90

		mRadius = mCenterX;
	}

	@Override protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (mStarBeans == null) {
			return;
		}

		for (StarBean starBean : mStarBeans) {
			// 计算左边和上边的距离
			float left = (float) (mCenterX + starBean.mStartX + Math.cos(starBean.mStarAngle) * (Math.abs(mRadius - Math.abs(starBean.mStartX))) * mCurrentProgress); // 初始角度
			float top = (float) (mCenterY + starBean.mStartY + Math.sin(starBean.mStarAngle) * (Math.abs(mRadius - Math.abs(starBean.mStartY))) * mCurrentProgress);

			starBean.mMatrix.setTranslate(left, top);
			float sx = (1 - (mCurrentProgress > 0 ? (mCurrentProgress / starBean.mAlphaMutiple) : mCurrentProgress));
			if (sx < 0) {
				sx = 0;
			}
			// if (mCurrentProgress >= starBean.mStartScale) {
//			starBean.mMatrix.preScale(sx, sx);
			starBean.mMatrix.preScale(1-mCurrentProgress,1-mCurrentProgress);
			// }
			canvas.drawBitmap(starBean.mIcon, starBean.mMatrix, mPaint);

		}
	}

	public void startAnimation(int length, int duration, int delay) {
		if (mValueAnimator != null) {
			mValueAnimator.setStartDelay(delay);
			mValueAnimator.start();
			return;
		}
		initData(length);
		mCurrentProgress = 0f;
		invalidate();

		mValueAnimator = ValueAnimator.ofFloat(0f, 1f);
		mValueAnimator.setInterpolator(new LinearInterpolator());
		mValueAnimator.setDuration(duration);

		mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

			@Override public void onAnimationUpdate(ValueAnimator animation) {
				mCurrentProgress = (float) animation.getAnimatedValue();
				invalidate();
			}
		});
		mValueAnimator.setStartDelay(delay);
		mValueAnimator.start();
	}

	private void initData(int length) {
		mStarBeans = new StarBean[length];
		float distancePercent = mCenterX / length;

		Log.e(TAG, "mCenterX=" + mCenterX + "mCenterY=" + mCenterY + "getMeasureWidth" + getMeasuredWidth() + "getMeasureHeight" + getMeasuredHeight());

		// 弧度=度*π/180
		for (int i = 0; i < length; i++) {
			float angle = 0f;
			float startX = 0f;
			float startY = 0f;
			int width = mStar.getWidth();
			int height = mStar.getHeight();
			float mAlphaMutiple = 1; // 总共是19
			float startScale = 0f; // 开始缩放
			Matrix matrix = new Matrix();

			if (i == 0) {
				angle = (float) ((10 + 270) * Math.PI / 180);
				startX = (float) Math.cos(angle) * mCenterX * 0.05f;
				startY = (float) Math.sin(angle) * mCenterY * 0.5f;
				mAlphaMutiple = 0.5789f;

			} else if (i == 1) {
				angle = (float) ((30 + 270) * Math.PI / 180);
				startX = (float) Math.cos(angle) * mCenterX * 0.1f;
				startY = (float) Math.sin(angle) * mCenterY * 0.2f;
				mAlphaMutiple = 0.7368f;

			} else if (i == 2) {
				angle = (float) ((40 + 270) * Math.PI / 180);
				startX = (float) Math.cos(angle) * mCenterX * 0.25f;
				startY = (float) Math.sin(angle) * mCenterY * 0.4f;
				mAlphaMutiple = 0.5789f;

			} else if (i == 3) {
				angle = (float) ((60 + 270) * Math.PI / 180);
				startX = (float) Math.cos(angle) * mCenterX * 0.3f;
				startY = (float) Math.sin(angle) * mCenterY * 0.33f;
				mAlphaMutiple = 0.5263f;

			} else if (i == 4) { // 星星变小
				angle = (float) ((50) * Math.PI / 180);
				startX = (float) Math.cos(angle) * mCenterX * 0.6f;
				startY = (float) Math.sin(angle) * mCenterY * 0.7f;
				width = (int) (width * 0.8f);
				height = (int) (height * 0.8f);
				mAlphaMutiple = 0.3157f; // 8

			} else if (i == 5) { // 星星变更小
				angle = (float) ((80) * Math.PI / 180);
				startX = (float) Math.cos(angle) * mCenterX * 0.05f;
				startY = (float) Math.sin(angle) * mCenterY * 0.3f;
				width = (int) (width * 0.7f);
				height = (int) (height * 0.7f);
				mAlphaMutiple = 0.4210f;

			} else if (i == 6) {
				angle = (float) ((145) * Math.PI / 180);
				startX = (float) Math.cos(angle) * mCenterX * 0.5f;
				startY = (float) Math.sin(angle) * mCenterY * 0.28f;
				mAlphaMutiple = 0.5263f;

			} else if (i == 7) {
				angle = (float) ((205) * Math.PI / 180);
				startX = (float) Math.cos(angle) * mCenterX * 0.5f;
				startY = (float) Math.sin(angle) * mCenterY * 0.15f;
				width = (int) (width * 0.8f);
				height = (int) (height * 0.8f);
				mAlphaMutiple = 0.4210f;

			} else if (i == 8) {
				angle = (float) ((215) * Math.PI / 180);
				startX = (float) Math.cos(angle) * mCenterX * 0.8f;
				startY = (float) Math.sin(angle) * mCenterY * 0.35f;
				mAlphaMutiple = 0.5789f;

			} else if (i == 9) {
				angle = (float) ((225) * Math.PI / 180);
				startX = (float) Math.cos(angle) * mCenterX * 0.4f;
				startY = (float) Math.sin(angle) * mCenterY * 0.5f;
				mAlphaMutiple = 0.5789f;

			}

			StarBean starBean = new StarBean(mStar, angle, startX, startY, mAlphaMutiple, matrix);
			starBean.mStartScale = startScale;
			mStarBeans[i] = starBean;
		}
	}

	private class StarBean {

		private Bitmap	mIcon;			// icon

		private double	mStarAngle;		// 开始角度

		private float	mStartX;		// 起始位置

		private float	mStartY;		// 起始位置

		private float	mAlphaMutiple;	// 倍数

		private Matrix	mMatrix;		// 矩阵

		private float	mStartScale;	// 开始缩放

		public StarBean(Bitmap mIcon, double mStarAngle, float mStartX, float mStartY, float mAlphaMutiple, Matrix matrix) {
			this.mIcon = mIcon;
			this.mStarAngle = mStarAngle;
			this.mStartX = mStartX;
			this.mStartY = mStartY;
			this.mAlphaMutiple = mAlphaMutiple;
			this.mMatrix = matrix;
		}
	}

	private float dipToPx(int i) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, i, getResources().getDisplayMetrics());
	}

}
