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
public class MyImageButton5 extends FrameLayout{
    private TextView mTimeMonthText;
    private TextView mTimeNowText;
    private TextView mWeatherText;
    private Context mContext;
    public MyImageButton5(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.layout_image_button5, this, true);
        mContext = context;
        mTimeMonthText = (TextView)findViewById(R.id.time_text_mouth);
        mTimeNowText  = (TextView)findViewById(R.id.time_text_now);
        mWeatherText = (TextView)findViewById(R.id.weather_text);

    }
    public void setTimeMonth(String text){
        mTimeMonthText.setText(text);
    }
    public void setTimeNow(String text){
        mTimeNowText.setText(text);
    }
    public void setWeather(String text){
        mWeatherText.setText(text);
    }

}
