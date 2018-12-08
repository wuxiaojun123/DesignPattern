package com.wxj.design.pattern.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wxj.design.pattern.R;

/**
 * Created by wuxiaojun on 2018/11/22.
 */

public class AFragment extends Fragment {

	@Override public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frament_a,container,false);
		android.widget.TextView textView = (TextView) view.findViewById(R.id.id_tv_content);

		Bundle bundle = getArguments();
		if(bundle != null){
			String name = bundle.getString("name");
			textView.setText(name);
		}

		return view;
	}

}
