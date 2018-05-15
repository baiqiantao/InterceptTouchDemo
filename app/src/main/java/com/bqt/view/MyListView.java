package com.bqt.view;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;

public class MyListView extends ListView {
	
	public MyListView(Context context) {
		super(context);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		boolean b = super.onTouchEvent(ev);
		//ACTION_DOWN = 0，按下动作；ACTION_UP = 1，离开动作；ACTION_MOVE = 2，移动动作
		Log.i("bqt", "【ListView：onTouchEvent】" + ev.getAction() + "--" + b);
		return b;
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		boolean b = super.onInterceptTouchEvent(ev);//如果连续调用super.onInterceptTouchEvent(ev)，可能会卡死
		Log.i("bqt", "【ListView：onInterceptTouchEvent】" + ev.getAction() + "--" + b);
		return b;
	}
}