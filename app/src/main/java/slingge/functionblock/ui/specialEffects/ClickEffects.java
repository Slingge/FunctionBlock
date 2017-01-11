package slingge.functionblock.ui.specialEffects;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import slingge.functionblock.R;
import slingge.functionblock.ui.SlinggeActivity;

/**
 * 点击特效
 * Created by Slingge on 2017/1/11 0011.
 */

public class ClickEffects extends SlinggeActivity implements View.OnClickListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.effects_click);
        init();
    }

    private void init() {
        TextView tv_list = (TextView) findViewById(R.id.tv_list);
        tv_list.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_list:
                startActivity(new Intent(this, ListViewActivity.class));
                break;
        }
    }

}
