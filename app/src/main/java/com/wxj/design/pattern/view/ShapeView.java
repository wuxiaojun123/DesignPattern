package com.wxj.design.pattern.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.wxj.design.pattern.R;

/**
 * 
 * 1.位移动画，形状的view上抛和下落 1）下落的时候配合中间阴影缩小，上抛的时候配合中间阴影放大
 *
 * 2.缩放动画，中间的阴影缩小和放大
 *
 * 
 * Created by wuxiaojun on 2018/12/8.
 */

public class ShapeView extends View {

	private Shape	mCurrentShape	= Shape.Triangle;

	private Paint	mPaint;

	private Path	mPath;

	public ShapeView(Context context) {
		this(context, null);
	}

	public ShapeView(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public ShapeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		mPaint = new Paint();
		mPaint.setAntiAlias(true);
	}

	@Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		int width = MeasureSpec.getSize(widthMeasureSpec);
		int height = MeasureSpec.getSize(heightMeasureSpec);

		setMeasuredDimension(Math.min(width, height), Math.min(width, height));

	}

	@Override protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		switch (mCurrentShape) {
			case Circle:// 圆形
				int center = getWidth() / 2;
				mPaint.setColor(getResources().getColor(R.color.color_aa738ffe));
				canvas.drawCircle(center, center, center, mPaint);

				break;
			case Square:// 正方形
				mPaint.setColor(getResources().getColor(R.color.color_aa72d572));
				canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);

				break;
			case Triangle:// 三角形
				mPaint.setColor(ContextCompat.getColor(getContext(), R.color.color_aae84e40));
				if (mPath == null) {
					mPath = new Path();
					mPath.moveTo(getWidth() / 2, 0);
					mPath.lineTo(0, (float) (getWidth() / 2 * Math.sqrt(3)));
					mPath.lineTo(getWidth(), (float) (getWidth() / 2 * Math.sqrt(3)));
					mPath.close(); // 把路径闭合
				}
				canvas.drawPath(mPath, mPaint);

				break;
		}
	}

	public enum Shape {
		Square, Circle, Triangle
	}

	public void exchange() {
		switch (mCurrentShape) {
			case Circle:
				mCurrentShape = Shape.Square;

				break;
			case Square:
				mCurrentShape = Shape.Triangle;

				break;
			case Triangle:
				mCurrentShape = Shape.Circle;

				break;
		}
		invalidate();
	}

	public void setShape(Shape shape) {
		this.mCurrentShape = shape;
	}

	public Shape getShape() {
		return mCurrentShape;
	}

}
