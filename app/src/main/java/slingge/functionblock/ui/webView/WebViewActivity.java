package slingge.functionblock.ui.webView;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;

import slingge.functionblock.R;
import slingge.functionblock.base.SlinggeActivity;


/**
 * webview
 * Created by Slingge on 2017/8/29 0029.
 */
@SuppressLint("SetJavaScriptEnabled")
public class WebViewActivity extends SlinggeActivity {

    private WebView contentWebView = null;
    private String[] imageUrls = StringUtils.returnImageUrlsFromHtml();

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        contentWebView = (WebView) findViewById(R.id.webView);
        contentWebView.getSettings().setJavaScriptEnabled(true);
        contentWebView.getSettings().setAppCacheEnabled(true);
        contentWebView.getSettings().setDatabaseEnabled(true);
        contentWebView.getSettings().setDomStorageEnabled(true);
        contentWebView.loadUrl("http://image.baidu.com/search/index?tn=baiduimage&ct=201326592&lm=-1&cl=2&word=%E7%AF%B1%E8%90%BD%E7%B4%A0%E7%B4%A0");
        contentWebView.addJavascriptInterface(new MJavascriptInterface(this,imageUrls), "imagelistener");
        contentWebView.setWebViewClient(new MyWebViewClient());
    }



}
