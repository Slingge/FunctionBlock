package slingge.functionblock.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import slingge.functionblock.R;
import slingge.functionblock.ui.moveFinish.SwipeBackLayout;
import slingge.functionblock.view.StatusBarUtil;

/**
 * Created by Slingge on 2017/1/6 0006.
 */

public class SlinggeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            StatusBarUtil.setColor(this, this.getResources().getColor(R.color.AsukaColor));
        }
        SwipeBackLayout layout = (SwipeBackLayout) LayoutInflater.from(this).inflate(
                R.layout.base_sildingfinish, null);
        layout.isRightSlide = true;
        layout.isLeftSlide = true;
        layout.isUpSlide = true;
        layout.isDownSlide = true;
        layout.attachToActivity(this);
    }


    protected void setTitle(String title) {
        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        ImageView image_back = (ImageView) findViewById(R.id.image_back);
        tv_title.setText(title);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.base_slide_right_in, R.anim.base_slide_remain);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.base_slide_right_out);
    }


}
