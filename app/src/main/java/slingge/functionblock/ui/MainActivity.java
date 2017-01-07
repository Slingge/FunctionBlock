package slingge.functionblock.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import slingge.functionblock.R;
import slingge.functionblock.ui.layout.LayoutViewActivity;

public class MainActivity extends SlinggeActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        TextView tv_layout = (TextView) findViewById(R.id.tv_layout);
        tv_layout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_layout:
                startActivity(new Intent(this, LayoutViewActivity.class));
                break;
        }
    }
}
