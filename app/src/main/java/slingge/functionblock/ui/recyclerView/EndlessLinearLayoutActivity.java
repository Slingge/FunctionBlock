package slingge.functionblock.ui.recyclerView;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.jdsjlzx.recyclerview.SRecyclerView;
import com.github.jdsjlzx.recyclerview.SRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.github.jdsjlzx.util.RecyclerViewStateUtils;
import com.github.jdsjlzx.util.RecyclerViewUtils;
import com.github.jdsjlzx.view.LoadingFooter;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import slingge.functionblock.R;
import slingge.functionblock.ui.SlinggeActivity;
import slingge.functionblock.ui.recyclerView.adapter.ListBaseAdapter;
import slingge.functionblock.ui.recyclerView.bean.ItemModel;
import slingge.functionblock.ui.recyclerView.weight.SampleHeader;
import slingge.functionblock.util.NetworkUtils;
import slingge.functionblock.util.ToastUtil;


/**
 * 带HeaderView的分页加载LinearLayout RecyclerView
 * Created by Slingge on 2017/1/8 0008.
 */

public class EndlessLinearLayoutActivity extends SlinggeActivity {

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

    private SRecyclerView mRecyclerView = null;
    private DataAdapter mDataAdapter = null;
    private PreviewHandler mHandler = new PreviewHandler(this);
    private SRecyclerViewAdapter mSRecyclerViewAdapter = null;

    private boolean isRefresh = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_endless_linearl_ayout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView = (SRecyclerView) findViewById(R.id.list);

        ArrayList<ItemModel> dataList = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            ItemModel item = new ItemModel();
            item.id = i;
            item.title = "item" + i;
//            dataList.add(item);
        }
        mCurrentCounter = dataList.size();
        mDataAdapter = new DataAdapter(this);
        mDataAdapter.addAll(dataList);

        mSRecyclerViewAdapter = new SRecyclerViewAdapter(mDataAdapter);
        mRecyclerView.setAdapter(mSRecyclerViewAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setArrowImageView(R.drawable.ic_pulltorefresh_arrow);

        SampleHeader sampleHeader=new SampleHeader(this);
        RecyclerViewUtils.setHeaderView(mRecyclerView, sampleHeader);
       ImageView image= (ImageView) sampleHeader.findViewById(R.id.image);
        image.setImageResource(R.drawable.ic_bg2);
//        RecyclerViewUtils.setFooterView(mRecyclerView, new SampleFooter(this));

        mRecyclerView.setLScrollListener(new SRecyclerView.LScrollListener() {
            @Override
            public void onRefresh() {
                RecyclerViewStateUtils.setFooterViewState(mRecyclerView, LoadingFooter.State.Normal);
                mDataAdapter.clear();
                mSRecyclerViewAdapter.notifyDataSetChanged();//fix bug:crapped or attached views may not be recycled. isScrap:false isAttached:true
                mCurrentCounter = 0;
                isRefresh = true;
                requestData();
            }

            @Override
            public void onScrollUp() {
                Toast.makeText(EndlessLinearLayoutActivity.this, "向上", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onScrollDown() {
                Toast.makeText(EndlessLinearLayoutActivity.this, "向下", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBottom() {
                LoadingFooter.State state = RecyclerViewStateUtils.getFooterViewState(mRecyclerView);
                if (state == LoadingFooter.State.Loading) {
                    return;
                }

                if (mCurrentCounter < TOTAL_COUNTER) {
                    // loading more
                    RecyclerViewStateUtils.setFooterViewState(EndlessLinearLayoutActivity.this, mRecyclerView, REQUEST_COUNT, LoadingFooter.State.Loading, null);
                    requestData();
                } else {
                    //the end
                    RecyclerViewStateUtils.setFooterViewState(EndlessLinearLayoutActivity.this, mRecyclerView, REQUEST_COUNT, LoadingFooter.State.TheEnd, null);

                }
            }

            @Override
            public void onScrolled(int distanceX, int distanceY) {
            }

        });
        mRecyclerView.setRefreshing(true);
    }


    private void notifyDataSetChanged() {
        mSRecyclerViewAdapter.notifyDataSetChanged();
    }

    private void addItems(ArrayList<ItemModel> list) {
        mDataAdapter.addAll(list);
        mCurrentCounter += list.size();
    }

    private class PreviewHandler extends Handler {

        private WeakReference<EndlessLinearLayoutActivity> ref;

        PreviewHandler(EndlessLinearLayoutActivity activity) {
            ref = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            final EndlessLinearLayoutActivity activity = ref.get();
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
                    }
                    RecyclerViewStateUtils.setFooterViewState(activity.mRecyclerView, LoadingFooter.State.Normal);
                    activity.notifyDataSetChanged();
                    break;
                case -2:
                    activity.notifyDataSetChanged();
                    break;
                case -3:
                    ToastUtil.showToast(EndlessLinearLayoutActivity.this, "网络错误");
                    if (activity.isRefresh) {
                        activity.isRefresh = false;
                        activity.mRecyclerView.refreshComplete();
                    }
                    activity.notifyDataSetChanged();
                    RecyclerViewStateUtils.setFooterViewState(activity, activity.mRecyclerView, REQUEST_COUNT, LoadingFooter.State.NetWorkError, activity.mFooterClick);
                    break;
                default:
                    break;
            }
        }
    }

    private View.OnClickListener mFooterClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerViewStateUtils.setFooterViewState(EndlessLinearLayoutActivity.this, mRecyclerView, REQUEST_COUNT, LoadingFooter.State.Loading, null);
            requestData();
        }
    };


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
                if (NetworkUtils.isNetAvailable(EndlessLinearLayoutActivity.this)) {
                    mHandler.sendEmptyMessage(-1);
                } else {
                    mHandler.sendEmptyMessage(-3);
                }
            }
        }.start();
    }


    private class DataAdapter extends ListBaseAdapter<ItemModel> {

        private LayoutInflater mLayoutInflater;

        public DataAdapter(Context context) {
            mContext = context;
            mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mLayoutInflater.inflate(R.layout.list_item_text, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            super.onBindViewHolder(holder, position);
            final ItemModel item = list.get(position);
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.tectView.setText(item.title);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(EndlessLinearLayoutActivity.this, item.title, Toast.LENGTH_SHORT).show();
                }
            });
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    Toast.makeText(EndlessLinearLayoutActivity.this, "OnLongClickListener:" + item.title, Toast.LENGTH_SHORT).show();
                    return false;//true 表示事件不再向下传递
                }
            });

        }

        private class ViewHolder extends RecyclerView.ViewHolder {

            TextView tectView;

            public ViewHolder(View itemView) {
                super(itemView);
                tectView = (TextView) itemView.findViewById(R.id.info_text);
            }
        }

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_refresh, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else if (item.getItemId() == R.id.menu_refresh) {
            mRecyclerView.forceToRefresh();
        }
        return true;
    }

}
