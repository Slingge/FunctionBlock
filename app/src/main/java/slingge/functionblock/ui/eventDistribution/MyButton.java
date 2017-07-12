package slingge.functionblock.ui.eventDistribution;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;


/**
 * Created by Administrator on 2017/6/2 0002.
 */

public class MyButton extends android.support.v7.widget.AppCompatButton {

    private final String TAG = "MyButton";

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "MyButton-onTouch_ACTION_DOWN");//打印顺序4
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "MyButton-onTouch_ACTION_UP");//打印顺序8
                break;
        }
        return super.onTouchEvent(event);
    }


    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "MyButton-dispatchTouchEvent.ACTION_DOWN");//打印顺序2
//                break;
                return false;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "MyButton-dispatchTouchEvent.ACTION_UP");//打印顺序6
                break;
        }
        return super.dispatchTouchEvent(event);
    }

}
