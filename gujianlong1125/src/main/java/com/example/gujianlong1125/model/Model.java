package com.example.gujianlong1125.model;
/*
 *@auther:谷建龙
 *@Date: 2019/11/25
 *@Time:9:00
 *@Description:
 * */


import com.example.gujianlong1125.contract.Contract;
import com.example.gujianlong1125.utils.NetUtils;

public class Model implements Contract.IModel {
    @Override
    public void getInfo(String url, final Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().onDoGet(url, new NetUtils.MySuccess() {
            @Override
            public void onSuccess(String json) {
                myCallBack.onGet(json);
            }

            @Override
            public void onError(String error) {
                myCallBack.onError(error);
            }
        });
    }
}
