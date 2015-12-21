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
public class Introduction2Activity extends Activity{
    private ImageView imageView;
    private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        this.setContentView(R.layout.activity_introduction1);
        frameLayout = (FrameLayout)findViewById(R.id.introduction_layout);
        frameLayout.setBackgroundResource(R.drawable.int2);
        imageView = (ImageView)findViewById(R.id.my_introduction1_button);
        imageView.setImageResource(R.drawable.white_button);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Introduction2Activity.this, Introduction3Activity.class);
                startActivity(i);
            }
        });
    }
}
