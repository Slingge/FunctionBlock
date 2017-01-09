package slingge.functionblock.ui.recyclerView.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import slingge.functionblock.ui.recyclerView.bean.Entity;

/**
 * Created by Slingge on 2017/1/8 0008.
 */

public class ListBaseAdapter<T extends Entity> extends RecyclerView.Adapter {

    protected Context mContext;
    protected ArrayList<T> mDataList = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public List<T> getdatalist() {
        return mDataList;
    }

    public void setDataList(Collection<T> dataList) {
        this.mDataList.clear();
        this.mDataList.addAll(dataList);
        notifyDataSetChanged();
    }

    public void addAll(Collection<T> dataList) {
        int lastIndex = this.mDataList.size();
        if (this.mDataList.addAll(dataList)) {
            notifyItemRangeInserted(lastIndex, mDataList.size());
        }
    }

    public void delete(int position) {
        mDataList.remove(position);
        notifyDataSetChanged();
    }

    public void clear() {
        mDataList.clear();
        notifyDataSetChanged();
    }

}
