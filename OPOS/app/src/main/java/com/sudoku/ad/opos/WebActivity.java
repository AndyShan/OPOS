package com.sudoku.ad.opos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Created by AD on 2015/8/12.
 */
public class WebActivity extends Activity{
    private WebView mWebView;
    private String webLoad;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        this.setContentView(R.layout.activity_surf_view);
        mWebView = (WebView)findViewById(R.id.my_webview);
        Intent i = getIntent();
        String src = i.getStringExtra("src");
        mWebView.loadUrl(src);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //����ֵ��true��ʱ�����ȥWebView�򿪣�Ϊfalse����ϵͳ�����������������
                view.loadUrl(url);
                return true;
            }
        });

        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);

        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // TODO Auto-generated method stub
                if (newProgress == 100) {
                    // ��ҳ�������
                    webLoad = "dfdfdf";
                } else {
                    // ������
                    webLoad = "jjjj";

                }

            }
        });
//        Toast.makeText(this,webLoad,Toast.LENGTH_SHORT).show();
    };
}
