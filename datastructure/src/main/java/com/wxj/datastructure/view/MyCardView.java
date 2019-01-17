package com.wxj.datastructure.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * https://blog.csdn.net/vv_bug/article/list/3
 *
 * 两篇文章分析cardView的源码，和自定义cardView，写的很好 Created by wuxiaojun on 2019/1/10.
 */

public class MyCardView extends FrameLayout {

	public MyCardView(@NonNull Context context) {
		this(context, null);
	}

	public MyCardView(@NonNull Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public MyCardView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		mPaint = new Paint();
		mPaint.setColor(Color.WHITE);
	}

	private RectF	mRect;

	private Paint	mPaint;

	@Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		mRect = new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight());
	}

	@Override protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (mRect != null) {
			canvas.drawRoundRect(mRect, 20, 20, mPaint);
		}
	}

}
