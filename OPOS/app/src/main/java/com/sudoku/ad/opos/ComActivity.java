package com.sudoku.ad.opos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;

/**
 * Created by AD on 2015/9/16.
 */
public class ComActivity extends Activity {
    private MyImageButton2 mReadButton;
    private MyImageButton2 mReturnButton;
    private MyImageButton3 mComButton;
    private MyImageButton2 mComButton1;
    private MyImageButton2 mComButton2;
    private MyImageButton2 mComButton3;
    private MyImageButton2 mComButton4;
    private MyImageButton2 mComButton5;
    private MyImageButton2 mComButton6;

    private Button mNewButton;
    private Button mCallButton;
    private Button mMessageButton;
    private EditText mMessageEdit;
    private PopupWindow mPopupWindow;
    private PopupWindow mMessagePopWindow;
    private ImageView mContactPic;
    private View mView;
    private View mPopview;
    Context mContext = null;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        this.setContentView(R.layout.activity_com);


        mContext = this;


        mReadButton = (MyImageButton2)findViewById(R.id.read_button);
        mReturnButton = (MyImageButton2)findViewById(R.id.return_button);
        mComButton = (MyImageButton3)findViewById(R.id.com);
        mComButton1 = (MyImageButton2)findViewById(R.id.com_1);
        mComButton2 = (MyImageButton2)findViewById(R.id.com_2);
        mComButton3 = (MyImageButton2)findViewById(R.id.com_3);
        mComButton4 = (MyImageButton2)findViewById(R.id.com_4);
        mComButton5 = (MyImageButton2)findViewById(R.id.com_5);
        mComButton6 = (MyImageButton2)findViewById(R.id.com_6);


        mReadButton.setBackground(R.drawable.test9);
        mReturnButton.setBackground(R.drawable.test9);

        mComButton.setBackground(R.drawable.com);
        mComButton1.setBackground(R.drawable.com_1);
        mComButton2.setBackground(R.drawable.com_2);
        mComButton3.setBackground(R.drawable.com_3);
        mComButton4.setBackground(R.drawable.com_4);
        mComButton5.setBackground(R.drawable.com_5);
        mComButton6.setBackground(R.drawable.com_6);


        mReturnButton.setmText("\t返回");
        mReturnButton.setmTextSize(20);
        mReadButton.setmText("\t阅读");
        mReadButton.setmTextSize(20);
        mComButton.setmText("  沟通");
        mComButton1.setmText("                 新建联系人");
        mComButton2.setmText("                     孙子");
        mComButton3.setmText("                     女儿");
        mComButton4.setmText("                     老伴");
        mComButton5.setmText("                   单广荻");
        mComButton6.setmText("                   徐媛一");
        mComButton.setmTextSize(60);
        mComButton1.setmTextSize(30);
        mComButton2.setmTextSize(30);
        mComButton3.setmTextSize(30);
        mComButton4.setmTextSize(30);
        mComButton5.setmTextSize(30);
        mComButton6.setmTextSize(30);


