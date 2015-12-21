package com.sudoku.ad.opos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


/**
 * Created by AD on 2015/8/13.
 */
public class ToolActivity extends Activity {
    private MyImageButton2 mReadButton;
    private MyImageButton2 mReturnButton;

    private MyImageButton3 mToolButton;
    private MyImageButton2 mToolButton1;
    private MyImageButton2 mToolButton2;
    private MyImageButton2 mToolButton3;
    private MyImageButton2 mToolButton4;
    private MyImageButton2 mToolButton5;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        this.setContentView(R.layout.activity_tool);
        mReadButton = (MyImageButton2)findViewById(R.id.read_button);
        mReturnButton = (MyImageButton2)findViewById(R.id.return_button);
        mToolButton = (MyImageButton3)findViewById(R.id.tool);
        mToolButton1 = (MyImageButton2)findViewById(R.id.tool_1);
        mToolButton2 = (MyImageButton2)findViewById(R.id.tool_2);
        mToolButton3 = (MyImageButton2)findViewById(R.id.tool_3);
        mToolButton4 = (MyImageButton2)findViewById(R.id.tool_4);
        mToolButton5 = (MyImageButton2)findViewById(R.id.tool_5);

        mReadButton.setBackground(R.drawable.test9);
        mReturnButton.setBackground(R.drawable.test9);

        mToolButton.setBackground(R.drawable.tool6);
        mToolButton1.setBackground(R.drawable.tool1);
        mToolButton2.setBackground(R.drawable.tool2);
        mToolButton3.setBackground(R.drawable.tool3);
        mToolButton4.setBackground(R.drawable.tool4);
        mToolButton5.setBackground(R.drawable.tool7);


        mReturnButton.setmText("\t返回");
        mReturnButton.setmTextSize(20);
        mReadButton.setmText("\t阅读");
        mReadButton.setmTextSize(20);
        mToolButton.setmText("  工具");
        mToolButton1.setmText("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t扫码");
        mToolButton2.setmText("\t\t\t\t\t\t\t\t\t\t\t\t\t 放大镜");
        mToolButton3.setmText("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t食谱");
        mToolButton4.setmText("\t\t\t\t\t\t\t\t\t\t\t\t\t 计算器");

        mToolButton.setmTextSize(60);
        mToolButton1.setmTextSize(30);
        mToolButton2.setmTextSize(30);
        mToolButton3.setmTextSize(30);
        mToolButton4.setmTextSize(30);


        mToolButton1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mToolButton1.setBackground(R.drawable.tool1_2);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    mToolButton1.setBackground(R.drawable.tool1);
                }
                return false;

            }
        });
        mToolButton2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mToolButton2.setBackground(R.drawable.tool2_2);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    mToolButton2.setBackground(R.drawable.tool2);
                }
                return false;

            }
        });

        mToolButton3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    mToolButton3.setBackground(R.drawable.tool3_2);
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    mToolButton3.setBackground(R.drawable.tool3);
                }
                return false;

            }
        });

        mToolButton4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    mToolButton4.setBackground(R.drawable.tool4_2);
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    mToolButton4.setBackground(R.drawable.tool4);
                }
                return false;

            }
        });

        mReadButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    mReadButton.setBackground(R.drawable.test9_2);
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    mReadButton.setBackground(R.drawable.test9);
                }
                return false;

            }
        });

        mReturnButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    mReturnButton.setBackground(R.drawable.test9_2);
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    mReturnButton.setBackground(R.drawable.test9);
                }
                return false;

            }
        });






        mToolButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ToolActivity.this, CaptureActivity.class);
                startActivity(i);
            }
        });

        mToolButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ToolActivity.this, MagnifiterActivity.class);
                startActivity(i);
            }
        });

        mToolButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ToolActivity.this, FoodActivity.class);
                startActivity(i);
            }
        });


        mReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ToolActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        mToolButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(ToolActivity.this,CalculatorActivity1.class);
                startActivity(i);
            }
        });

    }
}
