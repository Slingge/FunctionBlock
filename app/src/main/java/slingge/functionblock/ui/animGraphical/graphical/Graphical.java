package slingge.functionblock.ui.animGraphical.graphical;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import slingge.functionblock.R;

/**
 * Created by Slingge on 2017/3/31 0031.
 */

public class Graphical extends View {

    private int width, hight;//图型宽高

    private String TAG = "Graphical..............";

    private Paint bgPaint;//背景颜色

    private Resources mRes;

    private Bitmap bgBitmap;//背景图
    private Rect bgDestRect;//背景图尺寸

    private Bitmap leafBitmap;//动画图片


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Graphical(Context context, AttributeSet attrs) {
        super(context, attrs);
        mRes = context.getResources();
        Log.e(TAG, "Graphical");//1
        bgPaint = new Paint();
        bgBitmap = ((BitmapDrawable) mRes.getDrawable(R.drawable.ic_3, null)).getBitmap();
        bgPaint.setColor(mRes.getColor(R.color.AsukaColor));

        leafBitmap = ((BitmapDrawable) mRes.getDrawable(R.drawable.ic_sh, null)).getBitmap();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //在控件大小发生改变时调用。所以这里初始化会被调用一次
        //View 大小发生变化
        Log.e(TAG, "onSizeChanged");//4
        width = w;
        hight = h;
        bgDestRect = new Rect(0, 0, width, hight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //最后绘制图型
        Log.e(TAG, "onDraw");//6
        RectF bgRect = new RectF(0, 0, width, hight);//背景尺寸
        Rect rect = new Rect(0, 0, width, hight);//尺寸，设置画布大小,左上右下

        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#000000"));
//        paint.setStyle();
        /**
         * Paint(画笔）类
         * 1、setAntiAlias()设置画笔锯齿效果
         * 2、setColor();设置画笔的颜色
         * 3、setARGB();设置画笔的A、R、G、B值
         * 4、setAlpha(); 设置alpha透明值
         * 5、settextSize();字体尺寸
         * 6、setStyle();//设置画笔风格（空心或实心）
         * 7、setStrokeWidth();设置空心边框的宽度
         * 8、getColor();获取画笔颜色
         * */

        /**
         * 画布类，1、canvas.drawLine();绘制直线，
         * 2、canvas.drawRect()绘制矩形,
         * 3、canvas.drawCircle();绘制圆形, cx X轴原点，cy Y轴原点，radius 半径，paint
         * 4、canvas.drawText();绘制字符
         * 5、canvas.drawBirmap();绘制图形
         * */
        canvas.drawRect(bgRect, bgPaint);//背景颜色
        canvas.drawBitmap(bgBitmap, null, bgDestRect, null);//背景图片
        canvas.drawCircle(width / 2, hight / 2, 30, paint);//圆形


        /**
         * Matrix 动画
         * 1、平移
         * 2、旋转
         * 3、缩放
         * 4、倾斜
         * */
        Matrix matrix=new Matrix();
        matrix.postTranslate(getMatriX(),hight/3);//平移，
        canvas.drawBitmap(leafBitmap, matrix, new Paint());//手里剑
        postInvalidate();//重复调用onDraw
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //在View放置到父容器时调用
        //作用：测量View的大小，也可以通过下面方式，修改View的大小

//        setMeasuredDimension(100,100);//修改View大小

        //获取大小
//        int width = MeasureSpec.getSize(widthMeasureSpec);
//       int height = MeasureSpec.getSize(heightMeasureSpec);

        Log.e(TAG, "onMeasure");//3or5
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        //当View中所有的子控件均被映射成xml后触发,从xml加载组件后回调
        Log.e(TAG, "onFinishInflate");//2
    }


    long cycleTime = 5000;//手里剑滑动一周时间
    long startTime = 0;//手里剑开始滑动时间

    /**
     * 获取X轴坐标
     * */
    private float getMatriX() {
        float betweenTime = startTime - System.currentTimeMillis();

        //周期结束再加一个cycleTime
        if (betweenTime < 0) {
            startTime = System.currentTimeMillis() + cycleTime;
            betweenTime = cycleTime;
        }

        //通过时间差计算出叶子的坐标
        float fraction = betweenTime / cycleTime;
        float x = (int) (width * fraction);

        return x;
    }


    /**
     * 获取Y轴坐标
     * */
//    private


}
