package com.sudoku.ad.opos;


import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by AD on 2015/8/7.
 */
public class CommunicationActivity extends Activity {
    private Button mReturnButton;
    private Button[] mContactButtons=new Button[28];
    private EditText mNameEditText;
    private EditText mNumberEditText;
    Context mContext = null;
    /** 获取库Phon表字段 **/
    private static final String[] PHONES_PROJECTION = new String[] {
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Photo.PHOTO_ID, ContactsContract.CommonDataKinds.Phone.CONTACT_ID };

    /** 联系人显示名称 **/
    private static final int PHONES_DISPLAY_NAME_INDEX = 0;

    /** 电话号码 **/
    private static final int PHONES_NUMBER_INDEX = 1;

    /** 头像ID **/
    private static final int PHONES_PHOTO_ID_INDEX = 2;

    /** 联系人的ID **/
    private static final int PHONES_CONTACT_ID_INDEX = 3;

    /** 联系人名称 **/
    private ArrayList<String> mContactsName = new ArrayList<String>();

    /** 联系人电话 **/
    private ArrayList<String> mContactsNumber = new ArrayList<String>();

    /** 联系人头像 **/
    private ArrayList<Bitmap> mContactsPhonto = new ArrayList<Bitmap>();



    // private String[] mContact= new String[]{"Joyice","Andy","Mike",
    //      "Jams","Kobe","Rose","Paul"};
    //private String[] mNumber = new String[]{"15522707712","13703359884","15620696716",
    //         "13933513673","13472992045","13333346804","13933546433"};
    private Button mNewButton;
    private Button mCallButton;
    private Button mMessageButton;
    private Button mFinishButton;
    private EditText mMessageEdit;
    private PopupWindow mPopupWindow;
    private PopupWindow mMessagePopWindow;
    private PopupWindow mNewPopupWindow;
    private ImageView mContactPic;
    private View mNewView;
    private View mView;
    private View mPopview;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_communication);


        mContext = this;


        getPhoneContacts();
//		getSIMContacts();



        mContactButtons[0] = (Button)findViewById(R.id.button1);
        mContactButtons[1] = (Button)findViewById(R.id.button2);
        mContactButtons[2] = (Button)findViewById(R.id.button3);
        mContactButtons[3] = (Button)findViewById(R.id.button4);
        mContactButtons[4] = (Button)findViewById(R.id.button5);
        mContactButtons[5] = (Button)findViewById(R.id.button6);
        mContactButtons[6] = (Button)findViewById(R.id.button7);
        mContactButtons[7] = (Button)findViewById(R.id.button8);
        mContactButtons[8] = (Button)findViewById(R.id.button9);
        mContactButtons[9] = (Button)findViewById(R.id.button10);
        mContactButtons[10] = (Button)findViewById(R.id.button11);
        mContactButtons[11] = (Button)findViewById(R.id.button12);
        mContactButtons[12] = (Button)findViewById(R.id.button13);
        mContactButtons[13] = (Button)findViewById(R.id.button14);
        mContactButtons[14] = (Button)findViewById(R.id.button15);
        mContactButtons[15] = (Button)findViewById(R.id.button16);
        mContactButtons[16] = (Button)findViewById(R.id.button17);
        mContactButtons[17] = (Button)findViewById(R.id.button18);
        mContactButtons[18] = (Button)findViewById(R.id.button19);
        mContactButtons[19] = (Button)findViewById(R.id.button20);
        mContactButtons[20] = (Button)findViewById(R.id.button21);
        mContactButtons[21] = (Button)findViewById(R.id.button22);
        mContactButtons[22] = (Button)findViewById(R.id.button23);
        mContactButtons[23] = (Button)findViewById(R.id.button24);
        mContactButtons[24] = (Button)findViewById(R.id.button25);
        mContactButtons[25] = (Button)findViewById(R.id.button26);
        mContactButtons[26] = (Button)findViewById(R.id.button27);
        mContactButtons[27] = (Button)findViewById(R.id.button28);
        updateContact();

        mNewButton = (Button)findViewById(R.id.new_button);
        mNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
