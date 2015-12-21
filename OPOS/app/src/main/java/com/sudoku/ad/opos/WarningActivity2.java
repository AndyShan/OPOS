package com.sudoku.ad.opos;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;

/**
 * Created by AD on 2015/9/17.
 */
public class WarningActivity2 extends Activity{
    private Button button;
    GravityActivity gravityActivity = new GravityActivity();
    MyStaticValue myStaticValue = new MyStaticValue();

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        this.setContentView(R.layout.activity_warning2);
        final MediaPlayer mediaPlayer01;
        mediaPlayer01 = MediaPlayer.create(this, R.raw.beat_box_android);
        mediaPlayer01.setLooping(true);
        mediaPlayer01.start();
        String text = "我摔倒了，请帮助我";
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(myStaticValue.PHONE_NUMBER, null, text, null, null);
    }
}
