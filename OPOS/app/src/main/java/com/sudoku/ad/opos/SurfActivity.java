package com.sudoku.ad.opos;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by AD on 2015/8/12.
 */
public class SurfActivity extends Activity {
    private Button mInternalButton;
    private Button mInternationalButton;
    private Button mEducationButton;
    private Button mMilitaryButton;
    private Button mSocialButton;
    private Button mReviewButton;
    private Button mPeButton;
    private Button mScienceButton;
    private Button mWeiboButton;
    private Button mLotteryButton;
    private EditText mSearchEditText;
    private Button mRightButton;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        this.setContentView(R.layout.activity_surf);
        mInternalButton = (Button)findViewById(R.id.internal_news);
        mInternationalButton = (Button)findViewById(R.id.international_news);
        mEducationButton = (Button)findViewById(R.id.education_button);
        mMilitaryButton = (Button)findViewById(R.id.military_button);
        mSocialButton = (Button)findViewById(R.id.social_button);
        mReviewButton = (Button)findViewById(R.id.review_button);
        mPeButton = (Button)findViewById(R.id.pe_button);
        mScienceButton = (Button)findViewById(R.id.science_button);
        mWeiboButton = (Button)findViewById(R.id.weibo_button);
        mLotteryButton = (Button)findViewById(R.id.lottery_button);
        mSearchEditText = (EditText)findViewById(R.id.search_web);
        mRightButton = (Button)findViewById(R.id.search_web_right);


        mRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSrc("http://www.baidu.com/s?word="+mSearchEditText.getText().toString());
            }
        });
        mInternationalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSrc("http://news.sina.cn/gj?vt=4&pos=8&cid=56261");
            }
        });
        mInternalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSrc("http://news.sina.cn/gn?vt=4&pos=3");

            }
        });
        mEducationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSrc("http://edu.sina.cn/?vt=4&pos=108");
            }
        });
        mMilitaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSrc("http://mil.sina.cn/?vt=4&pos=108");
            }
        });
        mSocialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSrc("http://news.sina.cn/sh?vt=4&pos=3");
            }
        });
        mReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSrc("http://news.sina.cn/pl?vt=4&pos=11&cid=56264");
            }
        });
        mPeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSrc("http://sports.sina.cn/?vt=4&pos=108");
            }
        });
        mScienceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSrc("http://tech.sina.cn/?ttp=navtech&vt=4&pos=108");
            }
        });
        mWeiboButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSrc("http://m.weibo.cn/p/102803?wm=ig_1002&from=index&s2w=index&vt=4&pos=108");
            }
        });
        mLotteryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSrc("http://lotto.sina.cn/?vt=4&pos=108");
            }
        });
    }
    public void setSrc(String src){
        Intent i = new Intent(SurfActivity.this,WebActivity.class);
        i.putExtra("src",src);
        startActivity(i);
    }
}
