package slingge.functionblock.ui.animGraphical;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;


/**
 * Created by Slingge on 2017/7/12 0012.
 */

public class MyAnimView extends View {

    public static final float Radius = 50f;//半径50
    public Point currentPoint;
    private Paint mPaint;

    public MyAnimView(Context context) {
        super(context);
    }

    public MyAnimView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (currentPoint == null) {
            currentPoint = new Point(Radius, Radius);
            drawCircle(canvas);
//            startAnimation();
        } else {
            drawCircle(canvas);
        }
    }


    private void drawCircle(Canvas canvas) {
        float x = currentPoint.x;
        float y = currentPoint.y;
        canvas.drawCircle(x, y, Radius, mPaint);
    }


    public void startAnimation() {
        Point startPoint = new Point(Radius * 2, Radius * 2);
        Point endPoint = new Point(getWidth() - Radius, getHeight() - Radius);//动画结束位置，屏幕宽高-半径
        ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                currentPoint = (Point) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
//        anim.setInterpolator(new AccelerateInterpolator(1.5f));
//        anim.setDuration(3000);
//        anim.start();
        ObjectAnimator anim2 = ObjectAnimator.ofObject(this, "color", new ColorEvaluator(), "#0000FF", "#FF0000");
        AnimatorSet animset = new AnimatorSet();
        animset.play(anim).with(anim2);
        animset.setDuration(5000);
        animset.start();
    }


    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startAnimation();
                break;
        }
        return super.onTouchEvent(event);
    }


}

