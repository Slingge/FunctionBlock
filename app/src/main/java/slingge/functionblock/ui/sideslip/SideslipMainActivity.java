package slingge.functionblock.ui.sideslip;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;
import android.widget.ImageView;


import slingge.functionblock.R;
import slingge.functionblock.ui.SlinggeActivity;
import slingge.functionblock.view.BlurBitmap;

import static slingge.functionblock.R.id.image_bg;

/**
 * 侧滑
 * DrawerLayout 侧滑布局
 * Created by Slingge on 2017/1/12 0012.
 */

public class SideslipMainActivity extends SlinggeActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sideslip_main);
        initView();
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void initView() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        ImageView image_bg = (ImageView) navigationView.findViewById(R.id.image_bg);
        if (image_bg != null) {
            image_bg.setImageBitmap(BlurBitmap.blur(this, BitmapFactory.decodeResource(getResources(), R.drawable.ic_bg2)));
            image_bg.setAlpha(Float.valueOf(100));//模糊效果，API17及以上
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
//                    case R.id.
                }

                return false;
            }
        });

    }

}
