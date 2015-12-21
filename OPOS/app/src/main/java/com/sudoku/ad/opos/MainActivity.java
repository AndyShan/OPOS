package com.sudoku.ad.opos;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.media.MediaPlayer;
import android.os.Looper;
import android.os.StrictMode;
import android.provider.ContactsContract;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;
import com.getpebble.android.kit.PebbleKit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends Activity {
    private MyImageButton2 mSettingButton;
    private MyImageButton2 mRelaxButton;
    private MyImageButton2 mHelpButton;
    private MyImageButton2 mComButton;
    private MyImageButton2 mToolbutton;
    private MyImageButton2 mReadButton;
    private MyImageButton2 mReturnButton;
    private MyImageButton5 mWeatherButton;
    private String phoneNumber;
    private TextToSpeech mTextToSpeech;
    SmsReciver smsReciver;
    Timer timer = new Timer(true);
    static int index = 0;
    MyStaticValue myStaticValue;


    static int index_down = 0;
    /** Called when the activity is first created. */
    //设置LOG标签
    private static final String TAG = "sensor";
    private  SensorManager sm;
    private Button mGraButton;
    Timer timer2 = new Timer(true);



    int a = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        smsReciver = new SmsReciver();
        myStaticValue = new MyStaticValue();
        control();

        sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        //选取加速度感应器
        int sensorType = Sensor.TYPE_ACCELEROMETER;
        mGraButton = (Button)findViewById(R.id.gravity_button);
        mGraButton.setVisibility(View.INVISIBLE);

         /*
  * 最常用的一个方法 注册事件
  * 参数1 ：SensorEventListener监听器
  * 参数2 ：Sensor 一个服务可能有多个Sensor实现，此处调用getDefaultSensor获取默认的Sensor
  * 参数3 ：模式 可选数据变化的刷新频率
  * */
        sm.registerListener(myAccelerometerListener, sm.getDefaultSensor(sensorType), SensorManager.SENSOR_DELAY_NORMAL);


        timer.schedule(task, 1000, 1000);
        timer2.schedule(task2, 100, 100);
        mSettingButton = (MyImageButton2)findViewById(R.id.setting_button);
        mComButton = (MyImageButton2)findViewById(R.id.com_button);
        mHelpButton = (MyImageButton2)findViewById(R.id.help_button);
        mRelaxButton = (MyImageButton2)findViewById(R.id.relax_button);
        mToolbutton = (MyImageButton2)findViewById(R.id.tool_button);
        mReadButton =(MyImageButton2)findViewById(R.id.read_button);
        mReturnButton  =(MyImageButton2)findViewById(R.id.return_button);
        mWeatherButton = (MyImageButton5)findViewById(R.id.weather_button);


        mSettingButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    mSettingButton.setBackground(R.drawable.test1_2);
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    mSettingButton.setBackground(R.drawable.test1);
                }
                return false;
            }
        });
        mRelaxButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    mRelaxButton.setBackground(R.drawable.test3_2);
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    mRelaxButton.setBackground(R.drawable.test3);
                }
                return false;
            }
        });
        mComButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    mComButton.setBackground(R.drawable.test2_2);
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    mComButton.setBackground(R.drawable.test2);
                }
                return false;
            }
        });
        mToolbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mToolbutton.setBackground(R.drawable.test4_2);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    mToolbutton.setBackground(R.drawable.test4);
                }
                return false;
            }
        });
        mHelpButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mHelpButton.setBackground(R.drawable.test5_2);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    mHelpButton.setBackground(R.drawable.test5);
                }
                return false;
            }
        });
        mReadButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mReadButton.setBackground(R.drawable.test9_2);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    mReadButton.setBackground(R.drawable.test9);
                }
                return false;
            }
        });
        mReturnButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mReturnButton.setBackground(R.drawable.test9_2);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    mReturnButton.setBackground(R.drawable.test9);
                }
                return false;
            }
        });
        mSettingButton.setBackground(R.drawable.test1);
        mRelaxButton.setBackground(R.drawable.test3);
        mComButton.setBackground(R.drawable.test2);
        mToolbutton.setBackground(R.drawable.test4);
        mHelpButton.setBackground(R.drawable.test5);
        mReadButton.setBackground(R.drawable.test9);
        mReturnButton.setBackground(R.drawable.test9);

            /*
            �����������ܷ������硣
             */
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads().detectDiskWrites().detectNetwork()
                    .penaltyLog().build());

            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()
                    .build());
