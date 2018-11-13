package slingge.functionblock.ui.layout;

import android.os.Bundle;
import android.support.annotation.Nullable;

import slingge.functionblock.R;
import slingge.functionblock.base.SlinggeActivity;

/**
 * 约束布局
 * Created by Slingge on 2017/7/5 0005.
 */

public class ConstraintLayout extends SlinggeActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_constraint);
        setTitle("约束布局");
    }


}
