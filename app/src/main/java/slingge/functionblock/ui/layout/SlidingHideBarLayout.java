package slingge.functionblock.ui.layout;

import android.os.Bundle;
import android.support.annotation.Nullable;

import slingge.functionblock.R;
import slingge.functionblock.base.SlinggeActivity;

/**
 * 滑动隐藏显示标题、导航
 * CoordinatorLayout类似于FrameLayout，所以注意xml层次，TitleBar和BottomTab要在xml下方。
 * 只有实现NestScorll接口View的才可以实现监听，例如RecyclerView、NestScrollView.
 * 在ListView下，是不生效的。
 * Created by Slingge on 2017/1/7 0007.
 */

public class SlidingHideBarLayout extends SlinggeActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sliding_hide_action_bar);
    }

}
