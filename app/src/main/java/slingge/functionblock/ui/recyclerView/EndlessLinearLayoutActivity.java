package slingge.functionblock.ui.recyclerView;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.jdsjlzx.recyclerview.LRecyclerView;

import java.util.List;

import slingge.functionblock.R;
import slingge.functionblock.ui.SlinggeActivity;
import slingge.functionblock.ui.recyclerView.adapter.ListBaseAdapter;
import slingge.functionblock.ui.recyclerView.bean.ItemModel;


/**
 * 带HeaderView的分页加载LinearLayout RecyclerView
 * Created by Slingge on 2017/1/8 0008.
 */

public class EndlessLinearLayoutActivity extends SlinggeActivity {

    private LRecyclerView mRecyclerView = null;

    private DataAdapter mDataAdapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_endless_linearl_ayout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }





    private class DataAdapter extends ListBaseAdapter<ItemModel> {

        private Context context;
        private List<ItemModel> list;

        public DataAdapter(Context context, List<ItemModel> list) {
            mContext = context;
            this.list = list;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.list_item_text, parent, false);
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
                    Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show();
                }
            });
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    Toast.makeText(context, "OnLongClickListener:" + item.title, Toast.LENGTH_SHORT).show();
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

}