//                mNewView = getLayoutInflater().inflate(R.layout.activity_new_contact,null);
//                mNewPopupWindow = new PopupWindow(mNewView,720,445,true);
//                mNewPopupWindow.showAsDropDown(mNewButton);
//                mNewPopupWindow.setOutsideTouchable(true);
//                mNewPopupWindow.setFocusable(true);
//                mNewPopupWindow.setTouchInterceptor(new View.OnTouchListener() {
//                    @Override
//                    public boolean onTouch(View v, MotionEvent event) {
//                        if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
//                            mNewPopupWindow.dismiss();
//                            return true;
//                        }
//                        return false;
//                    }
//                });
//
//                mNameEditText = (EditText)mNewView.findViewById(R.id.name_edit);
//                mNumberEditText = (EditText)mNewView.findViewById(R.id.number_edit);
//                mFinishButton = (Button)mNewView.findViewById(R.id.finish_button);
//                mFinishButton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        mContactsName.add(mNameEditText.getText().toString());
//                        mContactsNumber.add(mNumberEditText.getText().toString());
//                        updateContact();
//                        mNewPopupWindow.dismiss();
//
//                    }
//                });


            }
        });
        mReturnButton = (Button)findViewById(R.id.return_button);
        mReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CommunicationActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        updateContact();

    }
    public void updateContact(){
        for (int i=0;i<this.mContactsName.size();i++){
            mContactButtons[i].setVisibility(View.VISIBLE);
            mContactButtons[i].setText(mContactsName.get(i));

        }
        for (int i=mContactsName.size();i<mContactButtons.length;i++){
            mContactButtons[i].setVisibility(View.INVISIBLE);
            mContactButtons[i].setEnabled(false);
        }
        for(int j=0;j<mContactsName.size();j++) {
            final int finalJ = j;
            mContactButtons[finalJ].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mView = getLayoutInflater().inflate(R.layout.activity_mpopupwindow, null);
                    mPopupWindow = new PopupWindow(mView, 720, 600, true);
                    mPopupWindow.showAsDropDown(mContactButtons[finalJ]);



                    mContactPic = (ImageView)mView.findViewById(R.id.contact_pic);
                    mContactPic.setImageBitmap(mContactsPhonto.get(finalJ));

                    mCallButton = (Button) mView.findViewById(R.id.call_button);
                    mCallButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent();
                            intent.setAction(intent.ACTION_CALL);
                            intent.setData(Uri.parse("tel:"+mContactsNumber.get(finalJ)));
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
                            mMessagePopWindow.showAsDropDown(mContactButtons[finalJ]);
                            mPopupWindow.dismiss();

                            mMessageEdit = (EditText)mPopview.findViewById(R.id.message_edit);
                            mMessageButton = (Button)mPopview.findViewById(R.id.send_button);
                            mMessageButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    String mobile = mContactsNumber.get(finalJ);
                                    String text = mMessageEdit.getText().toString();
                                    SmsManager sms = SmsManager.getDefault();
                                    sms.sendTextMessage(mobile,null,text,null,null);
                                    mMessagePopWindow.dismiss();
                                }
                            });

                        }
                    });



                }
            });
        }
    }
    private void getPhoneContacts() {
        ContentResolver resolver = mContext.getContentResolver();

        // 获取手机联系人
        Cursor phoneCursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, PHONES_PROJECTION, null, null, null);

        if (phoneCursor != null) {
            while (phoneCursor.moveToNext()) {

                // 得到手机号码
                String phoneNumber = phoneCursor.getString(PHONES_NUMBER_INDEX);
                // 当手机号码为空的或者为空字段 跳过当前循环
                if (TextUtils.isEmpty(phoneNumber))
                    continue;

                // 得到联系人名称
                String contactName = phoneCursor
                        .getString(PHONES_DISPLAY_NAME_INDEX);

                // 得到联系人ID
                Long contactid = phoneCursor.getLong(PHONES_CONTACT_ID_INDEX);

                // 得到联系人头像ID
                Long photoid = phoneCursor.getLong(PHONES_PHOTO_ID_INDEX);

                // 得到联系人头像Bitamp
                Bitmap contactPhoto = null;

                // photoid 大于0 表示联系人有头像 如果没有给此人设置头像则给他一个默认的
                if (photoid > 0) {
                    Uri uri = ContentUris.withAppendedId(
                            ContactsContract.Contacts.CONTENT_URI, contactid);
                    InputStream input = ContactsContract.Contacts
                            .openContactPhotoInputStream(resolver, uri);
                    contactPhoto = BitmapFactory.decodeStream(input);
                } else {
                    contactPhoto = BitmapFactory.decodeResource(getResources(),
                            R.drawable.contact_photo);
                }

                mContactsName.add(contactName);
                mContactsNumber.add(phoneNumber);
                mContactsPhonto.add(contactPhoto);
            }


            phoneCursor.close();
        }
    }

}
