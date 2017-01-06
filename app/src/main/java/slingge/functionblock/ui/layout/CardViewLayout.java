package slingge.functionblock.ui.layout;

import android.os.Bundle;
import android.os.PersistableBundle;

import slingge.functionblock.R;
import slingge.functionblock.ui.SlinggeActivity;

/**
 * CardView相当于FrameLayout布局
 * Created by Slingge on 2017/1/6 0006.
 */

public class CardViewLayout extends SlinggeActivity {


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.layout_cardview);
    }


}
