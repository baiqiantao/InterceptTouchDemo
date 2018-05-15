package com.bqt.view;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * 解决ScrollView里面嵌套ListView时滑动冲突问题：外部拦截法
 */
public class CustomScrollView extends ScrollView {
	
	public CustomScrollView(Context context) {
		super(context);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		boolean b = super.onTouchEvent(ev);
		//ACTION_DOWN = 0，按下动作；ACTION_UP = 1，离开动作；ACTION_MOVE = 2，移动动作
		Log.i("bqt", "【ScrollView：onTouchEvent】" + ev.getAction() + "--" + b);
		return b;
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		boolean intercepted = false;
		switch (ev.getAction()) {
			case MotionEvent.ACTION_DOWN://down事件肯定不能拦截，拦截了后面的就收不到了
				intercepted = false;
				break;
			case MotionEvent.ACTION_MOVE:
				if (true) intercepted = false;//如果满足拦截条件了，就去自己的onTouchEvent里处理拦截之后的操作即可
				break;
			case MotionEvent.ACTION_UP:
				//up事件我们一般都是返回false的，一般父容器都不会拦截他， 因为up是事件的最后一步，这里返回true也没啥意义。
				//唯一的意义就是，如果父元素把up拦截了，将导致子元素收不到up事件，那子元素就肯定没有onClick事件触发了，这里的小细节 要想明白
				intercepted = false;
				break;
			default:
				break;
		}
		Log.i("bqt", "【ScrollView：onInterceptTouchEvent】" + ev.getAction() + "--" + intercepted);
		return intercepted;
	}
}