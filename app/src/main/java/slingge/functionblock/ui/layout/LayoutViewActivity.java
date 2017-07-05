package slingge.functionblock.ui.layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import slingge.functionblock.R;
import slingge.functionblock.ui.SlinggeActivity;

/**
 * 布局类
 * Created by Slingge on 2017/1/7 0007.
 */

public class LayoutViewActivity extends SlinggeActivity implements View.OnClickListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_view);
        init();
    }

    private void init() {
        TextView tv_card_layout = (TextView) findViewById(R.id.tv_card_layout);
        tv_card_layout.setOnClickListener(this);

        TextView tv_slidingbar_layout = (TextView) findViewById(R.id.tv_slidingbar_layout);
        tv_slidingbar_layout.setOnClickListener(this);
        TextView tv_constraintLayout = (TextView) findViewById(R.id.tv_constraintLayout);
        tv_constraintLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.tv_card_layout:
                startActivity(new Intent(this, CardViewLayout.class));
                break;
            case R.id.tv_slidingbar_layout:
                startActivity(new Intent(this, SlidingHideBarLayout.class));
                break;
            case R.id.tv_constraintLayout:
                startActivity(new Intent(this, ConstraintLayout.class));
                break;
        }

    }
}