        mComButton1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mComButton1.setBackground(R.drawable.com_1_2);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    mComButton1.setBackground(R.drawable.com_1);
                }
                return false;
            }
        });

        mComButton2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    mComButton2.setBackground(R.drawable.com_2_2);
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    mComButton2.setBackground(R.drawable.com_2);
                }
                return false;
            }
        });

        mComButton3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    mComButton3.setBackground(R.drawable.com_3_2);
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    mComButton3.setBackground(R.drawable.com_3);
                }
                return false;
            }
        });

        mComButton4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    mComButton4.setBackground(R.drawable.com_4_2);
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    mComButton4.setBackground(R.drawable.com_4);
                }
                return false;
            }
        });

        mComButton5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    mComButton5.setBackground(R.drawable.com_5_2);
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    mComButton5.setBackground(R.drawable.com_5);
                }
                return false;
            }
        });

        mComButton6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    mComButton6.setBackground(R.drawable.com_6_2);
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    mComButton6.setBackground(R.drawable.com_6);
                }
                return false;
            }
        });
        mReadButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    mReadButton.setBackground(R.drawable.test9_2);
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    mReadButton.setBackground(R.drawable.test9);
                }
                return false;
            }
        });
        mReturnButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    mReturnButton.setBackground(R.drawable.test9_2);
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    mReturnButton.setBackground(R.drawable.test9);
                }
                return false;
            }
        });






        mComButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        mReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ComActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        mComButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView = getLayoutInflater().inflate(R.layout.activity_mpopupwindow, null);
                mPopupWindow = new PopupWindow(mView, 720, 600, true);
                mPopupWindow.showAsDropDown(mComButton2);
                mCallButton = (Button) mView.findViewById(R.id.call_button);
                mCallButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setAction(intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:" + "15522707712"));
                        startActivity(intent);
                        mPopupWindow.dismiss();
                    }
                });
                mMessageButton = (Button)mView.findViewById(R.id.message_button);
                mMessageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPopview = getLayoutInflater().inflate(R.layout.activity_my_message_edit_popupwindow, null);
                        mMessagePopWindow = new PopupWindow(mPopview, 720, 445, true);
                        mMessagePopWindow.showAsDropDown(mComButton2);
                        mPopupWindow.dismiss();

                        mMessageEdit = (EditText) mPopview.findViewById(R.id.message_edit);
                        mMessageButton = (Button) mPopview.findViewById(R.id.send_button);
                        mMessageButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ;
                                String text = mMessageEdit.getText().toString();
                                SmsManager sms = SmsManager.getDefault();
                                sms.sendTextMessage("15522707712", null, text, null, null);
                                mMessagePopWindow.dismiss();
                            }
                        });

                    }
                });

            }
        });
        mComButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView = getLayoutInflater().inflate(R.layout.activity_mpopupwindow, null);
                mPopupWindow = new PopupWindow(mView, 720, 600, true);
                mPopupWindow.showAsDropDown(mComButton3);
                mCallButton = (Button) mView.findViewById(R.id.call_button);
                mCallButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setAction(intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:" + "15522707712"));
                        startActivity(intent);
                        mPopupWindow.dismiss();
                    }
                });
                mMessageButton = (Button)mView.findViewById(R.id.message_button);
                mMessageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPopview = getLayoutInflater().inflate(R.layout.activity_my_message_edit_popupwindow,null);
                        mMessagePopWindow = new PopupWindow(mPopview,720,445,true);
                        mMessagePopWindow.showAsDropDown(mComButton3);
                        mPopupWindow.dismiss();

                        mMessageEdit = (EditText)mPopview.findViewById(R.id.message_edit);
                        mMessageButton = (Button)mPopview.findViewById(R.id.send_button);
                        mMessageButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {;
                                String text = mMessageEdit.getText().toString();
                                SmsManager sms = SmsManager.getDefault();
                                sms.sendTextMessage("15522707712", null, text, null, null);
                                mMessagePopWindow.dismiss();
                            }
                        });

                    }
                });

            }
        });
        mComButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView = getLayoutInflater().inflate(R.layout.activity_mpopupwindow, null);
                mPopupWindow = new PopupWindow(mView, 720, 600, true);
                mPopupWindow.showAsDropDown(mComButton4);
                mCallButton = (Button) mView.findViewById(R.id.call_button);
                mCallButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setAction(intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:" + "15522707712"));
                        startActivity(intent);
                        mPopupWindow.dismiss();
                    }
                });
                mMessageButton = (Button)mView.findViewById(R.id.message_button);
                mMessageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPopview = getLayoutInflater().inflate(R.layout.activity_my_message_edit_popupwindow,null);
                        mMessagePopWindow = new PopupWindow(mPopview,720,445,true);
                        mMessagePopWindow.showAsDropDown(mComButton4);
                        mPopupWindow.dismiss();

                        mMessageEdit = (EditText)mPopview.findViewById(R.id.message_edit);
                        mMessageButton = (Button)mPopview.findViewById(R.id.send_button);
                        mMessageButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {;
                                String text = mMessageEdit.getText().toString();
                                SmsManager sms = SmsManager.getDefault();
                                sms.sendTextMessage("15522707712", null, text, null, null);
                                mMessagePopWindow.dismiss();
                            }
                        });

                    }
                });

            }
        });
        mComButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView = getLayoutInflater().inflate(R.layout.activity_mpopupwindow, null);
                mPopupWindow = new PopupWindow(mView, 720, 600, true);
                mPopupWindow.showAsDropDown(mComButton5);
                mCallButton = (Button) mView.findViewById(R.id.call_button);
                mCallButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setAction(intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:" + "15522707712"));
                        startActivity(intent);
                        mPopupWindow.dismiss();
                    }
                });
                mMessageButton = (Button)mView.findViewById(R.id.message_button);
                mMessageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPopview = getLayoutInflater().inflate(R.layout.activity_my_message_edit_popupwindow,null);
                        mMessagePopWindow = new PopupWindow(mPopview,720,445,true);
                        mMessagePopWindow.showAsDropDown(mComButton5);
                        mPopupWindow.dismiss();

                        mMessageEdit = (EditText)mPopview.findViewById(R.id.message_edit);
                        mMessageButton = (Button)mPopview.findViewById(R.id.send_button);
                        mMessageButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {;
                                String text = mMessageEdit.getText().toString();
                                SmsManager sms = SmsManager.getDefault();
                                sms.sendTextMessage("15522707712", null, text, null, null);
                                mMessagePopWindow.dismiss();
                            }
                        });

                    }
                });

            }
        });
        mComButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView = getLayoutInflater().inflate(R.layout.activity_mpopupwindow, null);
                mPopupWindow = new PopupWindow(mView, 720, 600, true);
                mPopupWindow.showAsDropDown(mComButton6);
                mCallButton = (Button) mView.findViewById(R.id.call_button);
                mCallButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setAction(intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:" + "15522707712"));
                        startActivity(intent);
                        mPopupWindow.dismiss();
                    }
                });
                mMessageButton = (Button)mView.findViewById(R.id.message_button);
                mMessageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPopview = getLayoutInflater().inflate(R.layout.activity_my_message_edit_popupwindow,null);
                        mMessagePopWindow = new PopupWindow(mPopview,720,445,true);
                        mMessagePopWindow.showAsDropDown(mComButton6);
                        mPopupWindow.dismiss();

                        mMessageEdit = (EditText)mPopview.findViewById(R.id.message_edit);
                        mMessageButton = (Button)mPopview.findViewById(R.id.send_button);
                        mMessageButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {;
                                String text = mMessageEdit.getText().toString();
                                SmsManager sms = SmsManager.getDefault();
                                sms.sendTextMessage("15522707712", null, text, null, null);
                                mMessagePopWindow.dismiss();
                            }
                        });

                    }
                });

            }
        });

        mReadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mediaPlayer01;
                mediaPlayer01 = MediaPlayer.create(ComActivity.this,R.raw.c);
                mediaPlayer01.start();
            }
        });






    }
}
