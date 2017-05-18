package slingge.functionblock.ui.animGraphical;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import slingge.functionblock.R;
import slingge.functionblock.ui.SlinggeActivity;

/**
 * Created by Slingge on 2017/3/31 0031.
 */

public class GraphicalActivity extends SlinggeActivity implements View.OnClickListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anim_graphical);
        init();
    }


    private void init() {
        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("动画");
        TextView tv_attribute = (TextView) findViewById(R.id.tv_attribute);
        tv_attribute.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_attribute:
                Intent intent = new Intent(this, AttributeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
