package com.example.myapplication.view;
/*
 *@auther:谷建龙
 *@Date: 2019/11/22
 *@Time:16:32
 *@Description:
 * */


import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyGroup extends ViewGroup {
    private Context context;

    public MyGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int space = 10;
        int left = 0;
        int right = 0;
        int top = 0;
        int button = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            childAt.measure(0, 0);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            left = right + space;
            right = left + measuredWidth;
            int width = getWidth();
            if (right > width) {
                left = space;
                top = button + space;
            }
            right = left + measuredWidth;
            button = measuredHeight + top;
            childAt.layout(left, top, right, button);
        }
    }

    public void addCount(String content) {
        TextView textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.BLUE);
        textView.setTextSize(20);
        textView.setText(content);
        addView(textView);
    }
}
