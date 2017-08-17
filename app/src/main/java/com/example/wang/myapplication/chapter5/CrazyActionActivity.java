package com.example.wang.myapplication.chapter5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.wang.myapplication.R;

/**
 * Created by wang on 2017/8/17.
 */

public class CrazyActionActivity extends Activity{
    public final static String CRAZY_ACTION="org.wang.intent.crazy_action";
    public final static String CRAZY_CATEGORY="org.wang.intent.crazy_category";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crazy);
        Button button=(Button)findViewById(R.id.crazy);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction(CRAZY_ACTION);
                /*intent.addCategory(CRAZY_CATEGORY);*/
                startActivity(intent);
            }
        });
    }
}
