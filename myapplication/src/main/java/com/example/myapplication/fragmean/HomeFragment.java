package com.example.myapplication.fragmean;
/*
 *@auther:谷建龙
 *@Date: 2019/11/23
 *@Time:11:33
 *@Description:
 * */


import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.myapplication.Base.BaseFragment;
import com.example.myapplication.Base.BasePresenter;
import com.example.myapplication.R;
import com.example.myapplication.adapter.MyAdapter;
import com.example.myapplication.bean.Bean;
import com.example.myapplication.presenter.Presenter;
import com.example.myapplication.view.MyView;
import com.google.gson.Gson;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private String str1 = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=";
    private String str2 = "&page=1&count=5";
    private MyAdapter myAdapter;
    private List<Bean.ResultBean> list = new ArrayList<>();
    private MyView myView;

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView(View inflate) {
        recyclerView = inflate.findViewById(R.id.rv);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        myAdapter = new MyAdapter(getActivity(), list);
        recyclerView.setAdapter(myAdapter);
        myView = inflate.findViewById(R.id.mv);
        myAdapter.setSetOnClick(new MyAdapter.SetOnClick() {
            @Override
            public void onClickLinener(int position) {
                Toast.makeText(getActivity(), "董青勇是SB", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.home_fragment;
    }

    @Override
    protected void getDing() {
        myView.setOnSetClick(new MyView.onSetClick() {
            @Override
            public void onClick(String url) {
                mPresenter.startRequest(str1 + URLEncoder.encode(url) + str2);
            }
        });

    }

    @Override
    public void onSuccess(String json) {
        Gson gson = new Gson();
        Bean bean = gson.fromJson(json, Bean.class);
        list.addAll(bean.getResult());
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String error) {

    }
}
