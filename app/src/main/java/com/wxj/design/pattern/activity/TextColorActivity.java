package com.wxj.design.pattern.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.wxj.design.pattern.R;
import com.wxj.design.pattern.fragment.AFragment;
import com.wxj.design.pattern.fragment.TabFragment;
import com.wxj.design.pattern.view.ColorTrackTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuxiaojun on 2018/12/7.
 */

public class TextColorActivity extends AppCompatActivity {

	private String[]		mTitles		= new String[] { "简介", "评价", "相关", "段子", "视频" };

	private AFragment[]	mFragments	= new AFragment[mTitles.length];

	private LinearLayout	linearLayout;

	private ViewPager		viewPager;

	private List<ColorTrackTextView> colorTrackTextViews = new ArrayList<>();

	@Override protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text_color);

		initView();
		initEvent();

	}

	private void initEvent() {
		for (int i = 0; i < mTitles.length; i++) {
			ColorTrackTextView colorTrackTextView = (ColorTrackTextView) LayoutInflater.from(TextColorActivity.this).inflate(R.layout.layout_colortrack_textview,null);
			colorTrackTextView.setText(mTitles[i]);
			colorTrackTextView.setDirection(ColorTrackTextView.Direction.LEFT_TO_RIGHT);

			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT);
			params.weight = 1;
			colorTrackTextView.setLayoutParams(params);
			AFragment aFragment = new AFragment();
			Bundle bundle = new Bundle();
			bundle.putString("name",mTitles[i]);
			aFragment.setArguments(bundle);
			mFragments[i] = aFragment;
			colorTrackTextViews.add(colorTrackTextView);

			linearLayout.addView(colorTrackTextView);
		}

		viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
			@Override
			public Fragment getItem(int position) {
				return mFragments[position];
			}

			@Override
			public int getCount() {
				return mTitles.length;
			}
		});

		viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

				ColorTrackTextView left = colorTrackTextViews.get(position);
				left.setDirection(ColorTrackTextView.Direction.RIGHT_TO_LEFT);
				left.setCurrentProgress(1-positionOffset);

				if(position+1 < colorTrackTextViews.size()){
					ColorTrackTextView right = colorTrackTextViews.get(position+1);
					right.setDirection(ColorTrackTextView.Direction.LEFT_TO_RIGHT);
					right.setCurrentProgress(positionOffset);
				}
			}

			@Override
			public void onPageSelected(int position) {

			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});
	}

	private void initView() {
		linearLayout = (LinearLayout) findViewById(R.id.id_ll_indictors);
		viewPager = (ViewPager) findViewById(R.id.id_viewpager);
	}

}
