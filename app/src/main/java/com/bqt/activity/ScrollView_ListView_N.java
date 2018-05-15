package com.bqt.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.bqt.view.CustomListView;
import com.bqt.view.MyScrollView;

/**
 * 解决ScrollView里面嵌套ListView时滑动冲突问题：内部拦截法
 * 父容器不管，在子View中调用getParent().requestDisallowInterceptTouchEvent(true)，作用是：告诉父view，我的触摸事件由我自行处理，不要阻碍我
 */
public class ScrollView_ListView_N extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final MyScrollView scrollView = new MyScrollView(this);
		LinearLayout linearLayout = new LinearLayout(this);
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		
		CustomListView lv1 = new CustomListView(this);
		lv1.setBackgroundColor(0x33ff0000);
		lv1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
				new String[]{"白", "白", "白", "白", "白", "白", "白", "白", "白", "白", "白", "白", "白", "白", "白", "白", "白", "白", "白",}));
		
		CustomListView lv2 = new CustomListView(this);
		lv2.setBackgroundColor(0x3300ff00);
		lv2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
				new String[]{"包", "包", "包", "包", "包", "包", "包", "包", "包", "包", "包", "包", "包", "包", "包", "包", "包", "包", "包",}));
		
		linearLayout.addView(lv1, new LayoutParams(600,  dp2px(this, 450)));
		linearLayout.addView(lv2, new LayoutParams(400,  dp2px(this, 450)));
		
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