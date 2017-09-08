package slingge.functionblock.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import slingge.functionblock.R;
import slingge.functionblock.ui.animGraphical.GraphicalActivity;
import slingge.functionblock.ui.eventDistribution.EventDistributionActivity;
import slingge.functionblock.ui.layout.LayoutViewActivity;
import slingge.functionblock.ui.webView.WebViewActivity;
import slingge.functionblock.ui.recyclerView.RecyclerViewActivity;
import slingge.functionblock.ui.sideslip.SideslipMainActivity;
import slingge.functionblock.ui.specialEffects.ClickEffects;
import slingge.functionblock.util.ToastUtil;


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
        TextView tv_recyclerView = (TextView) findViewById(R.id.tv_recyclerView);
        tv_recyclerView.setOnClickListener(this);
        TextView tv_effects = (TextView) findViewById(R.id.tv_effects);
        tv_effects.setOnClickListener(this);
        TextView tv_slid = (TextView) findViewById(R.id.tv_slid);
        tv_slid.setOnClickListener(this);
        TextView tv_anim = (TextView) findViewById(R.id.tv_anim);
        tv_anim.setOnClickListener(this);
        TextView tv_event = (TextView) findViewById(R.id.tv_event);
        tv_event.setOnClickListener(this);
        TextView tv_webView = (TextView) findViewById(R.id.tv_webView);
        tv_webView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_layout:
                startActivity(new Intent(this, LayoutViewActivity.class));
                break;
            case R.id.tv_recyclerView:
                startActivity(new Intent(this, RecyclerViewActivity.class));
                break;
            case R.id.tv_effects:
                startActivity(new Intent(this, ClickEffects.class));
                break;
            case R.id.tv_slid:
                startActivity(new Intent(this, SideslipMainActivity.class));
                break;
            case R.id.tv_anim:
                startActivity(new Intent(this, GraphicalActivity.class));
                break;
            case R.id.tv_event:
                startActivity(new Intent(this, EventDistributionActivity.class));
                break;
            case R.id.tv_webView:
                startActivity(new Intent(this, WebViewActivity.class));
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) { //RESULT_OK = -1
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("result");
            Toast.makeText(MainActivity.this, scanResult, Toast.LENGTH_LONG).show();
        }
    }


}
