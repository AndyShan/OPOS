package com.sudoku.ad.opos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;

/**
 * Created by AD on 2015/9/5.
 */
public class Introduction3Activity extends Activity {
    private ImageView imageView;
    private FrameLayout frameLayout;
    private EditText editText;
    private Button button;
    private PopupWindow mPopupWindow;
    private View mView;
    private String phonenumber;
    MyStaticValue myStaticValue;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        this.setContentView(R.layout.activity_introduction1);
        myStaticValue = new MyStaticValue();
        frameLayout = (FrameLayout) findViewById(R.id.introduction_layout);
        frameLayout.setBackgroundResource(R.drawable.introduction3);
        imageView = (ImageView) findViewById(R.id.my_introduction1_button);
        imageView.setImageResource(R.drawable.white_button2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText = new EditText(Introduction3Activity.this);
                new AlertDialog.Builder(Introduction3Activity.this).setTitle("请输入").setIcon(android.R.drawable.ic_dialog_info)
                        .setView(editText).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       // phonenumber = editText.getText().toString();
                        myStaticValue.PHONE_NUMBER = editText.getText().toString();
                        Intent i = new Intent(Introduction3Activity.this, MainActivity.class);
                        //i.putExtra("number", phonenumber);
                        startActivity(i);
                    }
                }).setNegativeButton("取消", null).show();

            }
        });

    }
}
