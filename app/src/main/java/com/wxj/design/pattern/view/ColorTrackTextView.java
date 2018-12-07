package com.wxj.design.pattern.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.*;

import com.wxj.design.pattern.R;

/**
 * Created by wuxiaojun on 2018/12/7.
 */

public class ColorTrackTextView extends android.widget.TextView {

	private int		originColor;

	private int		changeColor;

	private Paint	mOriginPaint;

	private Paint	mChangePaint;

	private float	mCurrentProgress	= 0.5f;

	public ColorTrackTextView(Context context) {
		this(context, null);
	}

	public ColorTrackTextView(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public ColorTrackTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		initPaint(context, attrs);

	}

	private void initPaint(Context context, AttributeSet attrs) {

		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ColorTrackTextView);
		originColor = typedArray.getColor(R.styleable.ColorTrackTextView_originColor, Color.WHITE);
		changeColor = typedArray.getColor(R.styleable.ColorTrackTextView_changeColor, Color.BLACK);

		mOriginPaint = getPaintByColor(originColor);
		mChangePaint = getPaintByColor(changeColor);

		typedArray.recycle();

	}

	private Paint getPaintByColor(int originColor) {
		Paint paint = new Paint();
		paint.setColor(originColor);
		// 设置抗锯齿
		paint.setAntiAlias(true);
		// 设置防止抖动
		paint.setDither(true);
		// 设置字体大小
		paint.setTextSize(getTextSize());
		return paint;
	}

	/***
	 * 一个文字两种颜色 利用clipRect的api，可以裁剪，左边用一个画笔去画，右边用另外一个画笔去画 不断的改变中间值
	 * 
	 * @param canvas
	 *            画布
	 */
	@Override protected void onDraw(Canvas canvas) {
		int middle = (int) (mCurrentProgress * getWidth());
		drawText(canvas,mOriginPaint,0,middle);
		drawText(canvas,mChangePaint,middle,getWidth());
	}

	private void drawText(Canvas canvas, Paint paint, int start, int end) {
		canvas.save();
		Rect clipRect = new Rect(start, 0, end, getHeight());
		canvas.clipRect(clipRect);
		// 绘制
		String text = getText().toString();
		Rect bounds = new Rect();
		paint.getTextBounds(text, 0, text.length(), bounds);
		// 获取字体的宽度
		int x = getWidth() / 2 - bounds.width() / 2;
		// 基线baseline
		Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
		int dy = (fontMetricsInt.bottom - fontMetricsInt.top) / 2 - fontMetricsInt.bottom;
		int baseLine = getHeight() / 2 + dy;
		canvas.drawText(text, x, baseLine, paint);
		canvas.restore();
	}



}
