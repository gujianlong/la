package com.example.myapplication.model;
/*
 *@auther:谷建龙
 *@Date: 2019/11/23
 *@Time:10:55
 *@Description:
 * */


import com.example.myapplication.contract.Contract;
import com.example.myapplication.utils.NetUtils;

public class Model implements Contract.IModel {
    @Override
    public void getInfo(String url, final Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().onDoGet(url, new NetUtils.MySuccess() {
            @Override
            public void onSuccess(String json) {
                myCallBack.onSuccess(json);
            }

            @Override
            public void onError(String error) {
                myCallBack.onError(error);
            }
        });
    }
}
