package slingge.functionblock.ui.moveFinish;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Scroller;

import java.util.LinkedList;
import java.util.List;

import slingge.functionblock.util.ToastUtil;

import static android.R.transition.move;


/**
 * @author xiaanming
 * @blog http://blog.csdn.net/xiaanming
 */
public class SwipeBackLayout extends FrameLayout {
    private static final String TAG = SwipeBackLayout.class.getSimpleName();
    private View mContentView;
    private int mTouchSlop;
    private int downX;
    private int downY;
    private int tempY;
    private int tempX;
    private Scroller mScroller;
    private int viewWidth, viewHigh;
    private boolean isSilding;
    private boolean isFinish;
    //	private Drawable mShadowDrawable;
    private Activity mActivity;
    private List<ViewPager> mViewPagers = new LinkedList<>();

    public boolean isRightSlide = false;//是否可以向右滑动返回
    public boolean isLeftSlide = false;//是否可以向左滑动返回
    public boolean isUpSlide = false;//是否可以向右滑动返回
    public boolean isDownSlide = false;//是否可以向左滑动返回


    public SwipeBackLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwipeBackLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        mScroller = new Scroller(context);

//		mShadowDrawable = getResources().getDrawable(R.drawable.shadow_left);
    }


    public void attachToActivity(Activity activity) {
        mActivity = activity;
        TypedArray a = activity.getTheme().obtainStyledAttributes(
                new int[]{android.R.attr.windowBackground});
        int background = a.getResourceId(0, 0);
        a.recycle();

        ViewGroup decor = (ViewGroup) activity.getWindow().getDecorView();
        ViewGroup decorChild = (ViewGroup) decor.getChildAt(0);
        decorChild.setBackgroundResource(background);
        decor.removeView(decorChild);
        addView(decorChild);
        setContentView(decorChild);
        decor.addView(this);
    }

    private void setContentView(View decorChild) {
        mContentView = (View) decorChild.getParent();
    }

    /**
     * 事件拦截操作
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //处理ViewPager冲突问题
        ViewPager mViewPager = getTouchViewPager(mViewPagers, ev);
        Log.i(TAG, "mViewPager = " + mViewPager);

        if (mViewPager != null && mViewPager.getCurrentItem() != 0) {
            return super.onInterceptTouchEvent(ev);
        }

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = tempX = (int) ev.getRawX();
                downY = tempY = (int) ev.getRawY();
                Log.e("按下的Y点...........", downY + "");
                break;
            case MotionEvent.ACTION_MOVE:
                int moveX = (int) ev.getRawX();
                // 满足此条件屏蔽SildingFinishLayout里面子类的touch事件
                if (moveX - downX > mTouchSlop
                        && Math.abs((int) ev.getRawY() - downY) > mTouchSlop) {
                    return true;
                }
                break;
        }

        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                int moveX = (int) event.getRawX();
                int deltaX = tempX - moveX;

                int moveY = (int) event.getRawY();
                int deltaY = downY - moveY;

                tempX = moveX;
                if (Math.abs(moveX - downX) > mTouchSlop && Math.abs((int) event.getRawY() - downY) > mTouchSlop) {
                    isSilding = true;
                }

                if (moveX - downX > 0 && downY - moveY < 100 && isSilding) {
                    if (isRightSlide) {
                        mContentView.scrollBy(deltaX, 0);
                        return true;
                    }
                } else if (downX - moveX > 0 && isSilding) {
                    if (isLeftSlide) {
                        mContentView.scrollBy(deltaX, 0);
                        return true;
                    }
                } else if (downY - moveY > 0 && isSilding) {
                    Log.e("判断的Y点...........", downY + "" + moveY);
                    if (isUpSlide) {
                        mContentView.scrollBy(viewWidth, deltaY);
                        return true;
                    }
                }

                break;
            case MotionEvent.ACTION_UP:
                isSilding = false;
                if (mContentView.getScrollX() <= -viewWidth / 3) {//向右滑
                    isFinish = true;
                    if (isRightSlide) {
                        scrollRight();
                        return true;
                    }
                } else if (mContentView.getScrollX() >= viewWidth / 3) {//向左滑
                    isFinish = true;
                    if (isLeftSlide) {
                        scrollToLeft();
                    }
                } else if (mContentView.getScrollY() >= viewWidth / 5) {
                    isFinish = true;
                    if (isUpSlide) {
                        scrollToUp();
                    }
                } else {
                    scrollOrigin();
                    isFinish = false;
                }
                break;
        }

        return true;
    }

    /**
     * 获取SwipeBackLayout里面的ViewPager的集合
     *
     * @param mViewPagers
     * @param parent
     */
    private void getAlLViewPager(List<ViewPager> mViewPagers, ViewGroup parent) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            if (child instanceof ViewPager) {
                mViewPagers.add((ViewPager) child);
            } else if (child instanceof ViewGroup) {
                getAlLViewPager(mViewPagers, (ViewGroup) child);
            }
        }
    }


    /**
     * 返回我们touch的ViewPager
     *
     * @param mViewPagers
     * @param ev
     * @return
     */
    private ViewPager getTouchViewPager(List<ViewPager> mViewPagers, MotionEvent ev) {
        if (mViewPagers == null || mViewPagers.size() == 0) {
            return null;
        }
        Rect mRect = new Rect();
        for (ViewPager v : mViewPagers) {
            v.getHitRect(mRect);

            if (mRect.contains((int) ev.getX(), (int) ev.getY())) {
                return v;
            }
        }
        return null;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed) {
            viewWidth = this.getWidth();
            viewHigh = this.getHeight();
            getAlLViewPager(mViewPagers, this);
            Log.i(TAG, "ViewPager size = " + mViewPagers.size());
        }
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
       /* if (mShadowDrawable != null && mContentView != null) {

            int left = mContentView.getLeft()
                    - mShadowDrawable.getIntrinsicWidth();
            int right = left + mShadowDrawable.getIntrinsicWidth();
            int top = mContentView.getTop();
            int bottom = mContentView.getBottom();

            mShadowDrawable.setBounds(left, top, right, bottom);
            mShadowDrawable.draw(canvas);
        }*/

    }


    /**
     * 向右滚动出界面
     */
    private void scrollRight() {
        final int delta = (viewWidth + mContentView.getScrollX());
        // 调用startScroll方法来设置一些滚动的参数，我们在computeScroll()方法中调用scrollTo来滚动item
        mScroller.startScroll(mContentView.getScrollX(), 0, -delta + 1, 0, Math.abs(delta));
        postInvalidate();
    }


    /**
     * 滚动出界面至左侧
     */
    private void scrollToLeft() {
        final int delta = (viewWidth - mContentView.getScrollX());
        // 调用startScroll方法来设置一些滚动的参数，我们在computeScroll()方法中调用scrollTo来滚动item
        mScroller.startScroll(mContentView.getScrollX(), 0, delta - 1, 0, Math.abs(delta));//此处就不可用+1，也不卡直接用delta
        postInvalidate();
    }

    /**
     * 向右滚动出界面
     */
    private void scrollToUp() {
        final int delta = (viewWidth - mContentView.getScrollY());
        // 调用startScroll方法来设置一些滚动的参数，我们在computeScroll()方法中调用scrollTo来滚动item
        mScroller.startScroll(mContentView.getScrollY(), 0, delta - 1, 0, Math.abs(delta));//此处就不可用+1，也不卡直接用delta
        postInvalidate();
    }


    /**
     * 滚动到起始位置
     */
    private void scrollOrigin() {
        int delta = mContentView.getScrollX();
        mScroller.startScroll(mContentView.getScrollX(), 0, -delta, 0, Math.abs(delta));
        postInvalidate();
    }

    @Override
    public void computeScroll() {
        // 调用startScroll的时候scroller.computeScrollOffset()返回true，
        if (mScroller.computeScrollOffset()) {
            mContentView.scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();

            if (mScroller.isFinished() && isFinish) {
                mActivity.finish();
            }
        }
    }


}
