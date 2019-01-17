package com.wxj.design.pattern.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.wxj.design.pattern.R;

/**
 * Created by wuxiaojun on 2019/1/9.
 */

public class StarView extends View {

	private int				mDuration		= 10000;

	private Paint			mPaint;

	private ValueAnimator	mValueAnimator;

	private float			mCurrentProgress;					// 当前进度

	private float			mMaxProgress	= 1000;				// 最大进度

	private int				mCenterX, mCenterY;					// 中心点

	private Bitmap			mStar;								// 星星图片

	private int				mInitBitmapWidth, mInitBitmapHeight;

	private StarBean[]		mStarBeans;

	public StarView(Context context) {
		this(context, null);
	}

	public StarView(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public StarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		mPaint = new Paint();
		mPaint.setAntiAlias(true);

		mStar = BitmapFactory.decodeResource(getResources(), R.mipmap.stars1);
	}

	@Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

	}

	@Override protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (mStarBeans == null) {
			return;
		}
		if (mCenterX == 0) {
			mCenterX = getWidth() / 2 - mStar.getWidth() / 2;
			mCenterY = getHeight() / 2 - mStar.getHeight() / 2;
		}
		// mPaint.setAlpha((int) (300 - 255 * mCurrentProgress));
		for (int i = 0; i < mStarBeans.length; i++) {
			StarBean starBean = mStarBeans[i];

			float left = (float) (mCenterX + Math.cos(starBean.mStarAngle) * mCenterX * mCurrentProgress); // 初始角度
			float top = (float) (mCenterY + Math.sin(starBean.mStarAngle) * mCenterY * mCurrentProgress);
			canvas.drawBitmap(starBean.mIcon, left, top, mPaint);
		}
	}

	public void startAnimation(int length) {
		if (mValueAnimator == null) {
			mStarBeans = new StarBean[length];
			double percent = 2 * Math.PI / length;
			float distancePercent = mCenterX/length;


			for (int i = 0; i < length; i++) {
				float angle = (float) percent * i;
//				mStar.setWidth(mInitBitmapWidth * i);
//				mStar.setHeight(mInitBitmapHeight * i);

				StarBean starBean = new StarBean(mStar, angle, i * distancePercent);
				mStarBeans[i] = starBean;
			}
			invalidate();

			mValueAnimator = ValueAnimator.ofFloat(0f, 1f);
			mValueAnimator.setDuration(mDuration);
			mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

				@Override public void onAnimationUpdate(ValueAnimator animation) {
					mCurrentProgress = (float) animation.getAnimatedValue();
					invalidate();
				}
			});

			mValueAnimator.start();
		}
	}

	private class StarBean {

		private Bitmap	mIcon;			// icon

		private double	mStarAngle;		// 开始角度

		private float	mMaxDistance;	// 最远距离

		public StarBean(Bitmap mIcon, double mStarAngle, float mMaxDistance) {
			this.mIcon = mIcon;
			this.mStarAngle = mStarAngle;
			this.mMaxDistance = mMaxDistance;
		}

	}

}
