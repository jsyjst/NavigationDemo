package com.example.navigationdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.example.navigationdemo.view.TabFragment;

import java.util.List;

/**
 * Created by 残渊 on 2018/8/17.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    private List<TabFragment> mFragmentList;//顶部导航栏的内容即fragment
    private List<String> mTitle;//顶部导航栏的标题


    public FragmentAdapter(FragmentManager fragmentManager,List<TabFragment>fragments,List<String>title){
        super(fragmentManager);
        mFragmentList=fragments;
        mTitle=title;

    }
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
