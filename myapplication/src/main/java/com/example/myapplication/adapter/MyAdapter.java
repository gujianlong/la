package com.example.myapplication.adapter;
/*
 *@auther:谷建龙
 *@Date: 2019/11/23
 *@Time:17:20
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListPopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.bean.Bean;
import com.example.myapplication.fragmean.HomeFragment;
import com.example.myapplication.utils.GlideUtils;

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
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OneHolder) {
            ((OneHolder) holder).name.setText(list.get(position).getCommodityName());
            GlideUtils.loadImage(list.get(position).getMasterPic(), ((OneHolder) holder).image);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClick.onClickLinener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface SetOnClick {
        void onClickLinener(int position);
    }

    public SetOnClick setOnClick;

    public void setSetOnClick(SetOnClick setOnClick) {
        this.setOnClick = setOnClick;
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
