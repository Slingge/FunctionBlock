package slingge.functionblock.ui.animGraphical;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import slingge.functionblock.R;

/**
 * 属性动画
 * alpha 控制透明度
 * rotation 旋转
 * translationX 水平位移
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
        }
    }
}
