package com.example.myapplication.adapter;
/*
 *@auther:谷建龙
 *@Date: 2019/11/22
 *@Time:11:36
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.example.myapplication.R;
import com.example.myapplication.bean.Bean;
import com.example.myapplication.utils.ClideUtils;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Bean.ResultBean> list;

    public MyAdapter(Context context, List<Bean.ResultBean> list) {

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View view = null;
        view = View.inflate(context, R.layout.a, null);
        holder = new OneHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof OneHolder){
            ((OneHolder) holder).name.setText(list.get(position).getCommodityName());
            ClideUtils.loadImage(list.get(position).getMasterPic(),((OneHolder) holder).image);
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface onClickItem{
        void onItemClick(String po);
    }
    public onClickItem onClickItem;

    public void setOnClickItem(MyAdapter.onClickItem onClickItem) {
        this.onClickItem = onClickItem;
    }


    class OneHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final ImageView image;
        public OneHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);
        }
    }
}
