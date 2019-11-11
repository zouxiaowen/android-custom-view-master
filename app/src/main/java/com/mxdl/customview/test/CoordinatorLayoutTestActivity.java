package com.mxdl.customview.test;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.gyf.immersionbar.ImmersionBar;
import com.mxdl.customview.AppBarStateChangeListener;
import com.mxdl.customview.MyPagerAdapter;
import com.mxdl.customview.R;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge.BadgePagerTitleView;

import java.util.Arrays;
import java.util.List;

public class CoordinatorLayoutTestActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private MagicIndicator magic_indicator;
    AppBarLayout appBarLayout;
    Toolbar toolbar;
    ImageView image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout_test);
        collapsingToolbarLayout = findViewById(R.id.cancel_action);
        image = findViewById(R.id.image);
         toolbar = findViewById(R.id.view_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.mipmap.callback_white_icon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mViewPager = findViewById(R.id.pager);
        appBarLayout = findViewById(R.id.action_bar);
        magic_indicator = findViewById(R.id.magic_indicator);
        initMagicIndicator3();
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(myPagerAdapter);
        ImmersionBar.with(this).titleBar(toolbar).statusBarDarkFont(true,0.2f).init();

        appBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if( state == State.EXPANDED ) {
                    //展开状态
                    Log.d("xiaomoxiaowen","展开状态");
                    ImmersionBar.with(CoordinatorLayoutTestActivity.this).titleBar(toolbar).init();
                }else if(state == State.COLLAPSED){
                    Log.d("xiaomoxiaowen","折叠状态");
                    //折叠状态
                    toolbar.setBackgroundColor(Color.WHITE);
                    ImmersionBar.with(CoordinatorLayoutTestActivity.this).titleBar(toolbar).statusBarDarkFont(true,0.2f).init();
                    //剩下就是返回图标设置一下就欧克了
                }else {
                    Log.d("xiaomoxiaowen","中间状态");
                    toolbar.setBackgroundColor(Color.parseColor("#00ffffff"));
//                    mImmersionBar.titleBar(toolbar).init();
                    collapsingToolbarLayout.setBackgroundResource(R.mipmap.homepage_pic_banner);
                    ImmersionBar.with(CoordinatorLayoutTestActivity.this).titleBar(toolbar).statusBarDarkFont(true,0.2f).init();

                    //中间状态
                }
            }
        });
    }

    private void initMagicIndicator3() {
        String[] CHANNELS = new String[]{"首页", "上新", "小视频","图集"};
        final List<String> mDataList = Arrays.asList(CHANNELS);
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return mDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                BadgePagerTitleView badgePagerTitleView = new BadgePagerTitleView(context);
                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
                simplePagerTitleView.setNormalColor(Color.BLACK);
                simplePagerTitleView.setSelectedColor(Color.parseColor("#06BD01"));
                simplePagerTitleView.setText(mDataList.get(index));
                simplePagerTitleView.setTextSize(15);
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mViewPager.setCurrentItem(index);
                    }
                });
                badgePagerTitleView.setInnerPagerTitleView(simplePagerTitleView);
                return badgePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
                indicator.setColors(Color.parseColor("#06BD01"));
                return indicator;
            }
        });
        commonNavigator.setAdjustMode(true); //ture 即标题平分屏幕宽度的模式
        magic_indicator.setNavigator(commonNavigator);
        LinearLayout titleContainer = commonNavigator.getTitleContainer(); // must after setNavigator
        titleContainer.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        titleContainer.setDividerDrawable(new ColorDrawable() {
            @Override
            public int getIntrinsicWidth() {
                return UIUtil.dip2px(CoordinatorLayoutTestActivity.this, 13);
            }
        });
        ViewPagerHelper.bind(magic_indicator, mViewPager);
    }

}
