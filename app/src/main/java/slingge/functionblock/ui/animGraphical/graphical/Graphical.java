package slingge.functionblock.ui.animGraphical.graphical;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Slingge on 2017/3/31 0031.
 */

public class Graphical extends View {

    private int width, hight;//图型宽高


    public Graphical(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        hight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect=new Rect(0,0,width,hight);//尺寸，设置画布大小
        /**
         * 画笔类
         * 1、setAntiAlias()：设置画笔的锯齿效果
         * 2、setColor()：设置画笔的颜色
         * 3、setARGB()：设置画笔的A、R、G、B值
         * 4、setAlpha()：设置画笔的Alpha值
         * 5、setTextSize()：设置字体的尺寸
         * 6、setStyle()：设置画笔的风格（空心或实心）
         * 7、setStrokeWidth()：设置空心边框的宽度
         * 8、getColor()：获取画笔的颜色
         * */
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        /**
         * 画布类，1、canvas.drawLine();绘制直线，
         * 2、canvas.drawRect()绘制矩形,
         * 3、canvas.drawCircle();绘制圆形
         * 4、canvas.drawText();绘制字符
         * 5、canvas.drawBirmap();绘制图形
         * */
        canvas.drawRect(rect,paint);

    }



}
