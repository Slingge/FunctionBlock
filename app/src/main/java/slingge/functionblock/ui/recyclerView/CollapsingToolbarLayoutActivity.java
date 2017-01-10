package slingge.functionblock.ui.recyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.util.RecyclerViewStateUtils;
import com.github.jdsjlzx.view.LoadingFooter;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import slingge.functionblock.R;
import slingge.functionblock.ui.SlinggeActivity;
import slingge.functionblock.ui.recyclerView.adapter.CollDataAdapter;
import slingge.functionblock.ui.recyclerView.bean.ItemModel;
import slingge.functionblock.util.NetworkUtils;
import slingge.functionblock.view.StatusBarUtil;

/**
 * 使用CoordinatorLayout协调者布局为根布局
 *
 * Created by Slingge on 2017/1/10 0010.
 */

public class CollapsingToolbarLayoutActivity extends SlinggeActivity {

    /**
     * 服务器端一共多少条数据
     */
    private static final int TOTAL_COUNTER = 64;
    /**
     * 每一页展示多少条数据
     */
    private static final int REQUEST_COUNT = 10;
    /**
     * 已经获取到多少条数据了
     */
    private static int mCurrentCounter = 0;


    private LRecyclerView mRecyclerView = null;
    private CollDataAdapter mDataAdapter = null;

    private LRecyclerViewAdapter mLRecyclerViewAdapter = null;
    private PreviewHandler mHandler = new PreviewHandler(this);

    private boolean isRefresh = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_collapsing_toolbar_layout);

        mRecyclerView = (LRecyclerView) findViewById(R.id.list);
        ArrayList<ItemModel> dataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            ItemModel item = new ItemModel();
            item.id = i;
            item.title = "Winry Rockbell" + i;
            dataList.add(item);
        }

        mCurrentCounter = dataList.size();
        mDataAdapter = new CollDataAdapter(this);
        mDataAdapter.addAll(dataList);

        mLRecyclerViewAdapter = new LRecyclerViewAdapter(mDataAdapter);
        mRecyclerView.setAdapter(mLRecyclerViewAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setLScrollListener(new LRecyclerView.LScrollListener() {
            @Override
            public void onRefresh() {
                RecyclerViewStateUtils.setFooterViewState(mRecyclerView, LoadingFooter.State.Normal);
                mDataAdapter.clear();
                mCurrentCounter = 0;
                isRefresh = true;
                requestData();
            }

            @Override
            public void onScrollUp() {

            }

            @Override
            public void onScrollDown() {

            }

            @Override
            public void onBottom() {
                LoadingFooter.State state = RecyclerViewStateUtils.getFooterViewState(mRecyclerView);
                if (state == LoadingFooter.State.Loading) {
                    return;
                }
                if (mCurrentCounter < TOTAL_COUNTER) {
                    // loading more
                    RecyclerViewStateUtils.setFooterViewState(CollapsingToolbarLayoutActivity.this, mRecyclerView, REQUEST_COUNT, LoadingFooter.State.Loading, null);
                    requestData();
                } else {
                    //the end
                    RecyclerViewStateUtils.setFooterViewState(CollapsingToolbarLayoutActivity.this, mRecyclerView, REQUEST_COUNT, LoadingFooter.State.TheEnd, null);

                }
            }

            @Override
            public void onScrolled(int distanceX, int distanceY) {

            }
        });

    }


    /**
     * 模拟请求网络
     */
    private void requestData() {
        new Thread() {

            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //模拟一下网络请求失败的情况
                if (NetworkUtils.isNetAvailable(CollapsingToolbarLayoutActivity.this)) {
                    mHandler.sendEmptyMessage(-1);
                } else {
                    mHandler.sendEmptyMessage(-3);
                }
            }
        }.start();
    }


    private class PreviewHandler extends Handler {
        private WeakReference<CollapsingToolbarLayoutActivity> ref;

        PreviewHandler(CollapsingToolbarLayoutActivity activity) {
            ref = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            CollapsingToolbarLayoutActivity activity = ref.get();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            switch (msg.what) {
                case -1:
                    if (activity.isRefresh) {
                        activity.mDataAdapter.clear();
                        mCurrentCounter = 0;
                    }
                    int currentSize = activity.mDataAdapter.getItemCount();
                    //模拟组装10个数据
                    ArrayList<ItemModel> newList = new ArrayList<>();
                    for (int i = 0; i < 10; i++) {
                        if (newList.size() + currentSize >= TOTAL_COUNTER) {
                            break;
                        }
                        ItemModel item = new ItemModel();
                        item.id = currentSize + i;
                        item.title = "item" + (item.id);
                        newList.add(item);
                    }
                    activity.addItems(newList);
                    if (activity.isRefresh) {
                        activity.isRefresh = false;
                        activity.mRecyclerView.refreshComplete();
                        activity.notifyDataSetChanged();
                    } else {
                        RecyclerViewStateUtils.setFooterViewState(activity.mRecyclerView, LoadingFooter.State.Normal);
                    }
                    break;
                case -2:
                    activity.notifyDataSetChanged();
                    break;
                case -3:
                    if (activity.isRefresh) {
                        activity.isRefresh = false;
                        activity.mRecyclerView.refreshComplete();
                        activity.notifyDataSetChanged();
                    }
                    break;
            }
        }

    }


    private void notifyDataSetChanged() {
        mLRecyclerViewAdapter.notifyDataSetChanged();
    }

    private void addItems(ArrayList<ItemModel> list) {
        mDataAdapter.addAll(list);
        mCurrentCounter += list.size();
    }

}
