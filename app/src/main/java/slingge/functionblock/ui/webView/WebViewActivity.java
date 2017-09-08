package slingge.functionblock.ui.webView;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import slingge.functionblock.R;
import slingge.functionblock.ui.SlinggeActivity;


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
        contentWebView.loadUrl("http://a.mp.uc.cn/article.html?uc_param_str=frdnsnpfvecpntnwprdssskt&client=ucweb&wm_aid=c51bcf6c1553481885da371a16e33dbe&wm_id=482efebe15ed4922a1f24dc42ab654e6&pagetype=share&btifl=100");
        contentWebView.addJavascriptInterface(new MJavascriptInterface(this,imageUrls), "imagelistener");
        contentWebView.setWebViewClient(new MyWebViewClient());
    }



}