//        phoneNumber =getIntent() .getStringExtra("number");
        mSettingButton.setmText(" 设置");
        mSettingButton.setmTextSize(40);
        mRelaxButton.setmText(" 放松");
        mRelaxButton.setmTextSize(40);
        mToolbutton.setmText(" 工具");
        mToolbutton.setmTextSize(40);
        mComButton.setmText(" 沟通");
        mComButton.setmTextSize(40);
        mHelpButton.setmText(" 求助");
        mHelpButton.setmTextSize(40);
        mReturnButton.setmText("\t返回");
        mReturnButton.setmTextSize(20);
        mReadButton.setmText("\t阅读");
        mReadButton.setmTextSize(20);
        mHelpButton.setIcon(R.drawable.help_button);
        mComButton.setIcon(R.drawable.com_button);
        mSettingButton.setIcon(R.drawable.setting_button);
        mRelaxButton.setIcon(R.drawable.relax_button);
        mToolbutton.setIcon(R.drawable.tool_button);
        mWeatherButton.setWeather("9°-16°多云");
        mWeatherButton.setTimeMonth(DateFormat.getMediumDateFormat(getApplicationContext()).format(new Date()));
        mWeatherButton.setTimeNow(DateFormat.getTimeFormat(getApplicationContext()).format(new Date()));

        mRelaxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RelaxActivity.class);
                startActivity(i);
            }
        });
        mHelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "求助";
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(myStaticValue.PHONE_NUMBER, null, text, null, null);
                Intent i = new Intent(MainActivity.this, MessageActivity.class);
//                i.putExtra("number",phoneNumber);
                startActivity(i);

            }
        });
        mToolbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ToolActivity.class);
                startActivity(i);
            }
        });
        mSettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SettingActivity.class);
                startActivity(i);
            }
        });
        mComButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ComActivity.class);
                startActivity(i);
            }
        });
        mReadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mediaPlayer01;
                mediaPlayer01 = MediaPlayer.create(MainActivity.this,R.raw.a);
                mediaPlayer01.start();
            }
        });

  /*
*/

        }



    /*
* SensorEventListener接口的实现，需要实现两个方法
* 方法1 onSensorChanged 当数据变化的时候被触发调用
* 方法2 onAccuracyChanged 当获得数据的精度发生变化的时候被调用，比如突然无法获得数据时
* */
    final SensorEventListener myAccelerometerListener = new SensorEventListener(){

        //复写onSensorChanged方法
        public void onSensorChanged(SensorEvent sensorEvent){
            if(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
                Log.i(TAG,"onSensorChanged");

                //图解中已经解释三个值的含义
                final float X_lateral = sensorEvent.values[0];
                float Y_longitudinal = sensorEvent.values[1];
                final float Z_vertical = sensorEvent.values[2];
                mGraButton.setText("Z:"+(int)Z_vertical);
                if (Z_vertical >= 12){
                    mGraButton.setText("12");
                }

            }
        }

        //复写onAccuracyChanged方法
        public void onAccuracyChanged(Sensor sensor , int accuracy){
            Log.i(TAG, "onAccuracyChanged");
        }
    };

    public void onPause(){
         /*
  * 很关键的部分：注意，说明文档中提到，即使activity不可见的时候，感应器依然会继续的工作，测试的时候可以发现，没有正常的刷新频率
  * 也会非常高，所以一定要在onPause方法中关闭触发器，否则讲耗费用户大量电量，很不负责。
  * */
        sm.unregisterListener(myAccelerometerListener);
        super.onPause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        boolean isConnected = PebbleKit.isWatchConnected(this);
        Toast.makeText(this, "Pebble " + (isConnected ? "is" : "is not") + " connected!", Toast.LENGTH_LONG).show();
        if (isConnected&&index!=2){
            index = 0;
        }else if((isConnected == false)&&(index!=2)){
            index = 1;
        }


    }


/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */




    public String getWeather() throws IOException {
        String APIKEY ="100a7cb637dd84072ae42bc892bcd21a";
        //String INFO = URLEncoder.encode("�ػʵ�����","utf-8");
        String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY + "&info=" + "%E7%A7%A6%E7%9A%87%E5%B2%9B%E5%A4%A9%E6%B0%94";
        URL getUrl = new URL(getURL);
        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
        connection.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
        StringBuffer weather = new StringBuffer();
        String line = "";
        while ((line = reader.readLine()) != null) {
            weather.append(line);
        }
        reader.close();
        connection.disconnect();
        String mWeather = weather.substring(36, 42)+weather.substring(47,49);
        return mWeather;
    }
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if (index == 1){
                Intent i =new Intent(MainActivity.this,WarningActivity.class);
                startActivity(i);
                index = 2;
            }else{
                Log.v("呵呵","1");
            }
            Log.v("哈哈",smsReciver.control+"");
            if (smsReciver.control == 1){
                Intent i = new Intent(MainActivity.this,MessageActivity.class);
                i.putExtra("control","001");
                startActivity(i);
                smsReciver.control = 0;
            }

        }
    };
    TimerTask task2 = new TimerTask() {
        @Override
        public void run() {
            if ((mGraButton.getText().toString().equals("12"))&&(index_down == 0)){
                Intent i = new Intent(MainActivity.this,WarningActivity2.class);
                startActivity(i);
                index_down = 1;
            }
        }


    };

    private void displayToast(String s)
    {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

    }
    private void control(){
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (myStaticValue.SETTING_SOUND.equals("SOUND_MAX")){
                    Intent i = new Intent(MainActivity.this,SettingActivity.class);
                    i.putExtra("control","setting_sound");
                    startActivity(i);
                    myStaticValue.SETTING_SOUND = " ";
                }
                if (myStaticValue.COM.equals("COM")){
                    Intent i =new Intent(MainActivity.this,ComActivity.class);
                    startActivity(i);
                    myStaticValue.COM = " ";
                }
            }
        };
        Timer timer = new Timer(true);
        timer.schedule(timerTask,200,20000);
    }


}
