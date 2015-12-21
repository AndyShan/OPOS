package com.sudoku.ad.opos.ebook;
/**
 * Created by AD on 2015/8/13.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.sudoku.ad.opos.R;

/*
 * 主界面
 * 按钮 和 说明文字
 * 按钮出发 跳转ListAllFileActivity
 */

public class TxtReader extends Activity {
    /** Called when the activity is first created. */

    //重载Activity入口函数
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //设置按钮事件
        Button fileOpenBtn = (Button)findViewById(R.id.openFIleBtn);
        fileOpenBtn.setOnClickListener(new OpenFileAction());

    }

    //按钮动作:  窗口跳转 (Activity)  没有携带数据流的
    class OpenFileAction implements OnClickListener
    {
        public void onClick(View v) {
            Intent intentMain = new Intent(TxtReader.this, ListAllFileActivity.class);
            startActivityForResult(intentMain, 0);
        }
    }
}