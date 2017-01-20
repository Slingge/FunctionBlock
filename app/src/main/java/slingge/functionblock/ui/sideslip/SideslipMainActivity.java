package slingge.functionblock.ui.sideslip;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import slingge.functionblock.R;
import slingge.functionblock.ui.SlinggeActivity;
import slingge.functionblock.view.BlurBitmap;
import slingge.functionblock.view.StatusBarUtil;


/**
 * 侧滑
 * DrawerLayout 侧滑布局
 * Created by Slingge on 2017/1/12 0012.
 */

public class SideslipMainActivity extends SlinggeActivity {

    private DrawerLayout drawerLayout;
    private TabLayout tabLayout;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sideslip_main);
        initView();
        initToolbar();
        initTabLayout();
//        StatusBarUtil.translucentBar(this);
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Asuka");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);//true显示title
    }

    /**
     * 打开侧菜单
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void initView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        tabLayout = (TabLayout) findViewById(R.id.tabs);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);//悬浮按钮
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Snackbar snackbar = Snackbar.make(v, "测试弹出提示", Snackbar.LENGTH_LONG);
                snackbar.setActionTextColor(getResources().getColor(R.color.AsukaColor));
                snackbar.show();
                snackbar.setAction("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SideslipMainActivity.this, "SnackBar action", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        //左侧菜单
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        View headerView = navigationView.getHeaderView(0);
        ImageView image_bg = (ImageView) headerView.findViewById(R.id.image_bg);
        image_bg.setImageBitmap(BlurBitmap.blur(this, BitmapFactory.decodeResource(getResources(), R.drawable.ic_ab1)));
        image_bg.setAlpha(Float.valueOf(100));//模糊效果，API17及以上

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override//左侧菜单监听
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
//                    case R.id.
                }
                return false;
            }
        });
    }

    private void initTabLayout() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        List<String> tabList = new ArrayList<>();
        tabList.add("Tab  1");
        tabList.add("Tab2");
        tabList.add("Tab3");
        tabList.add("TabTab 4");
        tabList.add("Tab5");
        tabList.add("Tab6");
        tabList.add("Tab   TabTabTabTab    7");
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);//设置tab模式，当前为系统默认模式
        //此处代码设置无效，不知道为啥？？？xml属性是可以的
//        tabLayout.setTabTextColors(android.R.color.white, android.R.color.holo_red_dark);//设置TabLayout两种状态
        tabLayout.addTab(tabLayout.newTab().setText(tabList.get(0)));//添加tab选项卡
        tabLayout.addTab(tabLayout.newTab().setText(tabList.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(tabList.get(2)));
        tabLayout.addTab(tabLayout.newTab().setText(tabList.get(3)));
        tabLayout.addTab(tabLayout.newTab().setText(tabList.get(4)));
        tabLayout.addTab(tabLayout.newTab().setText(tabList.get(5)));
        tabLayout.addTab(tabLayout.newTab().setText(tabList.get(6)));

        List<Fragment> fragmentList = new ArrayList<>();
        Fragment f0 = new TabFragment0();
        Bundle bundle = new Bundle();
        bundle.putString("content", "0");
        f0.setArguments(bundle);
        fragmentList.add(f0);

        Fragment f1 = new TabFragment1();
        bundle = new Bundle();
        bundle.putString("content", "1");
        f1.setArguments(bundle);
        fragmentList.add(f1);

        Fragment f2 = new TabFragment2();
        bundle = new Bundle();
        bundle.putString("content", "2");
        f2.setArguments(bundle);
        fragmentList.add(f2);

        Fragment f3 = new TabFragment3();
        bundle = new Bundle();
        bundle.putString("content", "3");
        f3.setArguments(bundle);
        fragmentList.add(f3);

        Fragment f4 = new TabFragment4();
        bundle = new Bundle();
        bundle.putString("content", "4");
        f4.setArguments(bundle);
        fragmentList.add(f4);

        Fragment f5 = new TabFragment5();
        bundle = new Bundle();
        bundle.putString("content", "5");
        f5.setArguments(bundle);
        fragmentList.add(f5);

        Fragment f6 = new TabFragment6();
        bundle = new Bundle();
        bundle.putString("content", "6");
        f6.setArguments(bundle);
        fragmentList.add(f6);

       /* for (int i = 0; i < tabList.size(); i++) {
            Fragment f1 = new TabFragment();
            Bundle bundle = new Bundle();
            bundle.putString("content", i+"");
            f1.setArguments(bundle);
            fragmentList.add(f1);
        }*/
        TabFragmentAdapter fragmentAdapter = new TabFragmentAdapter(getSupportFragmentManager(), fragmentList, tabList);
        viewPager.setAdapter(fragmentAdapter);//给ViewPager设置适配器
        tabLayout.setupWithViewPager(viewPager);//将TabLayout和ViewPager关联起来。
        tabLayout.setTabsFromPagerAdapter(fragmentAdapter);//给Tabs设置适配器
    }


}
