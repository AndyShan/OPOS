package com.sudoku.ad.opos;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by AD on 2015/9/15.
 */
public class MyImageButton2 extends FrameLayout{
    private TextView mTextView;
    private FrameLayout frameLayout;
    private Context mContext;
    private ImageView imageView;
    public MyImageButton2(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.layout_image_button2, this, true);
        mContext = context;
        mTextView = (TextView)findViewById(R.id.my_text);
        frameLayout = (FrameLayout)findViewById(R.id.my_background);
        imageView = (ImageView)findViewById(R.id.icon_pic);

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
        frameLayout.setBackgroundResource(id);
    }
    public void setIcon(int id){
        imageView.setImageResource(id);
    }
}
