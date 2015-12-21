package com.sudoku.ad.opos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.show.api.ShowApiRequest;

import org.apache.http.Header;


/**
 * Created by AD on 2015/8/15.
 */
public class ProductInformationActivity extends Activity {
    private Button mGoodName;
    private Button mCompanyName;
    private Button mPrice;
    private Button mSpecial;
    private Button mSearchTime;
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        this.setContentView(R.layout.activity_barcode);
        mGoodName = (Button)findViewById(R.id.good_name);
        mCompanyName = (Button)findViewById(R.id.company_name);
        mPrice = (Button)findViewById(R.id.price);
        mSearchTime = (Button)findViewById(R.id.search_time);
        mSpecial = (Button)findViewById(R.id.special);
        mWebView = (WebView)findViewById(R.id.image_web);
        Intent intent = getIntent();
        String barcod = intent.getStringExtra("barcode");

        final AsyncHttpResponseHandler resHandler=new AsyncHttpResponseHandler(){
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable e) {
                //做一些异常处理
                e.printStackTrace();
            }
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {

                    String result = new String(responseBody,"utf-8");

                    mGoodName.setText(result.substring(result.indexOf("goodsName\":\"")+12,result.indexOf("\",\"img")));
                    mCompanyName.setText(result.substring(result.indexOf("manuName\":\"")+11,result.indexOf("\",\"price")));
                    mPrice.setText(result.substring(result.indexOf("price\":\"")+8,result.indexOf("\",\"ret_code")));
                    mSpecial.setText(result.substring(result.indexOf("spec\":\"")+7,result.indexOf("\",\"trade")));

                    mSearchTime.setText(DateFormat.getMediumDateFormat(getApplicationContext()).format(new Date())
                            + DateFormat.getTimeFormat(getApplicationContext()).format(new Date()) );
                    String re = null;
                    re = result.substring(result.indexOf("img\":\"")+6,result.indexOf("\",\"manuName"));
                    if(re != null){
                        mWebView.loadUrl(re);
                    }else{
                        mWebView.loadUrl("www.baidu.com");
                    }


                    //在此对返回内容做处理
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }};
        new ShowApiRequest( "http://route.showapi.com/66-22?", "5879", "fa8047ba0a1742d785705bed6f5852f0")
                .setResponseHandler(resHandler)
                .addTextPara("code", barcod)
                .post();

    }
}
