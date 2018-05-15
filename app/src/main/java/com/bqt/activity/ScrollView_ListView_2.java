package com.bqt.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

/**
 * 解决ScrollView里面嵌套ListView时只显示一行的问题
 */
public class ScrollView_ListView_2 extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ScrollView scrollView = new ScrollView(this);
		LinearLayout linearLayout = new LinearLayout(this);
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		
		ListView lv1 = new ListView(this);
		lv1.setBackgroundColor(0x33ff0000);
		lv1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"白", "白", "白", "白", "白", "白", "白", "白", "白", "白"}));
		ListView lv2 = new ListView(this);
		lv2.setBackgroundColor(0x3300ff00);
		lv2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"包", "包", "包", "包", "包", "包", "包", "包", "包", "包"}));
		
		linearLayout.addView(lv1);
		setListViewHeight(lv1);
		linearLayout.addView(lv2, new LayoutParams(400, 400));
		setListViewHeight(lv2);//上面设置的高度就没用了
		
		scrollView.addView(linearLayout);
		setContentView(scrollView);
	}
	
	/**
	 * 重新计算ListView的高度，解决ScrollView和ListView两个View都有滚动的效果，在嵌套使用时起冲突的问题
	 */
	public void setListViewHeight(ListView listView) {
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) return;
		int totalHeight = 0;
		//遍历item，计算item的宽高，统计出所有item的总高度
		for (int i = 0, len = listAdapter.getCount(); i < len; i++) { // listAdapter.getCount()返回数据项的数目
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(0, 0); // 计算子项View 的宽高
			totalHeight += listItem.getMeasuredHeight(); // 统计所有子项的总高度
		}
		ViewGroup.LayoutParams params = listView.getLayoutParams();
		if (params != null) {
			params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));//加上item间分隔符占用的高度
			listView.setLayoutParams(params);
		}
	}
}