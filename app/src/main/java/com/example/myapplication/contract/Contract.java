package com.example.myapplication.contract;
/*
 *@auther:谷建龙
 *@Date: 2019/11/22
 *@Time:10:22
 *@Description:
 * */

//定义契约类
public interface Contract {
    interface MyCallBack {
        void onSuccess(String jaon);

        void onError(String error);
    }

    interface IModel {
        void getInfo(String url, MyCallBack myCallBack);
    }

    interface IView {
        void onSuccess(String jaon);

        void onError(String error);
    }

    interface IPresenter {
        void startRequest(String url);
    }
}
