package com.example.wang.myapplication.chapter3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.example.wang.myapplication.R;

/**
 * Created by wang on 2017/8/15.
 */

public class EventSpreadActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplebuttonlayout);
        MyButton bn=(MyButton)findViewById(R.id.bn);
        bn.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction()==KeyEvent.ACTION_DOWN){
                    Log.v("-MyButton-","按钮监听被点击");
                    System.out.println("按钮被按下了");
                }
                return false;
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        super.onKeyDown(keyCode, event);
        Log.v("-Acivity-","the onKeyDown in Activity");
        return false;
    }
}
