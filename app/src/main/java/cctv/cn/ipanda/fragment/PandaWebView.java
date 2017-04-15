package cctv.cn.ipanda.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.common.App;
import cctv.cn.ipanda.utils.ShareControllerUtil;

/**
 * Created by hp1 on 2017-04-13.
 */

public class PandaWebView extends BaseFragment implements View.OnClickListener {

    private WebView webView;
    private ImageView share;
    private ImageView collect;
    private String url;
    private String title;
    private String imageurl;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_pandaeye_detail;
    }

    @Override
    protected void loadData() {
        webView.loadUrl(url);
        //webView.loadDataWithBaseURL(null,"http://www.baidu.com", "text/html",  "utf-8", null);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setSupportZoom(false);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setLoadsImagesAutomatically(true);
    }

    @Override
    protected void initData() {
        url = bundle.getString("url");
        Log.d("aaaaaaaaaaaa", url);

        title = bundle.getString("title");
        Log.d("aaaaaaa", title);

        imageurl = bundle.getString("imageurl");
        Log.d("aaaaaaaaaa", imageurl);
    }

    @Override
    protected void initView(View view) {
        webView = (WebView) view.findViewById(R.id.pe_listview_item_detail_webview);

        share = (ImageView) view.findViewById(R.id.share);
        collect = (ImageView) view.findViewById(R.id.collect);
    }

    @Override
    protected void initListener() {
        share.setOnClickListener(this);
        collect.setOnClickListener(this);
    }

    @Override
    protected void show() {

    }

    @Override
    protected void hide() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.share:
                ShareControllerUtil shareControllerUtil = new ShareControllerUtil();
                shareControllerUtil.shareHttp(url, title, imageurl);
                break;
            case R.id.collect:
                break;
        }
    }
}
