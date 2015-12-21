package com.sudoku.ad.opos.ebook;

/**
 * Created by AD on 2015/8/13.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.sudoku.ad.opos.MyImageButton2;
import com.sudoku.ad.opos.R;

/*
 * 文本浏览视图
 × 菜单 可切换文字编码
 */

public class ViewFile extends Activity {

    private String fileNameString;
    private static final String gb2312 = "GB2312";
    private static final String utf8 = "UTF-8";
    private static final String defaultCode = utf8;
    private MyImageButton2 mReadButton;
    private MyImageButton2 mReturnButton;

    //这个Activity 利用 intent 携带 bundle的方法
    //接受到了listAllFileActivity传过来的用户要求打开的文件名称和地址
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filebrowser);

        mReadButton = (MyImageButton2)findViewById(R.id.read_button);
        mReturnButton = (MyImageButton2)findViewById(R.id.return_button);
        mReturnButton.setmText("\t返回");
        mReturnButton.setmTextSize(20);
        mReadButton.setmText("\t阅读");
        mReadButton.setmTextSize(20);
        try {
            Bundle bunde = this.getIntent().getExtras();
            fileNameString = bunde.getString("fileName");
            reCodeAndShow(defaultCode);
        } catch (Exception e) {}

        mReadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mediaPlayer01;
                mediaPlayer01 = MediaPlayer.create(ViewFile.this,R.raw.d);
                mediaPlayer01.start();
            }
        });
    }

    //创建并填充MENU菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    //MENU菜单动作  switch case语句
    //调用 reCodeAndShow(...)重新编码并显示
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.gb2312:
                reCodeAndShow(gb2312);
                break;
            case R.id.utf8:
                reCodeAndShow(utf8);
                break;
            case R.id.about:
                doAbout();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    //重新编码并且显示
    private void reCodeAndShow(String code)
    {
        TextView tv = (TextView) findViewById(R.id.view_contents);
        String fileString = getStringFromFile(code);
        tv.setText(fileString);
    }

    //从文件得到字符串
    public String getStringFromFile(String code)
    {
        try {
            StringBuffer sBuffer = new StringBuffer();
            FileInputStream fInputStream = new FileInputStream(fileNameString);

            //java.io.InputStreamReader 直接将编码作为参数引入内部函数处理
            InputStreamReader inputStreamReader = new InputStreamReader(fInputStream, code);
            BufferedReader in = new BufferedReader(inputStreamReader);
            if(!new File(fileNameString).exists())
            {
                return null;
            }
            while (in.ready()) {
                sBuffer.append(in.readLine() + "\n");
            }
            in.close();
            return sBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //帮助框的标题，内容的设置
    private void doAbout() {

        Dialog dialog = new AlertDialog.Builder(ViewFile.this)
                .setTitle(R.string.aboutTitle)
                .setMessage(R.string.aboutInfo)
                .setPositiveButton(R.string.aboutOK,new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {}
                } )
                .create();

        dialog.show();
    }

}

