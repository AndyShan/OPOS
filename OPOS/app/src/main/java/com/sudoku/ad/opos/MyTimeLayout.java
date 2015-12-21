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
public class MyTimeLayout extends LinearLayout {
    private ImageView temImageView;
    private TextView timeTextView;
    private TextView dataTextView;
    private TextView temTextView;
    private Context mContext;
    public MyTimeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.timelayout, this, true);
        mContext = context;
        temImageView = (ImageView)findViewById(R.id.tem_image);
        timeTextView = (TextView)findViewById(R.id.time_view);
        dataTextView = (TextView)findViewById(R.id.data_view);
        temTextView = (TextView)findViewById(R.id.tem_view);
    }
    public void setTemImage(int id){
        temImageView.setImageResource(id);
    }
    public void setTimeText(String string){
        timeTextView.setText(string);
    }
    public void setTimeTextSize(int size){
        timeTextView.setTextSize(size);
    }
    public void setTemText(String string){
        temTextView.setText(string);
    }
    public void setTemTextSize(int size){
        temTextView.setTextSize(size);
    }
    public void setDataText(String string){
        dataTextView.setText(string);
    }
    public void setDataTextSize(int size){
        dataTextView.setTextSize(size);
    }
}
