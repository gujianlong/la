package com.example.gujianlong1125;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.gujianlong1125.adapter.MyAdapter;
import com.example.gujianlong1125.base.BaseActivity;
import com.example.gujianlong1125.base.BasePresenter;
import com.example.gujianlong1125.bean.Bean;
import com.example.gujianlong1125.presenter.Presenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private String str = "http://172.17.8.100/movieApi/movie/v1/findReleaseMovieList?page=1&count=20";
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private List<Bean.ResultBean> list = new ArrayList<>();

    @Override
    protected void onPresenter() {
        mPresenter.startRequest(str);
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this, list);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onGet(String json) {
        Gson gson = new Gson();
        Bean bean = gson.fromJson(json, Bean.class);
        list.addAll(bean.getResult());
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String error) {

    }
}
