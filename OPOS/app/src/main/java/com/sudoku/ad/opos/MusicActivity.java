package com.sudoku.ad.opos;

import android.app.Activity;
import android.os.Bundle;

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
import com.sudoku.ad.opos.R;

/**
 * Created by AD on 2015/8/18.
 */
public class MusicActivity extends Activity{

    private String string;
    private EditText editText;
    private Button button;
    String[] nameResult = new String[100];
    String nameStringResult = "";
    String[] mName;
    TextView[] nameTextViews = new TextView[4];


    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        this.setContentView(R.layout.activity_music);
        editText = (EditText)findViewById(R.id.music_edittext);
        button = (Button)findViewById(R.id.music_button);

        nameTextViews[0] = (TextView)findViewById(R.id.test_textView);
        nameTextViews[1] = (TextView)findViewById(R.id.test_textView3);
        nameTextViews[2] = (TextView)findViewById(R.id.test_textView5);
        nameTextViews[3] = (TextView)findViewById(R.id.test_textView7);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AsyncHttpResponseHandler resHandler=new AsyncHttpResponseHandler(){
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable e) {
                        //做一些异常处理
                        e.printStackTrace();
                    }
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        try {
                            System.out.println("response is :"+new String(responseBody,"utf-8"));
                            string = new String(responseBody,"utf-8");
                            String s = string.replaceAll(" ","");
                            String regEx = "songName\":\"([\\s\\S]*?)\"songUrl";
                            Pattern songNamePat = Pattern.compile(regEx);
                            Matcher songNameMat = songNamePat.matcher(s);
                            int j = 0;
                            while (songNameMat.find()) {
                                nameResult[j] = songNameMat.group().toString();
                                j++;
                            }
                            for (int k = 0; k < nameResult.length; k++) {
                                nameStringResult += nameResult[k];
                            }
                            nameStringResult.replaceAll("\",\"songUrlsongName\":\"", "!!!");
                            String nameStringResult2 = nameStringResult.replaceAll("songName\":\"","!!!");
                            String nameStringResult3 = nameStringResult2.replaceAll("\",\"songUrl","!!!");
                            mName = nameStringResult3.split("!!!");
                            for(int k = 0;k <= 3;k++){
                                nameTextViews[k].setText(mName[k]);
                            }
                            //在此对返回内容做处理
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }

                    }};
                new ShowApiRequest("http://route.showapi.com/760-1", "5879", "fa8047ba0a1742d785705bed6f5852f0")
                        .setResponseHandler(resHandler)
                        .addTextPara("s", editText.getText().toString())
                        .addTextPara("p", "")
                        .addTextPara("limit", "")
                        .addTextPara("key", "482dcc55534d629f559c4dd62f1d6a6e09bf61fc")
                        .post();
            }
        });


    }
}
