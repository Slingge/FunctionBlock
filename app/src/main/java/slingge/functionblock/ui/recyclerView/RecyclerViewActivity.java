package slingge.functionblock.ui.recyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.SRecyclerView;
import com.github.jdsjlzx.recyclerview.ProgressStyle;

import slingge.functionblock.R;
import slingge.functionblock.ui.SlinggeActivity;
import slingge.functionblock.ui.recyclerView.listener.RecyclerItemTouchListener;
import slingge.functionblock.util.ToastUtil;

/**
 * 各种RecyclerView
 * Created by Slingge on 2017/1/8 0008.
 */

public class RecyclerViewActivity extends SlinggeActivity implements View.OnClickListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);
        init();
    }

    private void init() {
        TextView tv_endlessline = (TextView) findViewById(R.id.tv_endlessline);
        tv_endlessline.setOnClickListener(this);
        TextView tv_collapsing_toolbar = (TextView) findViewById(R.id.tv_collapsing_toolbar);
        tv_collapsing_toolbar.setOnClickListener(this);
        TextView tv_BottomSheetDialog = (TextView) findViewById(R.id.tv_BottomSheetDialog);
        tv_BottomSheetDialog.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_endlessline:
                startActivity(new Intent(this, EndlessLinearLayoutActivity.class));
                break;
            case R.id.tv_collapsing_toolbar:
                startActivity(new Intent(this, CollapsingToolbarLayoutActivity.class));
                break;
            case R.id.tv_BottomSheetDialog:
                select();
                break;
        }
    }

    public void select() {
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(this)
                .inflate(R.layout.bottomsheetdialog_list, null);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        Adapter adapter = new Adapter();
        recyclerView.setAdapter(adapter);

        final BottomSheetDialog dialog = new BottomSheetDialog(this);
        dialog.setContentView(recyclerView);
        dialog.show();
        recyclerView.addOnItemTouchListener(new RecyclerItemTouchListener(recyclerView) {
            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {
                int position = vh.getAdapterPosition();
                ToastUtil.showToast(RecyclerViewActivity.this, "First Lieutenant Riza Hawkeye  " + position);
            }
        });
    }

    class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

        @Override
        public Adapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.bottomsheetdialog_item, parent, false);
            return new Holder(item);
        }

        @Override
        public void onBindViewHolder(final Adapter.Holder holder, int position) {
            holder.tv.setText("First Lieutenant Riza Hawkeye  " + position);
        }

        @Override
        public int getItemCount() {
            return 15;
        }

        class Holder extends RecyclerView.ViewHolder {
            TextView tv;

            public Holder(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.text);
            }
        }

    }


}
