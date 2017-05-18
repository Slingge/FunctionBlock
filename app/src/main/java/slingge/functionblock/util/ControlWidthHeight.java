package slingge.functionblock.util;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ControlWidthHeight {
	
	/**
	 * 获取textview宽度
	 * */
	public static int getWidth(TextView tv){
		int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
		int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
		tv.measure(w, h);
		int width = tv.getMeasuredWidth();
		return width;
	}
	
	
	/**
	 * 获取View高度
	 * */
	public static int OutputView(View view){
		int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
		int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
		view.measure(w, h);
		int high = view.getMeasuredHeight();
		return high;
	}
	
	
	/**
	 * 获取View宽度
	 * */
	public static int OutputViewWidth(View view){
		int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
		int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
		view.measure(w, h);
		int Width = view.getMeasuredWidth();
		return Width;
	}
	
	
	
	/**
	 * 设置textview宽度
	 * */
	public static void input(int width,TextView tv){
		ViewGroup.LayoutParams para = tv.getLayoutParams();
        para.width = width;
        tv.setLayoutParams(para);
	}


	
	
	/**
	* 动态设置GridView的高度
	* @param listView
	*/
	public static void setListViewHeightBasedOnChildren(GridView listView) {
		// 获取listview的adapter
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			return;
		}
		// 固定列宽，有多少列
		int col = 3;// listView.getNumColumns();
		int totalHeight = 0;
		// i每次加4，相当于listAdapter.getCount()小于等于4时 循环一次，计算一次item的高度，
		// listAdapter.getCount()小于等于8时计算两次高度相加
		for (int i = 0; i < listAdapter.getCount(); i += col) {
			// 获取listview的每一个item
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(0, 0);
			// 获取item的高度和
			totalHeight += listItem.getMeasuredHeight();
		}

		// 获取listview的布局参数
		ViewGroup.LayoutParams params = listView.getLayoutParams();
		// 设置高度
		params.height = totalHeight;
		// 设置margin
		((ViewGroup.MarginLayoutParams) params).setMargins(10, 10, 10, 10);
		// 设置参数
		listView.setLayoutParams(params);
	}


	/**
	 * dp转px
	 * */
	public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (dpValue * scale + 0.5f);  
    }


	public static void getTotalHeightofListView(ListView listView) {
		ListAdapter mAdapter = listView.getAdapter();
		if (mAdapter == null) {
			return;
		}
		int totalHeight = 0;
		for (int i = 0; i < mAdapter.getCount(); i++) {
			View mView = mAdapter.getView(i, null, listView);
			mView.measure(
					View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
					View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
			//mView.measure(0, 0);
			totalHeight += mView.getMeasuredHeight();
		}
		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight           + (listView.getDividerHeight() * (mAdapter.getCount() - 1));
		listView.setLayoutParams(params);
		listView.requestLayout();
	}


}
