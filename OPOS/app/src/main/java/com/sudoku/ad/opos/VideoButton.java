package com.sudoku.ad.opos;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by AD on 2015/8/21.
 */
public class VideoButton extends LinearLayout {
    private WebView mWebImageView;
    private TextView mTextView;
    private Context mContext;
    public VideoButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_mbutton, this, true);
        mContext = context;
        mWebImageView = (WebView)findViewById(R.id.my_webview_image);
        mTextView = (TextView)findViewById(R.id.my_textview);
    }
    public void loadUrl(String string){
        mWebImageView.loadUrl(string);
    }
    public void setText(String string){
        mTextView.setText(string);
    }
    public void setTextSize(float size){
        mTextView.setTextSize(size);
    }
}
