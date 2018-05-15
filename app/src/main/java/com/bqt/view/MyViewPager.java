package com.bqt.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;

public class MyViewPager extends ViewPager {
	
	public MyViewPager(Context context) {
		super(context);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		boolean b = super.onTouchEvent(ev);
		//ACTION_DOWN = 0，按下动作；ACTION_UP = 1，离开动作；ACTION_MOVE = 2，移动动作；ACTION_CANCEL= 3，取消动作
		Log.i("bqt", "【ViewPager：onTouchEvent】" + ev.getAction() + "--" + b);
		return b;
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		boolean b = super.onInterceptTouchEvent(ev);
		Log.i("bqt", "【ViewPager：onInterceptTouchEvent】" + ev.getAction() + "--" + b);
		return b;
	}
}