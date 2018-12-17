package com.wxj.design.pattern.activity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wxj.design.pattern.R;
import com.wxj.design.pattern.view.ShapeView;

/**
 * Created by wuxiaojun on 2018/12/8.
 */

public class WuBaAnimActivity extends AppCompatActivity {

    private ShapeView id_shape_view;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            id_shape_view.exchange();

            handler.sendEmptyMessageDelayed(1,1000);
        }
    };


	@Override protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wuba_anim);

        id_shape_view = (ShapeView) findViewById(R.id.id_shape_view);


        handler.sendEmptyMessageDelayed(1,1000);
	}

}
