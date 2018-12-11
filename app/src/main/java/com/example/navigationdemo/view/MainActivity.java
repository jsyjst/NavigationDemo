package com.example.navigationdemo.view;


import android.support.v4.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.navigationdemo.R;
import com.example.navigationdemo.utils.CommonUtil;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    public static final String TAG = "jsyjst";

    private RadioButton homeRb, phoneRb, findRb, personalRb;
    private RadioGroup mRadioGroup;
    private HomeFragment mHomeFragment;
    private PhoneFragment mPhoneFragment;
    private PersonalFragment mPersonalFragment;
    private FindFragment mFindFragment;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: mainActivity");
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

        mRadioGroup = findViewById(R.id.radio_group);
        mRadioGroup.setOnCheckedChangeListener(this);
        homeRb = findViewById(R.id.rd_home);
        phoneRb = findViewById(R.id.rd_phone);
        findRb = findViewById(R.id.rd_find);
        personalRb = findViewById(R.id.rd_personal);
        homeRb.setChecked(true);

        /**
         * 底部导航的时候会发生图片的颜色变化
         * 所以radiobutton中的照片不是一张
         * 而是引用了自定义的选择器照片
         */
        Drawable home = ContextCompat.getDrawable(this, R.drawable.selector_home_drawable);
        /**
         *  当这个图片被绘制时，给他绑定一个矩形规定这个矩形
         *  参数前两个对应图片相对于左上角的新位置，后两个为图片的长宽
         */
        home.setBounds(0, 0, 80, 80);
        //设置图片在文字的哪个方向,分别对应左，上，右，下
        homeRb.setCompoundDrawables(null, home, null, null);

        Drawable phone = ContextCompat.getDrawable(this, R.drawable.selector_phone_drawable);
        phone.setBounds(0, 0, 80, 80);
        phoneRb.setCompoundDrawables(null, phone, null, null);

        Drawable find = ContextCompat.getDrawable(this, R.drawable.selector_find_drawable);
        find.setBounds(0, 0, 80, 80);
        findRb.setCompoundDrawables(null, find, null, null);

        Drawable personal = ContextCompat.getDrawable(this, R.drawable.selector_personal_drawable);
        personal.setBounds(0, 0, 80, 80);
        personalRb.setCompoundDrawables(null, personal, null, null);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        transaction = getSupportFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        switch (checkedId) {
            case R.id.rd_home:
                if (mHomeFragment == null) {
                    Log.d(TAG, "onCheckedChanged: new Home");
                    mHomeFragment = new HomeFragment();
                    transaction.add(R.id.fragment_container, mHomeFragment);
                    CommonUtil.hideStatusBar(this,this,false);
                } else {
                    transaction.show(mHomeFragment);
                    CommonUtil.hideStatusBar(this,this,false);
                }
                break;
            case R.id.rd_phone:
                if (mPhoneFragment == null) {
                    mPhoneFragment = new PhoneFragment();
                    transaction.add(R.id.fragment_container, mPhoneFragment);
                    CommonUtil.hideStatusBar(this,this,false);
                } else {
                    transaction.show(mPhoneFragment);
                    CommonUtil.hideStatusBar(this,this,false);
                }
                break;
            case R.id.rd_find:
                if (mFindFragment == null) {
                    mFindFragment = new FindFragment();
                    transaction.add(R.id.fragment_container, mFindFragment);
                    CommonUtil.hideStatusBar(this,this,false);
                } else {
                    transaction.show(mFindFragment);
                    CommonUtil.hideStatusBar(this,this,false);
                }
                break;
            case R.id.rd_personal:
                if (mPersonalFragment == null) {
                    mPersonalFragment = new PersonalFragment();
                    transaction.add(R.id.fragment_container, mPersonalFragment);
                    CommonUtil.hideStatusBar(this,this,true);
                } else {
                    transaction.show(mPersonalFragment);
                    CommonUtil.hideStatusBar(this,this,true);
                }
                break;
        }
        transaction.commit();
    }

    public void hideAllFragment(FragmentTransaction transaction) {
        if (mHomeFragment != null) {
            Log.d(TAG, "hideAllFragment: HomeFragment");
            transaction.hide(mHomeFragment);
        }
        if (mPhoneFragment != null) {
            transaction.hide(mPhoneFragment);
        }
        if (mFindFragment != null) {
            transaction.hide(mFindFragment);
        }
        if (mPersonalFragment != null) {
            transaction.hide(mPersonalFragment);
        }
    }


}
