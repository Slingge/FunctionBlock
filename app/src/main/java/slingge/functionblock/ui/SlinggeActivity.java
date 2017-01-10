package slingge.functionblock.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

import slingge.functionblock.R;
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
    }


}
