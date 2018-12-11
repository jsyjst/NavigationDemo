package com.example.navigationdemo.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.navigationdemo.R;

/**
 * Created by 残渊 on 2018/8/17.
 */

@SuppressLint("ValidFragment")
public class TabFragment extends Fragment {
    private TextView titleTv;

    private String mTitle;

    //构造方法将标题传给Fragment
    public TabFragment(String title){
        mTitle=title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_tab,container,false);
        titleTv=view.findViewById(R.id.tv_title);
        titleTv.setText(mTitle); //内容填充为标题
        return view;
    }
}
