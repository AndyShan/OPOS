package com.sudoku.ad.opos;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by AD on 2015/9/15.
 */
public class MyImageButton4 extends FrameLayout{
    private TextView mTextView;
    private LinearLayout linearLayout;
    private Context mContext;
    private ImageView imageView;
    public MyImageButton4(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.layout_image_button4, this, true);
        mContext = context;
        mTextView = (TextView)findViewById(R.id.setting_text);
        linearLayout = (LinearLayout)findViewById(R.id.setting_background);
        imageView = (ImageView)findViewById(R.id.setting_image);

    }
    public void setColor(int id){
        mTextView.setTextColor(id);
    }
    public void setmText(String s){
        mTextView.setText(s);
    }
    public void setmTextSize(int i){
        mTextView.setTextSize(i);
    }
    public void setBackground(int id){
        linearLayout.setBackgroundResource(id);
    }
    public void setIcon(int id){
        imageView.setImageResource(id);
    }
}
