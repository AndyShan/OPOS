package com.sudoku.ad.opos;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.net.URI;
import java.net.URL;

/**
 * Created by AD on 2015/8/31.
 */
public class SettingView extends LinearLayout {
    private ImageView mImageView;
    private TextView mTextView;
    private Context mContext;
    public SettingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_my_view, this, true);
        mContext = context;
        mImageView = (ImageView)findViewById(R.id.my_view_image);
        mTextView = (TextView)findViewById(R.id.my_view_text);
    }
    public void setImage(int id){
        mImageView.setImageResource(id);
    }
    public void setText(String text){
        mTextView.setText(text);
    }
    public void setSize(float size){
        mTextView.setTextSize(size);
    }

}
