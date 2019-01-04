package com.wxj.design.pattern.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.wxj.design.pattern.R;

/**
 * Created by wuxiaojun on 2019/1/4.
 */

public class RippleView extends View {

	private Paint	mPaint;

	private int		cx;

	private int		cy;

	private float	mMinradius;

	private float	mMidRadius;

	private float	mMaxRadius;

	public RippleView(Context context) {
		this(context, null);
	}

	public RippleView(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public RippleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		mPaint = new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setStyle(Paint.Style.FILL);
		mPaint.setColor(ContextCompat.getColor(getContext(), R.color.color_6381FA));
	}

	@Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		cx = getMeasuredWidth() / 2;
		cy = getMeasuredHeight() / 2;

		int percent = cx / 9;

		mMaxRadius = cx;
		mMidRadius = percent * 6;
		mMinradius = percent * 3;
	}

	@Override protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		mPaint.setAlpha(80);
		canvas.drawCircle(cx, cy, mMaxRadius, mPaint);

		mPaint.setAlpha(155);
		canvas.drawCircle(cx, cy, mMidRadius, mPaint);

		mPaint.setAlpha(255);
		canvas.drawCircle(cx, cy, mMinradius, mPaint);

	}

	@Override protected void onFinishInflate() {
		super.onFinishInflate();

	}

	public static int dip2px(Context context, float dpValue) {
		float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

}
