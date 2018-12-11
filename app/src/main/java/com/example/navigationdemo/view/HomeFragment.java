package com.example.navigationdemo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationdemo.R;
import com.example.navigationdemo.adapter.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 残渊 on 2018/8/17.
 */

public class HomeFragment extends Fragment{
    private ViewPager pager;
    private FragmentAdapter fragmentAdapter;
    private List<TabFragment> fragmentList;
    private TabLayout tabLayout;
    private List<String> mTitles;
    private String [] title={"关注","推荐","广州","视频","热点"};
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        pager=view.findViewById(R.id.page);
        tabLayout=view.findViewById(R.id.tab_layout);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        fragmentList=new ArrayList<>();
        mTitles=new ArrayList<>();
        for(int i=0;i<title.length;i++){
            mTitles.add(title[i]);
            fragmentList.add(new TabFragment(title[i]));
        }

        fragmentAdapter=new FragmentAdapter(getActivity().getSupportFragmentManager(),fragmentList,mTitles);
        pager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(pager);//与ViewPage建立关系
    }

}
