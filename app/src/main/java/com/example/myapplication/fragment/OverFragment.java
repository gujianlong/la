package com.example.myapplication.fragment;
/*
 *@auther:谷建龙
 *@Date: 2019/11/22
 *@Time:10:51
 *@Description:
 * */


import android.annotation.SuppressLint;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.presenter.Presenter;

public class OverFragment extends BaseFragment {

    private Button button_huan;
    private Button button_tan;
    private WebView webView;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void initView(View inflate) {
        button_huan = inflate.findViewById(R.id.button_huan);
        button_tan = inflate.findViewById(R.id.button_tan);
        webView = inflate.findViewById(R.id.wv);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        webView.addJavascriptInterface(new JSDome(),"android");
        webView.loadUrl("https://abnerming8.github.io/abnerming.html");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }
        });
        button_huan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("javascript:changeColor('#d43c3c')");
            }
        });
        button_tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("javascript:toast()");
            }
        });

    }
    class JSDome{
        @JavascriptInterface
        public void show(){
            Toast.makeText(getActivity(), "谷建龙", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected int layoutId() {
        return R.layout.over_fragment;
    }

    @Override
    protected void getConDing() {

    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    public void onSuccess(String jaon) {

    }

    @Override
    public void onError(String error) {

    }
}
