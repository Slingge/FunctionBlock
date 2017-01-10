package slingge.functionblock.ui.layout;

import android.os.Bundle;
import android.support.annotation.Nullable;

import slingge.functionblock.R;
import slingge.functionblock.ui.SlinggeActivity;

/**
 * 卡片布局，相当于FrameLayout
 * 需要 compile 'com.android.support:cardview-v7:24.2.1'
 * Created by Slingge on 2017/1/7 0007.
 * android:foreground="?android:attr/selectableItemBackground" 点击时背景色
 */

public class CardViewLayout extends SlinggeActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cardview);
    }
}
