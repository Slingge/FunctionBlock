package slingge.functionblock.ui.animGraphical;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/10/21 0021.
 */

public class ImageClipView extends View {

    private Bitmap leftImage;
    private Matrix leftMatrix;
    private float padding = 10;
    private Path left;
    private Paint paint;

    private int state = -1;
    private final int START = 1;

    public ImageClipView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ImageClipView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageClipView(Context context) {
        super(context);
    }

    private void init() {
        Bitmap bitmap = Bitmap.createBitmap(getWidth(), getHeight(),
                Bitmap.Config.ARGB_8888);
        bitmap.eraseColor(Color.parseColor("#FF0000"));//填充颜色

        leftImage = bitmap;

        paint = new Paint();
        paint.setAntiAlias(true);
        initMatrix();
        initPath();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (leftImage != null) {
            canvas.save();
            canvas.clipPath(left);
            canvas.drawBitmap(leftImage, leftMatrix, paint);
            canvas.restore();
            canvas.save();
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right,
                            int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (state > 0) {
            return;
        }
        state = START;
        init();
    }

    private void initMatrix() {
        leftMatrix = new Matrix();

        float w = getWidth();
        float h = getHeight();

        //第一个图片
        float scale = 1;
        float scaleX = w / leftImage.getWidth();
        float scaleY = h / leftImage.getHeight();
        scale = scaleX > scaleY ? scaleX : scaleY;
        leftMatrix.setScale(scale, scale);


    }

    private void initPath() {

        float cpad = padding / 2;//padding = 10

        float w = getWidth();
        float h = getHeight();
        float bx = w ;
        float by = h / 2;

        left = new Path();

        left.moveTo(padding, padding);
        left.lineTo(bx - cpad, padding);
        left.lineTo(bx - cpad, by);
        left.lineTo(padding, h - 1.7f * padding);
        left.lineTo(padding, padding);
        left.close();

    }

}