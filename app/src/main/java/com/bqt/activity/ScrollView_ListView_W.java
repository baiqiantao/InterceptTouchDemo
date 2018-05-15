package com.bqt.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.bqt.view.CustomScrollView;
import com.bqt.view.MyListView;

/**
 * 解决ScrollView里面嵌套ListView时滑动冲突问题：外部拦截法
 * 思路就是重写父容器的onInterceptTouchEvent方法，当自己需要的时候就拦截，否则不拦截。
 */
public class ScrollView_ListView_W extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		CustomScrollView scrollView = new CustomScrollView(this);
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
		
		linearLayout.addView(lv1, new LayoutParams(600, dp2px(this, 450)));
		linearLayout.addView(lv2, new LayoutParams(600, dp2px(this, 450)));
		
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