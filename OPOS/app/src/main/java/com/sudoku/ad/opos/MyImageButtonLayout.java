package com.sudoku.ad.opos;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by AD on 2015/9/2.
 */
public class MyImageButtonLayout extends LinearLayout {
    private ImageView imageView;
    private TextView textView;
    private Context mContext;
    public MyImageButtonLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_image_button, this, true);
        mContext = context;
        imageView = (ImageView)findViewById(R.id.imagebutton_image);
        textView = (TextView)findViewById(R.id.imagebutton_text);
    }
    public void setImage(int id){
        imageView.setImageResource(id);
    }
    public void setText(String string){
        textView.setText(string);
    }
    public void setSize(int size){
        textView.setTextSize(size);
    }
}
