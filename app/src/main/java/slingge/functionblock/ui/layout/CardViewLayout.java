package slingge.functionblock.ui.layout;

import android.os.Bundle;
import android.support.annotation.Nullable;

import slingge.functionblock.R;
import slingge.functionblock.ui.SlinggeActivity;

/**
 * Created by Slingge on 2017/1/7 0007.
 */

public class CardViewLayout extends SlinggeActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cardview);
    }
}
