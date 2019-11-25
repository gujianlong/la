package com.example.gujianlong1125.contract;
/*
 *@auther:谷建龙
 *@Date: 2019/11/25
 *@Time:8:57
 *@Description:
 * */


public interface Contract {
    interface MyCallBack {
        void onGet(String json);

        void onError(String error);
    }

    interface IModel {
        void getInfo(String url, MyCallBack myCallBack);
    }

    interface IView {
        void onGet(String json);

        void onError(String error);
    }

    interface IPresenter {
        void startRequest(String url);
    }
}
