package com.example.wang.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;

/**
 * Created by wang on 2017/8/1.
 */

public class CustomViewActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom);
        LinearLayout linearLayout= (LinearLayout) findViewById(R.id.root);
        final DrawView drawView=new DrawView(this);
        drawView.setMinimumWidth(300);
        drawView.setMinimumHeight(500);
        linearLayout.addView(drawView);
    }
}
