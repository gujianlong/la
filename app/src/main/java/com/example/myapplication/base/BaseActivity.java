package com.example.myapplication.base;
/*
 *@auther:谷建龙
 *@Date: 2019/11/22
 *@Time:10:31
 *@Description:
 * */


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.contract.Contract;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements Contract.IView {
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (layoutId() != 0) {
            setContentView(layoutId());
            initView();
            mPresenter = getPresenter();
            if (mPresenter != null) {
                mPresenter.onAttchView(this);
            }
            getConDing();
        }

    }

    protected abstract void getConDing();

    protected abstract P getPresenter();

    protected abstract void initView();

    protected abstract int layoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //防止内存泄露
        if (mPresenter != null) {
            mPresenter.onDeAttchView();
        }
    }
}
