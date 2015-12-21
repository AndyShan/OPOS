package com.sudoku.ad.opos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

/**
 * Created by AD on 2015/9/16.
 */
public class WarningActivity extends Activity{

    private Button mStopButton;
    private Button mCallButton;
    private EditText editText;
    private MyStaticValue myStaticValue;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        this.setContentView(R.layout.activity_warning);
        myStaticValue = new MyStaticValue();
        mStopButton = (Button)findViewById(R.id.stop_button);
        mCallButton = (Button)findViewById(R.id.call_button);

        final MediaPlayer mediaPlayer01;
        mediaPlayer01 = MediaPlayer.create(this, R.raw.beat_box_android);
        mediaPlayer01.setLooping(true);
        mediaPlayer01.start();

//        mStopButton.setVisibility(View.INVISIBLE);
//        mCallButton.setVisibility(View.INVISIBLE);
        mCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                            Intent intent = new Intent();
                            intent.setAction(intent.ACTION_CALL);
                            intent.setData(Uri.parse("tel:" + myStaticValue.PHONE_NUMBER));
                            startActivity(intent);
            }
        });
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText = new EditText(WarningActivity.this);
                new AlertDialog.Builder(WarningActivity.this).setTitle("请输入").setIcon(android.R.drawable.ic_dialog_info)
                        .setView(editText).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // phonenumber = editText.getText().toString();
                        if (editText.getText().toString().equals("1234")) {
                            mediaPlayer01.stop();
                            Intent i = new Intent(WarningActivity.this, MainActivity.class);
                            //i.putExtra("number", phonenumber);
                            startActivity(i);
                        } else {
                            String text = "北京联合大学北四环校区2号楼";
                            SmsManager sms = SmsManager.getDefault();
                            sms.sendTextMessage(myStaticValue.PHONE_NUMBER, null, text, null, null);
                        }

                    }
                }).setNegativeButton("取消", null).show();
            }
        });



    }
}
