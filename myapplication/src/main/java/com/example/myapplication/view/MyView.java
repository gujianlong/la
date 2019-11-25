package com.example.myapplication.view;
/*
 *@auther:谷建龙
 *@Date: 2019/11/23
 *@Time:19:02
 *@Description:
 * */


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.myapplication.R;

public class MyView extends LinearLayout {

    private Button button;
    private EditText edit;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View inflate = View.inflate(context, R.layout.ltitl, this);
        initView();
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onSetClick.onClick(edit.getText().toString());
            }
        });
    }

    public interface onSetClick {
        void onClick(String url);
    }

    public onSetClick onSetClick;

    public void setOnSetClick(MyView.onSetClick onSetClick) {
        this.onSetClick = onSetClick;
    }

    private void initView() {
        button = findViewById(R.id.button);
        edit = findViewById(R.id.edit);
    }
}
