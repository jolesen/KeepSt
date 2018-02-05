package com.jnukeepst.keepst;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;




import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.jnukeepst.keepst.fragment.GameFragment;
import com.jnukeepst.keepst.fragment.HomePageFragment;
import com.jnukeepst.keepst.fragment.MovieFragment;
import com.jnukeepst.keepst.fragment.MusicFragment;

import java.util.ArrayList;
import java.util.List;




public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener, ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private BottomNavigationBar bottomNavigationBar;
    private BadgeItem badgeItem;//添加角边
    private List<Fragment> mList;//ViewPager的数据源

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBottomNavigationBar();
        initViewPager();
    }


    //初始化ViewPager
    private void initViewPager() {
        mList = new ArrayList<>();

        mList.add(new HomePageFragment());
        mList.add(new MusicFragment());

        mList.add(new MovieFragment());
        mList.add(new GameFragment());

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.addOnPageChangeListener(this);
        //下面过期了
        //viewPager.setOnPageChangeListener(this);
        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager(), mList);
        viewPager.setAdapter(mainAdapter); //视图加载适配器
    }


    //初始化底部导航条
    private void initBottomNavigationBar(){
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setTabSelectedListener(this);
        badgeItem = new BadgeItem()
                .setHideOnSelect(true) //设置被选中的时隐藏角标
                .setBackgroundColor(Color.RED)
                .setText("99");

        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);

        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        bottomNavigationBar.setBackgroundStyle(R.color.black);

        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.home, "首页").setActiveColorResource(R.color.white))
                .addItem(new BottomNavigationItem(R.drawable.music, "音乐").setActiveColorResource(R.color.white))
                .addItem(new BottomNavigationItem(R.drawable.film, "电影").setActiveColorResource(R.color.white).setBadgeItem(badgeItem))
                .addItem(new BottomNavigationItem(R.drawable.game, "游戏").setActiveColorResource(R.color.white))
                .setFirstSelectedPosition(0)
                .initialise(); //所有的设置需在调用该方法前完成
    }



    @Override
    public void onTabSelected(int position) {
        //tab被选中
        viewPager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //ViewPager滑动
        bottomNavigationBar.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }



}
