package com.example.myapplication.contract;
/*
 *@auther:谷建龙
 *@Date: 2019/11/23
 *@Time:10:52
 *@Description:
 * */


public interface Contract {
    interface MyCallBack {
        void onSuccess(String json);

        void onError(String error);
    }

    interface IModel {
        void getInfo(String url, MyCallBack myCallBack);
    }

    interface IView {
        void onSuccess(String json);

        void onError(String error);
    }

    interface IPresenter {
        void startRequest(String url);
    }
}
