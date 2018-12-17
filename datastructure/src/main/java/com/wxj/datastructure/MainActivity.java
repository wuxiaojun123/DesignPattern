package com.wxj.datastructure;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "http://test-ic-static.sayabc.com/course/materialSAYABC/TR-L1-U1-L1/f0a5efcc1f9c736203d85b7a4f5a7777.mp3";
        Uri uri = Uri.parse(url);
        // 截取
        Log.e(TAG,uri.getPath());

    }


}
