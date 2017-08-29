package slingge.functionblock.ui.moveFinish;

import android.os.Bundle;
import android.support.annotation.Nullable;

import slingge.functionblock.R;
import slingge.functionblock.ui.SlinggeActivity;

/**
 * Created by Slingge on 2017/8/29 0029.
 */

public class TestActivity extends SlinggeActivity implements SildingFinishLayout.OnSildingFinishListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void initBaseActivity(boolean enableleftSild, boolean enableRightdsild) {
        SildingFinishLayout sildingLayout = (SildingFinishLayout) findViewById(R.id.slidingfinish);
        sildingLayout.setOnSildingFinishListener(this);
        sildingLayout.setEnableLeftSildeEvent(enableleftSild);
        sildingLayout.setEnableRightSildeEvent(enableRightdsild);
    }


    @Override
    public void onSildingBack() {
        finish();
    }

    @Override
    public void onSildingForward() {
        finish();
    }
}
