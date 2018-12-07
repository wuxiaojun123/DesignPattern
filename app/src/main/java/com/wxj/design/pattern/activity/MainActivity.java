package com.wxj.design.pattern.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wxj.design.pattern.R;

/***
 * 系统架构
 *
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	private TextView	id_yahu;

	private TextView	id_kugou;

	private TextView	id_recycler;

	private TextView	id_viewdraghelper;

	private TextView	id_stick_layout;

	private TextView	id_mutil_item;

	private TextView	id_text_color;

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		id_yahu = (TextView) findViewById(R.id.id_yahu);
		id_kugou = (TextView) findViewById(R.id.id_kugou);
		id_recycler = (TextView) findViewById(R.id.id_recycler);
		id_viewdraghelper = (TextView) findViewById(R.id.id_viewdraghelper);
		id_stick_layout = (TextView) findViewById(R.id.id_stick_layout);
		id_mutil_item = (TextView) findViewById(R.id.id_mutil_item);
		id_text_color = (TextView) findViewById(R.id.id_text_color);

		id_yahu.setOnClickListener(this);
		id_kugou.setOnClickListener(this);
		id_recycler.setOnClickListener(this);
		id_viewdraghelper.setOnClickListener(this);
		id_stick_layout.setOnClickListener(this);
		id_mutil_item.setOnClickListener(this);
		id_text_color.setOnClickListener(this);
	}

	@Override public void onClick(View v) {
		int id = v.getId();
		switch (id) {
			case R.id.id_text_color:
				startActivity(new Intent(MainActivity.this,TextColorActivity.class));

				break;
			case R.id.id_yahu:
				startActivity(new Intent(MainActivity.this, YahuActivity.class));

				break;
			case R.id.id_kugou:
				startActivity(new Intent(MainActivity.this, KuGouActivity.class));

				break;
			case R.id.id_viewdraghelper:
				startActivity(new Intent(MainActivity.this, ViewDragHelperActivity.class));

				break;
			case R.id.id_recycler:
				startActivity(new Intent(MainActivity.this, RecyclerviewActivity.class));

				break;
			case R.id.id_stick_layout:
				startActivity(new Intent(MainActivity.this, StickyActivity.class));

				break;
			case R.id.id_mutil_item:
				startActivity(new Intent(MainActivity.this, MultipleMenuActivity.class));

				break;
		}
	}

}
