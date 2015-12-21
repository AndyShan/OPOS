package com.sudoku.ad.opos;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by AD on 2015/8/5.
 */
public class MessageActivity extends Activity implements
        AMapLocationListener, View.OnClickListener {
    private MyImageButton2 mReturnButton;
    private MyImageButton2 mReadButton;
    private TextView mPoliceButton;
    private TextView mAidButton;
    private TextView sendAddressButton;
    private TextView deadButton;
    private TextView falseButton;
    private TextView mAddress;
    private LocationManagerProxy mLocationManagerProxy;
    private Random mRandom = new Random();
    SmsReciver smsReciver;
    MyStaticValue myStaticValue;

    @Override
    protected void onCreate(Bundle saveInstnceState){
        super.onCreate(saveInstnceState);
        setContentView(R.layout.activity_message);
        init();
        initView();
        smsReciver = new SmsReciver();
        myStaticValue = new MyStaticValue();


        Timer timer2 = new Timer();
        timer2.schedule(task,1000,1000);

        mReturnButton = (MyImageButton2)findViewById(R.id.return_button);
        mReadButton = (MyImageButton2)findViewById(R.id.read_button);

        mPoliceButton = (TextView)findViewById(R.id.police_button);
       mAidButton = (TextView)findViewById(R.id.aid_button);
        sendAddressButton = (TextView)findViewById(R.id.send_address);
        deadButton = (TextView)findViewById(R.id.dead_button);
        falseButton = (TextView)findViewById(R.id.false_button);

        mReturnButton.setmText("\t返回");
        mReturnButton.setmTextSize(20);
        mReadButton.setmText("\t阅读");
        mReadButton.setmTextSize(20);




        mReadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "不小心按错了，我很安全，放心";
//                String phoneNumber = getIntent().getStringExtra("number");
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(myStaticValue.PHONE_NUMBER, null, text, null, null);
                showToast("发送成功");
            }
        });
        mPoliceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:13703359884"));
                startActivity(intent);
            }
        });
        mAidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:13703359884"));
                startActivity(intent);
            }
        });
        mReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MessageActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        sendAddressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = mAddress.getText().toString();
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(myStaticValue.PHONE_NUMBER, null, string, null, null);
            }
        });
        deadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MessageActivity.this,GravityActivity.class);
                startActivity(i);
            }
        });
    }
    private void init() {
        // 初始化定位，只采用网络定位
        mLocationManagerProxy = LocationManagerProxy.getInstance(this);
        mLocationManagerProxy.setGpsEnable(false);
        // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
        // 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用removeUpdates()方法来取消定位请求
        // 在定位结束后，在合适的生命周期调用destroy()方法
        // 其中如果间隔时间为-1，则定位只定一次,
        // 在单次定位情况下，定位无论成功与否，都无需调用removeUpdates()方法移除请求，定位sdk内部会移除
        mLocationManagerProxy.requestLocationData(
                LocationProviderProxy.AMapNetwork, 60 * 1000, 15, this);

    }
    private void initView() {

        mAddress = (TextView) findViewById(R.id.address);


    }
    @Override
    public void onLocationChanged(Location arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onProviderDisabled(String arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onProviderEnabled(String arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onLocationChanged(AMapLocation amapLocation) {

        if (amapLocation != null
                && amapLocation.getAMapException().getErrorCode() == 0) {
            // 定位成功回调信息，设置相关消息


            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date(amapLocation.getTime());

            mAddress.setText(amapLocation.getAddress());


        } else {
            Log.e("AmapErr", "Location ERR:" + amapLocation.getAMapException().getErrorCode());
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        // 移除定位请求
        mLocationManagerProxy.removeUpdates(this);
        // 销毁定位
        mLocationManagerProxy.destroy();
    }

    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.location_time_button:
                // 注意更换定位时间后，需要先将定位请求删除，再进行定位请求
                mLocationManagerProxy.removeUpdates(this);
                int randomTime = mRandom.nextInt(1000);
                mLocationManagerProxy.requestLocationData(
                        LocationProviderProxy.AMapNetwork, 60 * 1000 + randomTime,
                        15, this);
                mLocationManagerProxy.setGpsEnable(false);
                break;
        }
    }
    public void showToast(String string){
        Toast.makeText(this, string,Toast.LENGTH_SHORT).show();
    }
    private void displayToast(String s)
         {
                 Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
             }
    TimerTask task = new TimerTask() {
        @Override
        public void run() {

            Log.v("哈哈",smsReciver.control+"");
            if (smsReciver.control == 1){
                String string = "北京联合大学北四环校区2号楼";
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage("15620696716", null, string, null, null);

                smsReciver.control = 0;
            }

        }
    };
}
