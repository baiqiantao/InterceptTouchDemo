package com.bqt.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.bqt.view.MyListView;
import com.bqt.view.MyScrollView;

import java.util.Random;

/**
 * ScrollView里面嵌套ListView：当ScrollView的内容没有超出屏幕时(也即ScrollView不需要上下滑动)，不会产生滑动冲突(也即内部的ListView能正常滑动)；
 * 当ScrollView的内容超出屏幕时(也即ScrollView需要上下滑动)，由于ListView也需要上下滑动，所以会产生滑动冲突(也即内部的ListView讲不能正常滑动)！
 */
public class ScrollView_ListView extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyScrollView scrollView = new MyScrollView(this);
		LinearLayout linearLayout = new LinearLayout(this);
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		
		MyListView lv1 = new MyListView(this);
		lv1.setBackgroundColor(0x33ff0000);
		lv1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
				new String[]{"白", "白", "白", "白", "白", "白", "白", "白", "白", "白", "白", "白", "白", "白", "白", "白", "白", "白", "白",}));
		
		MyListView lv2 = new MyListView(this);
		lv2.setBackgroundColor(0x3300ff00);
		lv2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
				new String[]{"包", "包", "包", "包", "包", "包", "包", "包", "包", "包", "包", "包", "包", "包", "包", "包", "包", "包", "包",}));
		
		MyListView lv3 = new MyListView(this);
		lv3.setBackgroundColor(0x330000ff);
		lv3.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
				new String[]{"前", "前", "前", "前", "前", "前", "前", "前", "前", "前", "前", "前", "前", "前", "前", "前", "前", "前", "前"}));
		
		linearLayout.addView(lv1, new LayoutParams(600, LayoutParams.WRAP_CONTENT));//小插曲：此时ListView会出现只显示一行的bug
		linearLayout.addView(lv2, new LayoutParams(400, dp2px(this, 450)));
		if (new Random().nextBoolean()) {
			linearLayout.addView(lv3, new LayoutParams(LayoutParams.MATCH_PARENT, dp2px(this, 450)));
		}
		scrollView.addView(linearLayout);
		setContentView(scrollView);
	}
	
	/**
	 * dp 转成为 px
	 */
	public static int dp2px(Context context, float dpValue) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, context.getResources().getDisplayMetrics());
	}
}