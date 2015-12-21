package com.sudoku.ad.opos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.sudoku.ad.opos.ebook.TxtReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by AD on 2015/8/6.
 */
public class RelaxActivity extends Activity{
    private MyImageButton2 mReadButton;
    private MyImageButton3 mRelaxButton0;
    private MyImageButton2 mRelaxButton1;
    private MyImageButton2 mRelaxButton2;
    private MyImageButton2 mRelaxButton3;
    private MyImageButton2 mRelaxButton4;
    private MyImageButton2 mRelaxButton5;
    private MyImageButton2 mRelaxButton6;
    private MyImageButton2 mReturnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relax);

        mReadButton = (MyImageButton2)findViewById(R.id.read_button);
        mReturnButton = (MyImageButton2)findViewById(R.id.return_button);
        mRelaxButton0 = (MyImageButton3)findViewById(R.id.relax);
        mRelaxButton1 = (MyImageButton2)findViewById(R.id.relax_1);
        mRelaxButton2 = (MyImageButton2)findViewById(R.id.relax_2);
        mRelaxButton3 = (MyImageButton2)findViewById(R.id.relax_3);
        mRelaxButton4 = (MyImageButton2)findViewById(R.id.relax_4);
        mRelaxButton5 = (MyImageButton2)findViewById(R.id.relax_5);
        mRelaxButton6 = (MyImageButton2)findViewById(R.id.relax_6);

        mReadButton.setBackground(R.drawable.test9);
        mReturnButton.setBackground(R.drawable.test9);

        mRelaxButton0.setBackground(R.drawable.relax);
        mRelaxButton1.setBackground(R.drawable.relax_1);
        mRelaxButton2.setBackground(R.drawable.relax_2);
        mRelaxButton3.setBackground(R.drawable.relax_3);
        mRelaxButton4.setBackground(R.drawable.relax_4);
        mRelaxButton5.setBackground(R.drawable.relax_5);
        mRelaxButton6.setBackground(R.drawable.relax_6);


        mReturnButton.setmText("\t返回");
        mReturnButton.setmTextSize(20);
        mReadButton.setmText("\t阅读");
        mReadButton.setmTextSize(20);
        mRelaxButton0.setmText("  放松");
        mRelaxButton1.setmText("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t上网");
        mRelaxButton2.setmText("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t视频");
        mRelaxButton3.setmText("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t阅读");
        mRelaxButton4.setmText("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t音乐");
        mRelaxButton5.setmText("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t拍照");
        mRelaxButton6.setmText("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t相册");
        mRelaxButton0.setmTextSize(60);
        mRelaxButton1.setmTextSize(30);
        mRelaxButton2.setmTextSize(30);
        mRelaxButton3.setmTextSize(30);
        mRelaxButton4.setmTextSize(30);
        mRelaxButton5.setmTextSize(30);
        mRelaxButton6.setmTextSize(30);


        mRelaxButton1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mRelaxButton1.setBackground(R.drawable.relax_1_2);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    mRelaxButton1.setBackground(R.drawable.relax_1);
                }
                return false;

            }
        });

        mRelaxButton2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    mRelaxButton2.setBackground(R.drawable.relax_2_2);
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    mRelaxButton2.setBackground(R.drawable.relax_2);
                }
                return false;

            }
        });

        mRelaxButton3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    mRelaxButton3.setBackground(R.drawable.relax_3_2);
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    mRelaxButton3.setBackground(R.drawable.relax_3);
                }
                return false;

            }
        });

        mRelaxButton4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    mRelaxButton4.setBackground(R.drawable.relax_4_2);
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    mRelaxButton4.setBackground(R.drawable.relax_4);
                }
                return false;

            }
        });

        mRelaxButton5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    mRelaxButton5.setBackground(R.drawable.relax_5_2);
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    mRelaxButton5.setBackground(R.drawable.relax_5);
                }
                return false;

            }
        });
        mRelaxButton6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    mRelaxButton6.setBackground(R.drawable.relax_6_2);
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    mRelaxButton6.setBackground(R.drawable.relax_6);
                }
                return false;

            }
        });







        mReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RelaxActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        mRelaxButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RelaxActivity.this,SurfActivity.class);
                startActivity(i);
            }
        });
        mRelaxButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RelaxActivity.this,TxtReader.class);
                startActivity(i);
            }
        });
        mRelaxButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(RelaxActivity.this,MusicActivity.class);
                startActivity(i);
            }
        });
        mRelaxButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RelaxActivity.this,VideoActivity.class);
                startActivity(i);
            }
        });
        mRelaxButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.media.action.IMAGE_CAPTURE");
                intent.addCategory("android.intent.category.DEFAULT");
                File file = new File(Environment.getRootDirectory()+"/000.jpg");
                Uri uri = Uri.fromFile(file);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                startActivity(intent);
            }
        });
        mRelaxButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT, null);
                intent.setType("image/*");
                intent.putExtra("crop", "true");
                intent.putExtra("aspectX", 1);
                intent.putExtra("aspectY", 1);
                intent.putExtra("outputX", 100);
                intent.putExtra("outputY", 100);
                intent.putExtra("scale", true);
                intent.putExtra("return-data", true);
                //intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                intent.putExtra("outputFormat", Bitmap.CompressFormat.PNG.toString());
                intent.putExtra("noFaceDetection", true);
                startActivityForResult(intent, 0);
            }
        });
    }
}
