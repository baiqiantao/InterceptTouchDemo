package com.bqt.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.bqt.view.MyListView;
import com.bqt.view.MyViewPager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * ViewPager里面嵌套ListView：不会产生滑动冲突
 */
public class ViewPager_ListView extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyViewPager mViewPager = new MyViewPager(this);
		PagerAdapter mPagerAdapter = new PagerAdapter() {
			@Override
			public boolean isViewFromObject(@NonNull View view, @NonNull Object object) { // 判断是否是同一条目
				return view == object;
			}
			
			@Override
			public int getCount() {
				return 6;
			}
			
			@NonNull
			public Object instantiateItem(@NonNull ViewGroup container, int position) {// 初始化要显示的条目
				MyListView listView = new MyListView(ViewPager_ListView.this);
				if (position % 3 == 0) listView.setBackgroundColor(0x33ff0000);
				else if (position % 3 == 1) listView.setBackgroundColor(0x3300ff00);
				else listView.setBackgroundColor(0x330000ff);
				String[] array = new String[50];
				for (int i = 0; i < array.length; i++) {
					array[i] = new SimpleDateFormat("HH-mm-ss:SSS", Locale.getDefault()).format(new Date());
				}
				listView.setAdapter(new ArrayAdapter<String>(ViewPager_ListView.this, android.R.layout.simple_list_item_1, array));
				container.addView(listView);//一定将要显示的条目加入到ViewGroup的缓存容器中才可以显示
				return listView;
			}
			
			public void destroyItem(ViewGroup container, int position, @NonNull Object object) {//将要销毁的条目从ViewGroup的缓存容器中移除
				container.removeView((View) object);
			}
		};
		mViewPager.setAdapter(mPagerAdapter);
		setContentView(mViewPager);
	}
}