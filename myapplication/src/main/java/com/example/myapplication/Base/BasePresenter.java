package com.example.myapplication.Base;
/*
 *@auther:谷建龙
 *@Date: 2019/11/23
 *@Time:10:56
 *@Description:
 * */


import com.example.myapplication.contract.Contract;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends Contract.IView> implements Contract.IPresenter {
    private WeakReference<V> mWeak;

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    protected void onAttchView(V v) {
        mWeak = new WeakReference<>(v);
    }

    protected void onDeAttchView() {
        if (mWeak != null) {
            mWeak.clear();
            mWeak = null;
        }
    }

    protected V getView() {
        return mWeak.get();
    }
}
