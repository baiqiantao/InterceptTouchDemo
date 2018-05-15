package com.bqt;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bqt.activity.ListView_ViewPager;
import com.bqt.activity.ScrollView_ListView;
import com.bqt.activity.ScrollView_ListView_2;
import com.bqt.activity.ScrollView_ListView_N;
import com.bqt.activity.ScrollView_ListView_W;
import com.bqt.activity.ViewPager_ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends ListActivity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String[] array = { "ViewPager里面嵌套ListView：没任何问题", //
				"ListView里面嵌套ViewPager：没任何问题",//
				"ScrollView里面嵌套ListView：会产生滑动冲突", //
				"解决ScrollView里面嵌套ListView时只显示一行的问题", //
				"解决ScrollView里面嵌套ListView时滑动冲突问题：外部拦截法", //
				"解决ScrollView里面嵌套ListView时滑动冲突问题：内部拦截法", };
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>(Arrays.asList(array))));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		switch (position) {
			case 0:
				startActivity(new Intent(this, ViewPager_ListView.class));
				break;
			case 1:
				startActivity(new Intent(this, ListView_ViewPager.class));
				break;
			case 2:
				startActivity(new Intent(this, ScrollView_ListView.class));
				break;
			case 3:
				startActivity(new Intent(this, ScrollView_ListView_2.class));
				break;
			case 4:
				startActivity(new Intent(this, ScrollView_ListView_W.class));
				break;
			case 5:
				startActivity(new Intent(this, ScrollView_ListView_N.class));
				break;
		}
	}
}
