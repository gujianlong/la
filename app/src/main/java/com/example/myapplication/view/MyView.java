package com.example.myapplication.view;
/*
 *@auther:谷建龙
 *@Date: 2019/11/22
 *@Time:14:45
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
    private EditText editText;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View inflate = View.inflate(context, R.layout.tilet, this);
        initView();
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onSetClick.onClick(editText.getText().toString());
            }
        });
    }

    public interface OnSetClick {
        void onClick(String url);
    }

    private OnSetClick onSetClick;

    public void setOnSetClick(OnSetClick onSetClick) {
        this.onSetClick = onSetClick;
    }

    private void initView() {
        button = findViewById(R.id.button);
        editText = findViewById(R.id.edit);
    }
}
