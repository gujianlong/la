package com.example.myapplication.base;
/*
 *@auther:谷建龙
 *@Date: 2019/11/22
 *@Time:10:26
 *@Description:
 * */

import com.example.myapplication.contract.Contract;

import java.lang.ref.WeakReference;

//*②　抽取MVP中BasePresenter基类，在此添加绑定视图和解绑的方法
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
