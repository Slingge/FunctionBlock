package slingge.functionblock.ui.recyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import slingge.functionblock.R;
import slingge.functionblock.ui.SlinggeActivity;

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
        }
    }
}
