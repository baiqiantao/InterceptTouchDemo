package com.bqt.view;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;

public class CustomListView extends ListView {
	
	public CustomListView(Context context) {
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
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				break;
			case MotionEvent.ACTION_MOVE:
				//这里指定在什么条件下，才会要求父View把触摸事件交给自己处理。注意这里是调用的【getParent().getParent()】
				if (true) getParent().getParent().requestDisallowInterceptTouchEvent(true);//这句话的作用是告诉父view，我的触摸事件由我自行处理，不要阻碍我
				break;
			case MotionEvent.ACTION_UP:
				getParent().getParent().requestDisallowInterceptTouchEvent(false);//个人感觉这行代码没啥用，因为父view本来就不会拦截
				break;
		}
		return super.dispatchTouchEvent(event);
	}
}