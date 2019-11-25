package com.example.myapplication.fragment;
/*
 *@auther:谷建龙
 *@Date: 2019/11/22
 *@Time:10:50
 *@Description:
 * */


import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.myapplication.R;
import com.example.myapplication.adapter.MyAdapter;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.bean.Bean;
import com.example.myapplication.presenter.Presenter;
import com.example.myapplication.view.MyGroup;
import com.example.myapplication.view.MyView;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private List<Bean.ResultBean> list = new ArrayList<>();
    private MyAdapter myAdapter;
    private String str1="http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=";
    private String str2="&page=1&count=5";
    private MyView myView;
    private MyGroup myGroup;

    @Override
    protected void initView(View inflate) {
        recyclerView = inflate.findViewById(R.id.rv);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        myAdapter = new MyAdapter(getActivity(), list);
        recyclerView.setAdapter(myAdapter);
        myView = inflate.findViewById(R.id.myView);
        myGroup = inflate.findViewById(R.id.myGroup);
    }

    @Override
    protected int layoutId() {
        return R.layout.home_fragment;
    }

    @Override
    protected void getConDing() {
        myView.setOnSetClick(new MyView.OnSetClick() {
            @Override
            public void onClick(String url) {
                mPresenter.startRequest(str1+ URLEncoder.encode(url) +str2);
                myGroup.addCount(url);
            }
        });
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    public void onSuccess(String jaon) {
        Gson gson = new Gson();
        Bean bean = gson.fromJson(jaon, Bean.class);
        List<Bean.ResultBean> result = bean.getResult();
        list.clear();
        list.addAll(result);
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String error) {

    }
}
