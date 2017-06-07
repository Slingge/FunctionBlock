package slingge.functionblock.ui.eventDistribution;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.TextViewCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import slingge.functionblock.R;
import slingge.functionblock.ui.SlinggeActivity;
import slingge.functionblock.util.ToastUtil;


/**
 * 事件分发
 * <p>
 * 事件分发、焦点问题
 * touch事件分发机制：只有两种类型 View和ViewGroup
 * View单一的没有子控件，ViewGroup多个View或者ViewGroup组成（布局等）
 * ViewGroup的相关事件有3个：1、onIntercepterTouch 2、dispatchTouchEvent 3、onTouchEvent
 * View的相关事件有2个：1、dispatchTouchEvent 2、ontouchEvent
 * onIntercepterTouch 拦截
 * dispatchTouchEvent 分发
 * onTouchEvent 处理
 * <p>
 * 先外后里，先拦截、分发、再处理
 * <p>
 * 打印顺序
 * <p>
 * Created by Administrator on 2017/6/2 0002.
 */

public class EventDistributionActivity extends SlinggeActivity implements View.OnClickListener {

    private String TAG = "EventActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventdistribution);
        init();
    }


    private void init() {
        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("事件分发");
        ImageView image_back = (ImageView) findViewById(R.id.image_back);
        image_back.setOnClickListener(this);

        MyButton but1 = (MyButton) findViewById(R.id.but1);
        but1.setOnClickListener(this);

        but1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.e(TAG, "onTouch_ACTION_DOWN");//打印顺序3
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.e(TAG, "onTouch_ACTION_UP");////打印顺序7
                        break;
                }
                return false;
            }
        });

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "dispatchTouchEvent_ACTION_DOWN");//打印顺序1
                break;
//                return false;  //将只响应本Activity dispatchTouchEvent UP、Down事件,（针对ViewGroup）true表示消费掉事件，false表示不再向下传递
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "dispatchTouchEvent_ACTION_UP");//打印顺序5
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                finish();
                break;
            case R.id.but1:
                ToastUtil.showToast(this, "butOnclick打印顺序9");
                Log.e(TAG, "onClickButton");//打印顺序9
                break;
        }
    }
}
