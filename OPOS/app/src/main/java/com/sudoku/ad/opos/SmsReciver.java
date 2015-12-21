package com.sudoku.ad.opos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by AD on 2015/9/22.
 */
public class SmsReciver extends BroadcastReceiver {

    static int control = 0;
    MyStaticValue myStaticValue = new MyStaticValue();
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        SmsMessage msg = null;
        if (null != bundle) {
            Object[] smsObj = (Object[]) bundle.get("pdus");
            for (Object object : smsObj) {
                msg = SmsMessage.createFromPdu((byte[]) object);
                Date date = new Date(msg.getTimestampMillis());//时间
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String receiveTime = format.format(date);
                System.out.println("number:" + msg.getOriginatingAddress()
                        + "   body:" + msg.getDisplayMessageBody() + "  time:"
                        + msg.getTimestampMillis());
                Log.v("body",msg.getDisplayMessageBody());
                //在这里写自己的逻辑
                if (msg.getDisplayMessageBody().equals("001")) {
                    //TODO
                    this.control = 1;
                }
                if (msg.getDisplayMessageBody().equals("002")){
                    myStaticValue.SETTING_SOUND = "SOUND_MAX";
                }
                if (msg.getDisplayMessageBody().equals("003")){
                    myStaticValue.COM = "COM";
                }

            }
        }
    }

}
