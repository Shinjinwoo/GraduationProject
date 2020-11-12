package com.example.abptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AmaMarketActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ama_market);


        webView = (WebView)findViewById(R.id.AmaMarket_webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.jjangbaseball.com/m2/index.php?n_media=8753&n_query=%EC%95%BC%EA%B5%AC%EC%9A%A9%ED%92%88&n_rank=1&n_ad_group=grp-m001-01-000000394189298&n_ad=nad-a001-01-000000061699398&n_keyword_id=nkw-m001-01-000000394189298&n_keyword=%EC%95%BC%EA%B5%AC%EC%9A%A9%ED%92%88&n_campaign_type=1&NaPm=ct%3Dk1evpc6g%7Cci%3D0zK0000vMDzr8MNIiLpj%7Ctr%3Dsa%7Chk%3D3314ac72f9c2a2dfe0b856feab5c699121aea0f0");
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack())
        {
            webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }



    }
}
