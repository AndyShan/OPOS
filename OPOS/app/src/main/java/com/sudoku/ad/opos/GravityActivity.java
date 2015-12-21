/*
 2  * @author octobershiner
 3  * 2011 07 27
 4  * SE.HIT
 5  * 一个演示android加速度感应器的例子
 6  * */
package com.sudoku.ad.opos;


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

public class GravityActivity extends Activity {
    static int index = 0;
 /** Called when the activity is first created. */
         //设置LOG标签
    private static final String TAG = "sensor";
    private  SensorManager sm;
    private TextView textView;
    Timer timer = new Timer(true);
 @Override
 public void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.gravity_activity);
     timer.schedule(task, 100, 100);
     //创建一个SensorManager来获取系统的传感器服务
     sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
     //选取加速度感应器
     int sensorType = Sensor.TYPE_ACCELEROMETER;
     textView = (TextView)findViewById(R.id.gravity_view);

         /*
  * 最常用的一个方法 注册事件
  * 参数1 ：SensorEventListener监听器
  * 参数2 ：Sensor 一个服务可能有多个Sensor实现，此处调用getDefaultSensor获取默认的Sensor
  * 参数3 ：模式 可选数据变化的刷新频率
  * */
         sm.registerListener(myAccelerometerListener, sm.getDefaultSensor(sensorType), SensorManager.SENSOR_DELAY_NORMAL);

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
                     textView.setText("Z:"+(int)Z_vertical);
                     if (Z_vertical >= 11){
                         textView.setText("11");
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
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if ((textView.getText().toString().equals("11"))&&(index == 0)){
                    Intent i = new Intent(GravityActivity.this,WarningActivity2.class);
                    startActivity(i);
                    index = 1;
                }
            }


        };

     }