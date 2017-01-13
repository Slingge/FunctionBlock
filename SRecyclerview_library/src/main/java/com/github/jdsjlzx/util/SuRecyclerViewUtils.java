package com.github.jdsjlzx.util;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.jdsjlzx.recyclerview.SuRecyclerViewAdapter;

/**
 *
 * @author lizhixian
 * @time 16/9/10 09:54
 */
public class SuRecyclerViewUtils {

    /**
     * 设置HeaderView
     *
     * @param recyclerView
     * @param view
     */
    public static void setHeaderView(RecyclerView recyclerView, View view) {
        RecyclerView.Adapter outerAdapter = recyclerView.getAdapter();

        if (outerAdapter == null || !(outerAdapter instanceof SuRecyclerViewAdapter)) {
            return;
        }

        SuRecyclerViewAdapter suRecyclerViewAdapter = (SuRecyclerViewAdapter) outerAdapter;
        suRecyclerViewAdapter.addHeaderView(view);
    }

    /**
     * 设置FooterView
     *
     * @param recyclerView
     * @param view
     */
    public static void setFooterView(RecyclerView recyclerView, View view) {
        RecyclerView.Adapter outerAdapter = recyclerView.getAdapter();

        if (outerAdapter == null || !(outerAdapter instanceof SuRecyclerViewAdapter)) {
            return;
        }

        SuRecyclerViewAdapter suRecyclerViewAdapter = (SuRecyclerViewAdapter) outerAdapter;

        if (suRecyclerViewAdapter.getFooterViewsCount() > 0) {
            suRecyclerViewAdapter.removeFooterView(suRecyclerViewAdapter.getFooterView());
        }
        suRecyclerViewAdapter.addFooterView(view);
    }

    /**
     * 移除FooterView
     *
     * @param recyclerView
     */
    public static void removeFooterView(RecyclerView recyclerView) {

        RecyclerView.Adapter outerAdapter = recyclerView.getAdapter();

        if (outerAdapter != null && outerAdapter instanceof SuRecyclerViewAdapter) {

            int footerViewCounter = ((SuRecyclerViewAdapter) outerAdapter).getFooterViewsCount();
            if (footerViewCounter > 0) {
                View footerView = ((SuRecyclerViewAdapter) outerAdapter).getFooterView();
                ((SuRecyclerViewAdapter) outerAdapter).removeFooterView(footerView);
            }
        }
    }

    /**
     * 移除HeaderView
     *
     * @param recyclerView
     */
    public static void removeHeaderView(RecyclerView recyclerView) {

        RecyclerView.Adapter outerAdapter = recyclerView.getAdapter();

        if (outerAdapter != null && outerAdapter instanceof SuRecyclerViewAdapter) {

            int headerViewCounter = ((SuRecyclerViewAdapter) outerAdapter).getHeaderViewsCount();
            if (headerViewCounter > 0) {
                View headerView = ((SuRecyclerViewAdapter) outerAdapter).getHeaderView();
                ((SuRecyclerViewAdapter) outerAdapter).removeHeaderView(headerView);
            }
        }
    }

    /**
     * 请使用本方法替代RecyclerView.ViewHolder的getLayoutPosition()方法
     *
     * @param recyclerView
     * @param holder
     * @return
     */
    public static int getLayoutPosition(RecyclerView recyclerView, RecyclerView.ViewHolder holder) {
        RecyclerView.Adapter outerAdapter = recyclerView.getAdapter();
        if (outerAdapter != null && outerAdapter instanceof SuRecyclerViewAdapter) {

            int headerViewCounter = ((SuRecyclerViewAdapter) outerAdapter).getHeaderViewsCount();
            if (headerViewCounter > 0) {
                return holder.getLayoutPosition() - headerViewCounter;
            }
        }

        return holder.getLayoutPosition();
    }

    /**
     * 请使用本方法替代RecyclerView.ViewHolder的getAdapterPosition()方法
     *
     * @param recyclerView
     * @param holder
     * @return
     */
    public static int getAdapterPosition(RecyclerView recyclerView, RecyclerView.ViewHolder holder) {
        RecyclerView.Adapter outerAdapter = recyclerView.getAdapter();
        if (outerAdapter != null && outerAdapter instanceof SuRecyclerViewAdapter) {

            int headerViewCounter = ((SuRecyclerViewAdapter) outerAdapter).getHeaderViewsCount();
            if (headerViewCounter > 0) {
                return holder.getAdapterPosition() - headerViewCounter;
            }
        }

        return holder.getAdapterPosition();
    }
}