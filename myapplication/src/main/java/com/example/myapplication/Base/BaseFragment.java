package com.example.myapplication.Base;
/*
 *@auther:谷建龙
 *@Date: 2019/11/23
 *@Time:11:03
 *@Description:
 * */


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.contract.Contract;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements Contract.IView {
    public P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(layoutId(), container, false);
        initView(inflate);
        mPresenter = getPresenter();
        if (mPresenter != null) {
            mPresenter.onAttchView(this);
        }
        return inflate;
    }

    protected abstract P getPresenter();

    protected abstract void initView(View inflate);

    protected abstract int layoutId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDing();
    }

    protected abstract void getDing();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDeAttchView();
        }
    }
}
