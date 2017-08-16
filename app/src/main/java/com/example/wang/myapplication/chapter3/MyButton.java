package com.example.wang.myapplication.chapter3;


import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Button;

import com.example.wang.myapplication.chapter2.Buttons;

/**
 * Created by wang on 2017/8/15.
 */

public class MyButton extends Button{

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        super.onKeyDown(keyCode, event);
        Log.v("-Acivity-","the onKeyDown in Button");
        return false;
    }
}
