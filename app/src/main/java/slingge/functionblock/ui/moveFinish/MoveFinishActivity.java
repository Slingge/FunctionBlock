package slingge.functionblock.ui.moveFinish;

import android.os.Bundle;
import android.support.annotation.Nullable;

import slingge.functionblock.R;

/**
 * 滑动返回
 * Created by Slingge on 2017/8/29 0029.
 */

public class MoveFinishActivity extends TestActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movefinish);
        initBaseActivity(true, true);
    }


}
