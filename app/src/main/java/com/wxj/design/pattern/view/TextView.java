package com.wxj.design.pattern.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.wxj.design.pattern.R;

/**
 * 自定义view入门
 *
 * ScrollView+listview会显示不全问题：因为ScrollView在给子类传递的是一个MeasureSpec.UNSPECIFIED的模式，而在listview中如果高度是UNSPECIFIED的模式就会直接计算本身的高度是paddingBottom+paddingTop
 * +childHeight
 *
 * widthMeasureSpec:会包含两个信息，是一个32位的值，前两位是模式，后面30位是大小
 * MeasureSpec.getSize(widthMeasureSpec)拿到的是宽度的值
 * MeasureSpec.getMode(widthMeasureSpec)拿到的是测量模式
 *
 * Created by wuxiaojun on 2018/12/7.
 */

public class TextView extends View {

	/***
	 * 在代码里面new的时候调用 例如：TextView textView = new TextView(context)
	 * 
	 * @param context
	 */
	public TextView(Context context) {
		this(context, null);
	}

	/***
	 * 在布局中，也就是xml文件中，调用
	 * 
	 * @param context
	 * @param attrs
	 */
	public TextView(Context context, @Nullable AttributeSet attrs) { //
		this(context, attrs, 0);
	}

	/***
	 * 在布局layout中使用，使用style的时候调用
	 * 
	 * @param context
	 * @param attrs
	 * @param defStyleAttr
	 */
	public TextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) { // 有自定义属性的时候调用
		super(context, attrs, defStyleAttr);

		TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.My_custom_textview);
        String name = typedArray.getString(R.styleable.My_custom_textview_text_name);
        int color = typedArray.getColor(R.styleable.My_custom_textview_text_color, Color.WHITE);
        // 这里不知道typedArray.getInt();和typedArray.getInteger();的区别就可以去看textview里面是哪些地方用到了getInt哪些地方用的integer
        int textsize = typedArray.getDimensionPixelSize(R.styleable.My_custom_textview_text_size,100);

        // 回收
        typedArray.recycle();
	}

	/***
	 * 自定义view的测量方法
	 * 
	 * @param widthMeasureSpec
	 * @param heightMeasureSpec
	 */
	@Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		// 布局的方法都是由这个方法指定
		// 指定控件的宽和高，需要测量

		// 获取宽度的模式
		int widthModel = MeasureSpec.getMode(widthMeasureSpec);
		int heightModel = MeasureSpec.getMode(heightMeasureSpec);

		if (widthModel == MeasureSpec.EXACTLY) { // 对应的是具体的值100dp或者match_parent

		} else if (widthModel == MeasureSpec.AT_MOST) { // 对应的是最大值，也就是wrap_content包裹内容

		} else if (widthModel == MeasureSpec.UNSPECIFIED) { // 子类想要多大就给多大,父类不对子类进行约束，Listview和ScrollView在测量子布局的时候会调用UNSPECIFIED

		}

		// 宽和高的大小
		int widthSize = MeasureSpec.getSize(widthMeasureSpec);
		int heightSize = MeasureSpec.getSize(heightMeasureSpec);

	}

	/***
	 * view的位置摆放
	 * 
	 * @param changed
	 * @param left
	 * @param top
	 * @param right
	 * @param bottom
	 */
	@Override protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		super.onLayout(changed, left, top, right, bottom);
	}

	/***
	 * 绘制,以及invalidate的源码和invalidate的区别
	 * 
	 * @param canvas
	 */
	@Override protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

	}

	@Override public boolean onTouchEvent(MotionEvent event) {

		int action = event.getAction();
		switch (action) {
			case MotionEvent.ACTION_DOWN: // 按下

				break;
			case MotionEvent.ACTION_MOVE: // 移动----多次

				break;
			case MotionEvent.ACTION_UP: // 抬起

				break;
		}

		return super.onTouchEvent(event);
	}








}
