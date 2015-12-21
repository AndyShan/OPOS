package com.sudoku.ad.opos;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by AD on 2015/9/2.
 */
public class MyImageButton extends LinearLayout {

    private ImageView mImageView;
    private TextView mTextView;
    private FrameLayout frameLayout;
    private Context mContext;
    public MyImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_my_image_button, this, true);
        mContext = context;
        mImageView = (ImageView)findViewById(R.id.my_image);
        mTextView = (TextView)findViewById(R.id.my_text);
        frameLayout = (FrameLayout)findViewById(R.id.my_image_layout);
    }
    public void setImage(int id){
        mImageView.setImageResource(id);
    }
    public void setText(String string){
        mTextView.setText(string);
    }
    public void setSize(int size){
        mTextView.setTextSize(size);
    }
    public void setBackground(int id){
        frameLayout.setBackgroundResource(id);
    }


}
