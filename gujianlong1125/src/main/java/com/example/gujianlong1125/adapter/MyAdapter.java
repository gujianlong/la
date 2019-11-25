package com.example.gujianlong1125.adapter;
/*
 *@auther:谷建龙
 *@Date: 2019/11/25
 *@Time:9:13
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gujianlong1125.MainActivity;
import com.example.gujianlong1125.R;
import com.example.gujianlong1125.bean.Bean;
import com.example.gujianlong1125.utils.GlideUtils;

import java.util.HashMap;
import java.util.IdentityHashMap;
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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof OneHolder) {
            ((OneHolder) holder).name.setText(list.get(position).getName());
            GlideUtils.loadImage(list.get(position).getImageUrl(), ((OneHolder) holder).image);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class OneHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView name;

        public OneHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
        }
    }
}
