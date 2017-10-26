package slingge.functionblock.ui.animGraphical.graphical;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;

import slingge.functionblock.R;

/**
 * 带边框的,闪烁的textView
 * Created by Administrator on 2017/8/10 0010.
 */

public class FrameTextView extends android.support.v7.widget.AppCompatTextView {


    private Context context;

    private int mViewWidth, mTranslate;
    private Matrix mGradientMatrix;
    private Paint mPaint;
    private LinearGradient mLinearGradient;


    public FrameTextView(Context context) {
        super(context);
        this.context = context;
    }

    public FrameTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FrameTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {


        Paint paint1 = new Paint();
        paint1.setColor(getResources().getColor(R.color.AsukaColor));//边框颜色
        //Paint.Style.STROKE 只绘制图形轮廓（描边） , Paint.Style.FILL 只绘制图形内容,  Paint.Style.FILL_AND_STROKE 既绘制轮廓也绘制内容
        paint1.setStyle(Paint.Style.FILL);

        Paint paint2 = new Paint();
        paint2.setColor(getResources().getColor(R.color.white));//textview 内颜色
        paint2.setStyle(Paint.Style.FILL);

        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint1);//左，上，右，下，到屏幕的距离
        canvas.drawRect(10, 10, getMeasuredWidth() - 10, getMeasuredHeight() - 10, paint2);

        canvas.save();
        canvas.translate(10, 0);
        //在回调父类方法前，实现自己的逻辑，对TextView来时就是绘制文本内容前
        super.onDraw(canvas);
        //在回调父类方法后，实现自己的逻辑，对TextView来时就是绘制文本内容后
        canvas.restore();//用来恢复Canvas之前保存的状态,防止save()方法代码之后对Canvas运行的操作。

        if (mGradientMatrix != null) {
            mTranslate += mViewWidth / 5;
            if (mTranslate > 2 * mViewWidth) {
                mTranslate = -mViewWidth;
            }
            mGradientMatrix.setTranslate(mTranslate, 0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(100);
        }
    }


    //使用shader渲染器，实现闪动的效果
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mViewWidth = getMeasuredWidth();//view的原始的值
        if (mViewWidth > 0) {
            mPaint = getPaint();
            mLinearGradient = new LinearGradient(0, 0, mViewWidth, 0, new int[]{Color.WHITE, Color.parseColor("#b50220"),Color.parseColor("#6950a1")}, null, Shader.TileMode.REPEAT);
            mPaint.setShader(mLinearGradient);
            mGradientMatrix = new Matrix();
        }

    }
}
