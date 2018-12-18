package com.wxj.design.pattern.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.wxj.design.pattern.adapter.BaseMenuAdapter;

/**
 * Created by wuxiaojun on 2018/12/1.
 */

public class ListDataScreenView extends LinearLayout implements View.OnClickListener {

	private final String	TAG					= "ListDataScreenView";

	private final int		DURATION			= 500;

	private LinearLayout	mMenuTabView;

	private Context			mContext;

	private FrameLayout		mMenuMiddleView;

	private View			mShadowView;								//

	private FrameLayout		mMenuContainerView;

	// 阴影的颜色
	private int				mShadowColor		= 0x88888888;

	// 筛选菜单的adapter
	private BaseMenuAdapter	mAdapter;

	private float			menuContentHeight;							// 内容的高度

	private int				mCurrentPosition	= -1;					// 当前打开的位置,-1就是表示关闭状态

	private boolean			mAnimationExcutor;							// 动画是否在执行

	public ListDataScreenView(Context context) {
		this(context, null);
	}

	public ListDataScreenView(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public ListDataScreenView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		mContext = context;
		setOrientation(VERTICAL);
		initLayout();
	}

	/***
	 * 布局实例化(组合控件)
	 */
	private void initLayout() {
		// 1.1创建头部布局 存放tab
		mMenuTabView = new LinearLayout(mContext);
		mMenuTabView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		addView(mMenuTabView);

		// 1.2 创建FramLayout用来存放 = 阴影(view)+菜单内容布局(FramLayout)
		mMenuMiddleView = new FrameLayout(mContext);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0);
		layoutParams.weight = 1;
		mMenuMiddleView.setLayoutParams(layoutParams);
		addView(mMenuMiddleView);

		// 添加阴影,可以不用设置layoutparams，默认就是match_parent,match_parent
		mShadowView = new View(mContext);
		mShadowView.setBackgroundColor(mShadowColor);
		mShadowView.setVisibility(View.GONE);
		mShadowView.setOnClickListener(this);
		mMenuMiddleView.addView(mShadowView);

		// 创建菜单 存放菜单内容
		mMenuContainerView = new FrameLayout(mContext);
		mMenuContainerView.setBackgroundColor(Color.RED);
		mMenuMiddleView.addView(mMenuContainerView);

		mMenuMiddleView.setVisibility(View.GONE);
	}

	@Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		int height = MeasureSpec.getSize(heightMeasureSpec);
		menuContentHeight = (height * 75f / 100);

		ViewGroup.LayoutParams params = mMenuContainerView.getLayoutParams();
		params.height = (int) menuContentHeight;
		mMenuContainerView.setLayoutParams(params);

		Log.e(TAG, "mMenuContainerView=" + menuContentHeight);
		mMenuContainerView.setTranslationY(-menuContentHeight);
	}

	public void setAdapter(BaseMenuAdapter adapter) {
		this.mAdapter = adapter;

		int count = mAdapter.getCount();
		for (int i = 0; i < count; i++) {
			// 获取菜单的tab
			View tabView = mAdapter.getTabView(i, mMenuTabView);
			mMenuTabView.addView(tabView);

			// 获取菜单的内容
			View menuView = mAdapter.getMenuView(i, mMenuContainerView);
			menuView.setVisibility(View.GONE);
			mMenuContainerView.addView(menuView);

			setTabClick(tabView, i);
		}

		// 刚开始进来的时候，阴影和内容都是不显示的
	}

	private void setTabClick(final View tabView, final int position) {
		tabView.setOnClickListener(new OnClickListener() {

			@Override public void onClick(View v) {
				if (mCurrentPosition == -1) {
					openMenu(position, tabView);
				} else {
					if (mCurrentPosition == position) {
						closeMenu();
					} else { // 切换一下显示
						View showView = mMenuContainerView.getChildAt(position);
						showView.setVisibility(View.VISIBLE);

						View currentPositioinView = mMenuContainerView.getChildAt(mCurrentPosition);
						currentPositioinView.setVisibility(View.GONE);

						mCurrentPosition = position;
					}
				}
			}
		});
	}

	/***
	 * 关闭菜单
	 * 
	 */
	private void closeMenu() {
		ObjectAnimator translationY = ObjectAnimator.ofFloat(mMenuContainerView, "translationY", 0, -menuContentHeight);
		translationY.setDuration(DURATION);
		translationY.start();

		ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(mShadowView, "alpha", 1f, 0f);
		alphaAnim.setDuration(DURATION);
		alphaAnim.start();
		alphaAnim.addListener(new AnimatorListenerAdapter() {

			@Override public void onAnimationEnd(Animator animation) {
				mShadowView.setVisibility(View.GONE);
				mMenuMiddleView.setVisibility(GONE);
				// 获取当前位置显示当前菜单
				View view = mMenuContainerView.getChildAt(mCurrentPosition);
				view.setVisibility(View.GONE);

				mCurrentPosition = -1;
			}
		});
	}

	/***
	 * 打开菜单 位移动画，透明度动画
	 * 
	 * @param position
	 * @param tabView
	 */
	private void openMenu(final int position, View tabView) {
		if (mAnimationExcutor) {
			return;
		}

		mMenuMiddleView.setVisibility(VISIBLE);

		// 获取当前位置显示当前菜单
		View view = mMenuContainerView.getChildAt(position);
		view.setVisibility(View.VISIBLE);

		ObjectAnimator translationY = ObjectAnimator.ofFloat(mMenuContainerView, "translationY", -menuContentHeight, 0);
		translationY.setDuration(DURATION);
		translationY.start();

		mShadowView.setVisibility(View.VISIBLE);
		ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(mShadowView, "alpha", 0f, 1f);
		alphaAnim.setDuration(DURATION);
		alphaAnim.addListener(new AnimatorListenerAdapter() {

			@Override public void onAnimationEnd(Animator animation) {
				mAnimationExcutor = false;
				mCurrentPosition = position;
			}

			@Override public void onAnimationStart(Animator animation) {
				mAnimationExcutor = true;
			}
		});
		alphaAnim.start();

	}

	@Override public void onClick(View v) {
		closeMenu();
	}

}
