package com.sudoku.ad.opos;

import android.app.Activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.show.api.ShowApiRequest;

import org.apache.http.Header;



/**
 * Created by AD on 2015/9/2.
 */
public class FoodActivity extends Activity{
    private Button mRightButton;
    private EditText mFoodEditText;
    private TextView mFoodTextView;
    String[] result;
    String[] zFResult;
    String stringResult = "";
    String stringZFResult = "";
    String my_result = "";

    //以下代码仅为演示用,具体传入参数请参看接口描述详情页.
//需要引用android-async-http库(sdk中已经包括此jar包) ,其项目地址为： http://loopj.com/android-async-http/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        mRightButton = (Button)findViewById(R.id.search_food_right);
        mFoodEditText = (EditText)findViewById(R.id.search_food);
        mFoodTextView = (TextView)findViewById(R.id.food_text);
        final AsyncHttpResponseHandler resHandler=new AsyncHttpResponseHandler(){
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable e) {
                //做一些异常处理
                e.printStackTrace();
            }
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String mresponseBody = new String(responseBody,"utf-8");
                    String regEx = "cl([\\s\\S]*?)imgList";
                    Pattern foodNamePat = Pattern.compile(regEx);
                    Matcher foodNameMat = foodNamePat.matcher(mresponseBody);
                    while (foodNameMat.find()) {
                        stringResult = foodNameMat.group().toString();
                    }
                    String stringResult2 = stringResult.replaceAll("cl\":\"", "!!!");
                    String stringResult3 = stringResult2.replaceAll("\",\"imgList","!!!");
                    String stringResult4 = stringResult3.replaceAll("、","!!!");

                    String stringResult5 = stringResult4.replaceAll("辅料：","!!!");
                    String stringResult6 = stringResult5.replaceAll("：","!!!");
                    String stringResult7 = stringResult6.replaceAll(" ","");
                    String stringResult8 = stringResult7.replaceAll("，","!!!");
                    String stringResult9 = stringResult8.replaceAll("。", "!!!");
                    result = stringResult9.split("!!!");




                    String regEx2 = "zf([\\s\\S]*?)cbId";
                    Pattern foodZFPat = Pattern.compile(regEx2);
                    Matcher foodZFMat = foodZFPat.matcher(mresponseBody);
                    while (foodZFMat.find()) {
                        stringZFResult = foodZFMat.group().toString();
                    }

                    String stringZFResult2 = stringZFResult.replaceAll(" ", "");
                    String stringZFResult3 = stringZFResult2.replaceAll("zf\": \"", "");
                    String stringZFResult4 = stringZFResult3.replaceAll("\"", "");
                    String stringZFResult5 = stringZFResult4.replaceAll(",","");
                    String stringZFResult6 = stringZFResult5.replaceAll("cbId","");
                    String stringZFResult7 = stringZFResult6.replaceAll("1、","!!!");
                    String stringZFResult8 = stringZFResult7.replaceAll("2、","!!!");
                    String stringZFResult9 = stringZFResult8.replaceAll("3、", "!!!");
                    String stringZFResult10 = stringZFResult9.replaceAll("1:", "!!!");
                    String stringZFResult11 = stringZFResult10.replaceAll("2:","!!!");
                    String stringZFResult12 = stringZFResult11.replaceAll("3:","!!!");

                    String stringZFResult16 = stringZFResult12.replaceAll("4、","!!!");
                    String stringZFResult17 = stringZFResult16.replaceAll("5、","!!!");
                    String stringZFResult18 = stringZFResult17.replaceAll("6、","!!!");
                    String stringZFResult19 = stringZFResult18.replaceAll("4:","!!!");
                    String stringZFResult20 = stringZFResult19.replaceAll("5:","!!!");
                    String stringZFResult21 = stringZFResult20.replaceAll("6:","!!!");
                    String stringZFResult22 = stringZFResult21.replaceAll("4.","!!!");
                    String stringZFResult23 = stringZFResult22.replaceAll("5.","!!!");
                    String stringZFResult24 = stringZFResult23.replaceAll("6.","!!!");


                    String stringZFResult25 = stringZFResult24.replaceAll("7、","!!!");
                    String stringZFResult26 = stringZFResult25.replaceAll("8、","!!!");
                    String stringZFResult27 = stringZFResult26.replaceAll("9、","!!!");
                    String stringZFResult28 = stringZFResult27.replaceAll("7:","!!!");
                    String stringZFResult29 = stringZFResult28.replaceAll("8:","!!!");
                    String stringZFResult30 = stringZFResult29.replaceAll("9:","!!!");
                    String stringZFResult31 = stringZFResult30.replaceAll("7.","!!!");
                    String stringZFResult32 = stringZFResult31.replaceAll("8.","!!!");
                    String stringZFResult33 = stringZFResult32.replaceAll("9.","!!!");
                    zFResult = stringZFResult33.split("!!!");

                    for (int i = 0;i<zFResult.length;i++){
                        my_result = my_result+((i+1)+"、"+zFResult[i]+"\n");
                    }
                    mFoodTextView.setText(my_result);




                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }};
        mRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mFoodEditText.getText().toString();

                new ShowApiRequest("http://route.showapi.com/95-106", "5879", "fa8047ba0a1742d785705bed6f5852f0")
                        .setResponseHandler(resHandler)
                        .addTextPara("type", "")
                        .addTextPara("name", name)
                        .post();
            }
        });
    }

}
