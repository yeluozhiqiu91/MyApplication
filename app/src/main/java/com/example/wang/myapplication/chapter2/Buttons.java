package com.example.wang.myapplication.chapter2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.wang.myapplication.R;

/**
 * Created by wang on 2017/8/8.
 */

public class Buttons extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttonslayout);
    }
}
