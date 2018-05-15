package com.bqt.activity;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bqt.R;
import com.bqt.view.MyListView;
import com.bqt.view.MyViewPager;

/**
 * ListView里面嵌套ViewPager：不会产生滑动冲突
 */
public class ListView_ViewPager extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyListView listView = new MyListView(this);
		listView.setAdapter(new MyBaseAdapter());
		listView.setDivider(new ColorDrawable(0x33ffff00));
		listView.setDividerHeight(5);
		setContentView(listView);
	}
	
	class MyBaseAdapter extends BaseAdapter {
		@Override
		public int getCount() {
			return 20;
		}
		
		@Override
		public Object getItem(int position) {
			return null;
		}
		
		@Override
		public long getItemId(int position) {
			return position;
		}
		
		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			MyViewPager mViewPager = new MyViewPager(ListView_ViewPager.this);
			mViewPager.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 200));//必须设置大小，不然不显示
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
					ImageView view = new ImageView(ListView_ViewPager.this);
					view.setImageResource(R.drawable.icon);
					if (position % 3 == 0) view.setBackgroundColor(0x33ff0000);
					else if (position % 3 == 1) view.setBackgroundColor(0x3300ff00);
					else view.setBackgroundColor(0x330000ff);
					container.addView(view);//一定将要显示的条目加入到ViewGroup的缓存容器中才可以显示
					return view;
				}
				
				public void destroyItem(ViewGroup container, int position, @NonNull Object object) {//将要销毁的条目从ViewGroup的缓存容器中移除
					container.removeView((View) object);
				}
			};
			mViewPager.setAdapter(mPagerAdapter);
			return mViewPager;
		}
	}
}