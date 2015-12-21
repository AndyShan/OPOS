package com.sudoku.ad.opos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by AD on 2015/8/31.
 */
public class SettingActivity extends Activity {
    private MyImageButton2 mReadButton;
    private MyImageButton2 mReturnButton;

    private MyImageButton3 mSettingButton;
    private MyImageButton4 mSettingButton1;
    private MyImageButton4 mSettingButton2;
    private MyImageButton4 mSettingButton3;
    private MyImageButton2 mSettingButton4;

    private ImageView lighUpUp;
    private ImageView lightDownDown;
    private ImageView soundUpUp;
    private ImageView soundDownDown;
    private ImageView soundUpUpUp;
    private ImageView soundDownDownDown;


    private PopupWindow mPopupWindow;
    private View mView;



    private MediaPlayer mMediaPlayer;
    public AudioManager mAudioManager;
    private int maxVolume,currentVolume;
    private int volume = 0;



    int sysbrightness;
    boolean sysbrightnessMode;
    ScreenBrightnessTool mScreenBrightnessTool = new ScreenBrightnessTool(this,sysbrightness,sysbrightnessMode);
    @Override
    protected void onCreate(final Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        this.setContentView(R.layout.activity_setting);
        Intent i = getIntent();
        String s = i.getStringExtra("control");


        lighUpUp = (ImageView)findViewById(R.id.light_upup);
        lightDownDown = (ImageView)findViewById(R.id.light_downdown);
        soundUpUp = (ImageView)findViewById(R.id.sound_upup);
        soundDownDown = (ImageView)findViewById(R.id.sound_downdown);
        soundUpUpUp = (ImageView)findViewById(R.id.sound_upupup);
        soundDownDownDown = (ImageView)findViewById(R.id.sound_downdowndown);


        mReadButton = (MyImageButton2)findViewById(R.id.read_button);
        mReturnButton = (MyImageButton2)findViewById(R.id.return_button);
        mSettingButton = (MyImageButton3)findViewById(R.id.setting);
        mSettingButton1 = (MyImageButton4)findViewById(R.id.setting_1);
        mSettingButton2 = (MyImageButton4)findViewById(R.id.setting_2);
        mSettingButton3 = (MyImageButton4)findViewById(R.id.setting_3);
        mSettingButton4 = (MyImageButton2)findViewById(R.id.setting_4);

        mReadButton.setBackground(R.drawable.test9);
        mReturnButton.setBackground(R.drawable.test9);


        mSettingButton.setBackground(R.drawable.setting);

        mSettingButton4.setBackground(R.drawable.setting4);



        mReturnButton.setmText("\t返回");
        mReturnButton.setmTextSize(20);
        mReadButton.setmText("\t阅读");
        mReadButton.setmTextSize(20);
        mSettingButton1.setmText("亮度");
        mSettingButton2.setmText("通话音量");
        mSettingButton3.setmText("媒体音量");
        mSettingButton.setmText("设置");

        mSettingButton.setmTextSize(60);
        mSettingButton1.setmTextSize(30);
        mSettingButton2.setmTextSize(30);
        mSettingButton3.setmTextSize(30);

        mSettingButton1.setIcon(R.drawable.light);
        mSettingButton2.setIcon(R.drawable.sound);
        mSettingButton3.setIcon(R.drawable.sound);









        mMediaPlayer = new MediaPlayer();
        mAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        maxVolume = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        currentVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        soundUpUpUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC)+4;
                mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0);
                if (volume <15){
                    showToast("当前媒体音量"+mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
                }else if(volume>=15){
                    showToast("当前媒体音量已经最大");
                }
            }
        });
        soundDownDownDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC)-4;
                mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0);
                if (volume >0){
                    showToast("当前媒体音量"+mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
                }else if(volume<=0){
                    showToast("当前媒体音量已经最小");
                }
            }
        });




        soundUpUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volume = mAudioManager.getStreamVolume(AudioManager.STREAM_VOICE_CALL)+1;
                mAudioManager.setStreamVolume(AudioManager.STREAM_VOICE_CALL, volume, 0);
                if (volume <5){
                    showToast("当前通话音量"+mAudioManager.getStreamVolume(AudioManager.STREAM_VOICE_CALL));
                }else if(volume>=5){
                    showToast("当前通话音量已经最大");
                }
            }
        });
        soundDownDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volume = mAudioManager.getStreamVolume(AudioManager.STREAM_VOICE_CALL)-1;
                mAudioManager.setStreamVolume(AudioManager.STREAM_VOICE_CALL, volume, 0);
                if (volume >0){
                    showToast("当前通话音量"+mAudioManager.getStreamVolume(AudioManager.STREAM_VOICE_CALL));
                }else if(volume<=0){
                    showToast("当前通话音量已经最小");
                }
            }
        });

        mReadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mediaPlayer01;
                mediaPlayer01 = MediaPlayer.create(SettingActivity.this,R.raw.b);
                mediaPlayer01.start();
            }
        });















        lighUpUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sysbrightness = sysbrightness + 10;
                if (sysbrightness >= 100) {
                    sysbrightness = 100;
                }
                mScreenBrightnessTool.setBrightness(sysbrightness);
            }
        });
        lightDownDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sysbrightness = sysbrightness - 10;
                if (sysbrightness <= -50) {
                    sysbrightness = -50;
                }
                mScreenBrightnessTool.setBrightness(sysbrightness);
            }
        });
    }
    public void showToast(String string){
        Toast.makeText(this, string,Toast.LENGTH_SHORT).show();
    }
}
