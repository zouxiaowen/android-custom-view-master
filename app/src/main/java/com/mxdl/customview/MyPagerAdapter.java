package com.mxdl.customview;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;

public class MyPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments = new ArrayList<>(1);
    private static final String[] TITLES = new String[]{"首页", "上新", "小视频","图集"};

    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        fragments.add(new HomePageFragment());
        fragments.add(new OnNewFragment());
        fragments.add(new SmallVideoFragment());
        fragments.add(new AtlasFragment());
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }
}
