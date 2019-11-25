package com.example.myapplication.presenter;
/*
 *@auther:谷建龙
 *@Date: 2019/11/23
 *@Time:11:16
 *@Description:
 * */


import com.example.myapplication.Base.BasePresenter;
import com.example.myapplication.contract.Contract;
import com.example.myapplication.model.Model;

public class Presenter extends BasePresenter {
    private Contract.IModel iModel;
    @Override
    protected void initModel() {
        iModel=new Model();
    }

    @Override
    public void startRequest(String url) {
        iModel.getInfo(url, new Contract.MyCallBack() {
            @Override
            public void onSuccess(String json) {
                getView().onSuccess(json);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }
}
