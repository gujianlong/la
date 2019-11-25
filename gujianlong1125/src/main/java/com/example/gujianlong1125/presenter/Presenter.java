package com.example.gujianlong1125.presenter;
/*
 *@auther:谷建龙
 *@Date: 2019/11/25
 *@Time:9:08
 *@Description:
 * */


import com.example.gujianlong1125.base.BasePresenter;
import com.example.gujianlong1125.contract.Contract;
import com.example.gujianlong1125.model.Model;

public class Presenter extends BasePresenter {
    private Contract.IModel iModel;

    @Override
    protected void initModel() {
        iModel = new Model();
    }

    @Override
    public void startRequest(String url) {
        iModel.getInfo(url, new Contract.MyCallBack() {
            @Override
            public void onGet(String json) {
                getView().onGet(json);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }
}
