package slingge.functionblock.ui.animGraphical;

import android.animation.TypeEvaluator;

/**
 * 将startValue和endValue强转成Point对象，然后同样根据fraction来计算当前动画的x和y的值，最后组装到一个新的Point对象当中并返回。
 * Created by Slingge on 2017/7/12 0012.
 */

public class PointEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float v, Object o, Object t1) {
        Point startPoint = (Point) o;
        Point endPoint = (Point) t1;
        float x = startPoint.x + v * (endPoint.x) - startPoint.x;
        float y = startPoint.y + v * (endPoint.y) - startPoint.y;
        Point point = new Point(x, y);
        return point;
    }
}
