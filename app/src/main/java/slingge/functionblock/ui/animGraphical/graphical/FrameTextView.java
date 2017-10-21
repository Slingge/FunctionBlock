package slingge.functionblock.ui.animGraphical.graphical;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import slingge.functionblock.R;

/**
 * 带边框的textView
 * Created by Administrator on 2017/8/10 0010.
 */

public class FrameTextView extends android.support.v7.widget.AppCompatTextView {


    private Context context;


    public FrameTextView(Context context) {
        super(context);
        this.context=context;
    }

    public FrameTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FrameTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {


        Paint paint1=new Paint();
        paint1.setColor(getResources().getColor(R.color.AsukaColor));
        paint1.setStyle(Paint.Style.FILL);

        Paint paint2=new Paint();
        paint2.setColor(getResources().getColor(R.color.white));
        paint2.setStyle(Paint.Style.FILL);

        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),paint1);
        canvas.drawRect(10,10,getMeasuredWidth()-10,getMeasuredHeight()-10,paint2);

        canvas.save();
        canvas.translate(10,0);
        super.onDraw(canvas);
        canvas.restore();


    }
}
