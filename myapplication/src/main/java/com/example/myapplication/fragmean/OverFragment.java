package com.example.myapplication.fragmean;
/*
 *@auther:谷建龙
 *@Date: 2019/11/23
 *@Time:11:34
 *@Description:
 * */


import android.view.View;

import com.example.myapplication.Base.BaseFragment;
import com.example.myapplication.Base.BasePresenter;
import com.example.myapplication.R;

public class OverFragment extends BaseFragment {
    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected int layoutId() {
        return R.layout.over_fragment;
    }

    @Override
    protected void getDing() {

    }

    @Override
    public void onSuccess(String json) {

    }

    @Override
    public void onError(String error) {

    }
}
