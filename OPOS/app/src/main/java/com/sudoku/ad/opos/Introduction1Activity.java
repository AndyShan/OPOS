package com.sudoku.ad.opos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by AD on 2015/9/5.
 */
public class Introduction1Activity extends Activity {
    private ImageView imageView;
    private FrameLayout frameLayout;
    MyStaticValue myStaticValue;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        this.setContentView(R.layout.activity_introduction1);
        myStaticValue = new MyStaticValue();
        if (myStaticValue.PHONE_NUMBER!=null){
            Intent i =new Intent(Introduction1Activity.this,MainActivity.class);
            startActivity(i);
        }
        frameLayout = (FrameLayout)findViewById(R.id.introduction_layout);
        frameLayout.setBackgroundResource(R.drawable.introduction1);
        imageView = (ImageView)findViewById(R.id.my_introduction1_button);
        imageView.setImageResource(R.drawable.white_button);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Introduction1Activity.this,Introduction2Activity.class);
                startActivity(i);
            }
        });
    }
}
