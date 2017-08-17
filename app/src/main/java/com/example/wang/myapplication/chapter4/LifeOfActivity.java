package com.example.wang.myapplication.chapter4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.wang.myapplication.R;

/**
 * Created by wang on 2017/8/16.
 */

public class LifeOfActivity extends Activity{
    Button startBtn,finishBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lifeofactivity);
        finishBtn=(Button)findViewById(R.id.btn2);
        startBtn=(Button)findViewById(R.id.btn1);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LifeOfActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LifeOfActivity.this.finish();
            }
        });
    }

    @Override
    protected void onStart() {
        System.out.println("启动了啊");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        System.out.println("重新启动了啊");
        super.onRestart();
    }

    @Override
    protected void onPause() {
        System.out.println("暂停了啊");
        super.onPause();
    }

    @Override
    protected void onStop() {
        System.out.println("停止了啊");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        System.out.println("销毁了啊");
        super.onDestroy();
    }
}
