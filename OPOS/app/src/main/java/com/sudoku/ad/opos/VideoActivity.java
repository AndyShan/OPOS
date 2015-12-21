package com.sudoku.ad.opos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by AD on 2015/8/18.
 */
public class VideoActivity extends Activity {
    private VideoButton[] mVideoButton = new VideoButton[13];

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        this.setContentView(R.layout.activity_video);
        mVideoButton[0] = (VideoButton)findViewById(R.id.video_1);
        mVideoButton[1] = (VideoButton)findViewById(R.id.vedio_2);
        mVideoButton[2] = (VideoButton)findViewById(R.id.vedio_3);
        mVideoButton[3] = (VideoButton)findViewById(R.id.vedio_4);
        mVideoButton[4] = (VideoButton)findViewById(R.id.vedio_5);
        mVideoButton[5] = (VideoButton)findViewById(R.id.vedio_6);
        mVideoButton[6] = (VideoButton)findViewById(R.id.vedio_7);
        mVideoButton[7] = (VideoButton)findViewById(R.id.vedio_8);
        mVideoButton[8] = (VideoButton)findViewById(R.id.vedio_9);
        mVideoButton[9] = (VideoButton)findViewById(R.id.vedio_10);
        mVideoButton[10] = (VideoButton)findViewById(R.id.vedio_11);
        mVideoButton[11] = (VideoButton)findViewById(R.id.vedio_12);
        mVideoButton[12] = (VideoButton)findViewById(R.id.vedio_13);

        URL url;
        int responsecode;
        HttpURLConnection urlConnection;
        BufferedReader reader;
        String[] webSource = new String[10000];
        String[] regResult1 = new String[100];
        String[] regResult2 = new String[17];
        String[] regResult4 = new String[17];
        String[] regResult3 = new String[17];
        String[] mName;
        final String[] mHref;

        StringBuffer stringbuffer = null;
        String webSourceResult = "";
        String regStringResult = "!";
        String regNameResult = "";
        String regNameResult2;
        String regNameResult3;
        String regNameResult4;
        String regNameResult5;
        String regHrefResult1 = "";
        String regHrefResult2;
        String regHrefResult3;
        String regHrefResult4;
        String regHrefResult5;





        try {
            url = new URL(
                    "http://list.iqiyi.com/www/2/-1655------------4-1-1-iqiyi--.html");
            urlConnection = (HttpURLConnection) url.openConnection();
            responsecode = urlConnection.getResponseCode();
            if (responsecode == 200) {
                int i = 0;
                reader = new BufferedReader(new InputStreamReader(
                        urlConnection.getInputStream(), "utf-8"));
                while (reader.readLine() != null) {
                    webSource[i] = reader.readLine();
                    i++;
                }
                for (int j = 0; j < webSource.length; j++) {
                    webSourceResult += webSource[j];
                }
                String mSource = webSourceResult.replaceAll(" ", "");
                String regEx = "<adata-searchpingback-elem=\"link\"data-searchpingback-param=\"ptype=2&site=iqiyi([\\s\\S]*?)</a";
                Pattern sourcePat = Pattern.compile(regEx);
                Matcher sourceMat = sourcePat.matcher(mSource);
                int j = 0;
                while (sourceMat.find()) {
                    System.out.println(j + "\t" + sourceMat.group());
                    regResult1[j] = sourceMat.group().toString();
                    j++;
                }
                for (int k = 0; k < regResult1.length; k++) {
                    regStringResult += regResult1[k];
                }
                String regEx2 = "alt([\\s\\S]*?)title";
                String regEx3 = "http://pic([\\s\\S]*?).jpg";
                String regEx4 = "\"href=\"([\\s\\S]*?)</p><divclass=\"role_info\"><em>";
                Pattern imagePat = Pattern.compile(regEx3);
                Pattern namePat2 = Pattern.compile(regEx2);
                Pattern hrefPat = Pattern.compile(regEx4);
                Matcher hrefMat = hrefPat.matcher(regStringResult);
                Matcher imageMat = imagePat.matcher(regStringResult);
                Matcher nameMat2 = namePat2.matcher(regStringResult);
                int l = 0;
                while(nameMat2.find()){
                    System.out.println(l+"\t"+nameMat2.group());
                    regResult2[l] = nameMat2.group();
                    l++;
                }
                int n = 0;
                while(imageMat.find()){
                    System.out.println(n+"\t"+imageMat.group());
                    regResult4[n] = imageMat.group();
                    n++;

                }
                int a=0;
                while(hrefMat.find()){
                    regResult3[a] = hrefMat.group();
                    a++;
                }
                for (int m = 0;m<regResult2.length;m++){
                    regNameResult+=regResult2[m];
                }
                regNameResult2 = regNameResult.replaceAll("\"titlealt=\"", "!!!");
                regNameResult3 = regNameResult2.replaceAll("alt=\"", "!!!");
                regNameResult4 = regNameResult3.replaceAll("\"title", "!!!");
                regNameResult5 = regNameResult4.trim();
                mName = regNameResult5.split("!!!");
                System.out.println(mName[1]);
                for(int b=0;b<regResult3.length;b++){
                    regHrefResult1+=regResult3[b];
                }
                regHrefResult2 = regHrefResult1.replaceAll("\"</p><divclass=\"role_info\"><em>\"href=\"", "!!!");
                regHrefResult3 = regHrefResult2.replaceAll("\"href=\"", "!!!");
                regHrefResult4 = regHrefResult3.replaceAll("</p><divclass=\"role_info\"><em>", "!!!");
                mHref = regHrefResult4.split("!!!");


                for (int c=0;c<mHref.length;c++){
                    mVideoButton[c].setText(mName[c+1]);
                    mVideoButton[c].setTextSize(40);
                    mVideoButton[c].loadUrl(regResult4[c]);
                    final int finalC = c;
                    mVideoButton[c].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(VideoActivity.this, WebActivity.class);
                            i.putExtra("src", mHref[finalC + 1]);
                            startActivity(i);
                        }
                    });
                }

            } else {
                System.out.println("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("失败");
        }

    }
}
