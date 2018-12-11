package com.example.navigationdemo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.library.utils.ToastUtils;
import com.example.navigationdemo.R;
import com.example.navigationdemo.utils.CommonUtil;

/**
 * Created by 残渊 on 2018/8/17.
 */

public class PersonalFragment extends Fragment {
    private View mView;
    private Switch dayNightSwitch;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_personal, container, false);
            dayNightSwitch=mView.findViewById(R.id.switch_day_night);
        }
        return mView;

    }
    @Override
    public void onActivityCreated(Bundle saveInstanceState){
        super.onActivityCreated(saveInstanceState);

        initView();
        onClick();


    }
    private void initView(){
        //如果夜间模式打开，则按钮显示为打开
        if(CommonUtil.getData(getActivity())) {
            dayNightSwitch.setChecked(true);
        }
    }
    private void onClick(){
        dayNightSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked&&!CommonUtil.getData(getActivity())) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    CommonUtil.setData(getActivity(),true);
                    startActivity(new Intent(getActivity(), MainActivity.class));
                    getActivity().overridePendingTransition(R.anim.anim_animo_alph_open, R.anim.anim_animo_alph_close);
                    ToastUtils.show(getActivity(),"夜间模式开启");
                    getActivity().finish();
                }else if(!isChecked&& CommonUtil.getData(getActivity())){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    CommonUtil.setData(getActivity(),false);
                    startActivity(new Intent(getActivity(), MainActivity.class));
                    getActivity().overridePendingTransition(R.anim.anim_animo_alph_open, R.anim.anim_animo_alph_close);
                    getActivity().finish();
                }
            }
        });
    }
}
