package com.example.myapplication.utils;
/*
 *@auther:谷建龙
 *@Date: 2019/11/22
 *@Time:10:06
 *@Description:
 * */


import android.speech.tts.Voice;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.app.MyApp;

public class NetUtils {

    private final RequestQueue requestQueue;

    private NetUtils() {
        requestQueue = Volley.newRequestQueue(MyApp.mContext);
    }

    private static class net {
        private static NetUtils netUtils = new NetUtils();
    }

    public static NetUtils getInstance() {
        return net.netUtils;
    }

    public interface MySuccess {
        void onDoGet(String json);

        void onError(String error);
    }

    public void onGet(String url, final MySuccess mySuccess) {
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mySuccess.onDoGet(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mySuccess.onError(error.getMessage());
            }
        });
        requestQueue.add(request);
    }
}
