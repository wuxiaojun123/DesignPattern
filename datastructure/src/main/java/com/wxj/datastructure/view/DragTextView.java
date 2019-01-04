package com.wxj.datastructure.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by wuxiaojun on 2019/1/2.
 */

public class DragTextView extends TextView {

	public DragTextView(Context context) {
		this(context, null);
	}

	public DragTextView(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public DragTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	private int	downX;

	private int	downY;


	@Override public boolean onTouchEvent(MotionEvent event) {
		int action = event.getAction();
		Log.e("DragTextView", "action=" + action);

		switch (action) {
			case MotionEvent.ACTION_DOWN:
				downX = (int) event.getRawX();
				downY = (int) event.getRawY();

				break;
			case MotionEvent.ACTION_MOVE:
				int currentX = (int) event.getRawX();
				int currentY = (int) event.getRawY();
				int diffX = currentX - downX;
				int diffY = currentY - downY;

				layout(getLeft() + diffX, getTop() + diffY, getRight() + diffX, getBottom() + diffY);
				downX = currentX;
				downY = currentY;

				break;
			case MotionEvent.ACTION_UP:
				break;
			case MotionEvent.ACTION_CANCEL:
				downX = (int) event.getRawX();
				downY = (int) event.getRawY();
				break;
		}
		return true;
	}

}
