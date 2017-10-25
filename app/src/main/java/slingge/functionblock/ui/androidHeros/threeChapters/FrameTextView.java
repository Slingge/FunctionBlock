package slingge.functionblock.ui.androidHeros.threeChapters;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;

import slingge.functionblock.R;

/**
 * 带边框的textview
 * Created by Administrator on 2017/10/25 0025.
 */

public class FrameTextView extends android.support.v7.widget.AppCompatTextView {


    public FrameTextView(Context context) {
        super(context);
    }

    public FrameTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FrameTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//Paint类包含有用来画几何图形、文本、位图的类型和颜色等信息，如果把Canvas类看作是画板，那我们可以把Paint类看做是画笔，可以根据需要画出不同颜色和样式的图形、文本等内容。
        Paint point1 = new Paint();
        point1.setColor(getResources().getColor(R.color.AsukaColor));
        point1.setStyle(Paint.Style.FILL);

        Paint point2 = new Paint();
        point2.setColor(getResources().getColor(R.color.gray));
        point1.setStyle(Paint.Style.FILL);
    }
}
