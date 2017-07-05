package slingge.functionblock.ui.animGraphical;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import slingge.functionblock.R;
import slingge.functionblock.util.ToastUtil;


/**
 * 属性动画
 * alpha 控制透明度
 * rotation 旋转
 * translationX 水平位移
 * <p>
 * 组合动画：
 * after(Animater anim)将现有动画插入到传入的动画之后执行
 * after(long delay) 将现有动画插入到传入的动画之后执行
 * before(Animater anim) 将现有动画插入到传入的动画之前执行
 * with(Animater anim) 将现有动画和传入的动画同时执行
 * <p>
 * TypeEvaluator 动画如何从初始值过渡到结束值
 * <p>
 * <p>
 * Created by Slingge on 2017/5/18 0018.
 */

public class AttributeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attribute);
        init();
    }

    private void init() {
        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("属性动画");
        tv1 = (TextView) findViewById(R.id.tv1);
        Button but1 = (Button) findViewById(R.id.but1);
        but1.setOnClickListener(this);
        Button but2 = (Button) findViewById(R.id.but2);
        but2.setOnClickListener(this);
        Button but3 = (Button) findViewById(R.id.but3);
        but3.setOnClickListener(this);
        Button but4 = (Button) findViewById(R.id.but4);
        but4.setOnClickListener(this);
        Button but5 = (Button) findViewById(R.id.but5);
        but5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.but1:
                ObjectAnimator anim = new ObjectAnimator().ofFloat(tv1, "alpha", 0f, 1f);//从透明度0到完全显示
                anim.setDuration(1500);//动画持续时间
                anim.start();
                break;
            case R.id.but2:
                anim = new ObjectAnimator().ofFloat(tv1, "rotation", 0f, 360f);
                anim.setDuration(1500);//动画持续时间
                anim.start();
                break;
            case R.id.but3:
                float x = tv1.getTranslationX();//获取textView的translationX位置，第三个参数怎么移动
                float y = tv1.getTranslationY();
                anim = new ObjectAnimator().ofFloat(tv1, "translationY", 0, -500f, y);
                anim.setDuration(5000);
                anim.start();
                break;
            case R.id.but4:
                anim = new ObjectAnimator().ofFloat(tv1, "scaleY", 1f, 3f);
                anim.setDuration(3000);
//                anim.setRepeatMode(ValueAnimator.RESTART);//重新开始模式
                anim.setRepeatMode(ValueAnimator.REVERSE);//逆向开始
                anim.setRepeatCount(200000);//次数
                anim.start();
                anim = new ObjectAnimator().ofFloat(tv1, "scaleX", 1f, 3f);
                anim.setDuration(3000);
                anim.setRepeatMode(ValueAnimator.REVERSE);//逆向开始
                anim.setRepeatCount(ValueAnimator.INFINITE);//循环
                anim.start();

                anim.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        ToastUtil.showToast(AttributeActivity.this, "动画结束");
                    }
                });
                break;
            case R.id.but5:
                ObjectAnimator anim1 = new ObjectAnimator().ofFloat(tv1, "scaleY", 1f, 3f, 1f);
                ObjectAnimator anim2 = new ObjectAnimator().ofFloat(tv1, "scaleX", 1f, 3f, 1f);
                ObjectAnimator anim3 = new ObjectAnimator().ofFloat(tv1, "rotation", 0f, 360f);
                AnimatorSet anset = new AnimatorSet();
                anset.play(anim1).with(anim2).before(anim3);//先播放anim3，再同时播放anim、anim2
                anset.setDuration(3000);
                anset.start();
                break;
        }
    }


}
