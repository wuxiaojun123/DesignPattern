package com.wxj.design.pattern.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;

/**
 *
 * 需求 1.后面的view不能拖动 2.列表只能垂直拖动 3.垂直拖动的范围只能是后面菜单view的高度 4.手指松开的时候只能两者选其一，要么打开要么关闭
 *
 * 5.事件得分发和拦截
 *
 * Created by wuxiaojun on 2018/11/24.
 */

public class VerticleDragListview extends FrameLayout  {

	public static final String	TAG	= "VerticleDragListview";

	private ViewDragHelper		mDragHelper;

	private View				mDragListView;

	private int					mMenuHeight;

	public VerticleDragListview(@NonNull Context context) {
		this(context, null);
	}

	public VerticleDragListview(@NonNull Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public VerticleDragListview(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		mDragHelper = ViewDragHelper.create(this, mDragHelperCallback);
	}

	/***
	 * 会多次调用，比如
	 *
	 * @param widthMeasureSpec
	 * @param heightMeasureSpec
	 */
	@Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		mMenuHeight = getChildAt(0).getHeight();
	}

	@Override protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
	}

	@Override protected void onFinishInflate() { // setContentView布局解析之后就会调，调完这个之后才调onMeasure
		super.onFinishInflate();
		mDragListView = getChildAt(1);
	}

	@Override public boolean dispatchTouchEvent(MotionEvent ev) {
		return super.dispatchTouchEvent(ev);
	}

	private float	mDownY;

	private boolean	mMenuState;

	/***
	 * 往下滑动的时候，moveY-mDownY是大于0 往上滑动的时候，moveY-mDownY是小于0
	 *
	 * @param ev
	 * @return
	 */
	@Override public boolean onInterceptTouchEvent(MotionEvent ev) {
		if (mMenuState) {
			return true;
		}
		int action = ev.getAction();
		switch (action) {
			case MotionEvent.ACTION_DOWN:
				mDownY = ev.getY();
				mDragHelper.processTouchEvent(ev);
				break;
			case MotionEvent.ACTION_MOVE:
				float moveY = ev.getY();
				float distanceY = moveY - mDownY;
				// Log.e("当前控件是", "distanceY=" + distanceY + "----" + (canChildScrollUp()));
				if ((distanceY > 0) && !canChildScrollUp()) {
					Log.e("TAG", "onInterceptTouchEvent拦截");
					// 往下滑动 && 滚动到了顶部，拦截不让listview做处理
					flag = false;
					return true;
				} else {
					Log.e("TAG", "onInterceptTouchEvent不拦截");
					return false;
				}
		}
		return false;
	}

	private float	mTouchDownY;

	private boolean	flag;

	@Override public boolean onTouchEvent(MotionEvent ev) {
		Log.e(TAG, "onTouchEvent");
		mDragHelper.processTouchEvent(ev);
		int action = ev.getAction();
		switch (action) {
			case MotionEvent.ACTION_DOWN:
				mTouchDownY = ev.getY();
				return true;

			case MotionEvent.ACTION_MOVE:
				float moveY = ev.getY();
				float distanceY = moveY - mTouchDownY;
				// Log.e("onTouchEvent 当前控件是", "distanceY=" +
				// distanceY+"--"+canChildScrollUp());
				if (distanceY > 0) {
					Log.e(TAG, "onTouchEvent 进来了");
					flag = true;
					onInterceptTouchEvent(ev);
					return true;
				}

				break;
		}
		return false;
	}

	public boolean canChildScrollUp() {
		if (android.os.Build.VERSION.SDK_INT < 14) {
			if (mDragListView instanceof AbsListView) {
				final AbsListView absListView = (AbsListView) mDragListView;
				return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
			} else {
				return ViewCompat.canScrollVertically(mDragListView, -1) || mDragListView.getScrollY() > 0;
			}
		} else {
			return ViewCompat.canScrollVertically(mDragListView, -1);
		}
	}

	private ViewDragHelper.Callback mDragHelperCallback = new ViewDragHelper.Callback() {

		@Override public boolean tryCaptureView(View child, int pointerId) {
			// 指定该子view是否可以拖动
			return child == mDragListView;
		}

		@Override public int clampViewPositionVertical(View child, int top, int dy) {
			// 垂直拖动移动的位置
			if (top < 0) {
				top = 0;
			}
			if (top > mMenuHeight) {
				top = mMenuHeight;
			}
			return top;
		}

		@Override public void onViewReleased(View releasedChild, float xvel, float yvel) {
			super.onViewReleased(releasedChild, xvel, yvel);
			Log.e("VerticleDragListview", "mDragListView.getScrollY()=" + mDragListView.getScrollY() + "--" + mDragListView.getTop());
			if (releasedChild == mDragListView) {
				if (mDragListView.getTop() > mMenuHeight / 2) {
					mDragHelper.settleCapturedViewAt(0, mMenuHeight);
					mMenuState = true;
				} else {
					mDragHelper.settleCapturedViewAt(0, 0);
					mMenuState = false;
				}
				invalidate();
			}
		}

	};

	@Override public void computeScroll() {
		super.computeScroll();
		if (mDragHelper.continueSettling(true)) {
			invalidate();
		}
	}

}
