package com.example.wang.myapplication.chapter8;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by wang on 2017/8/22.
 * 计算程序启动次数
 */

public class CountUsedTimes extends Activity{
    SharedPreferences preferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences=getSharedPreferences("co",MODE_PRIVATE);
        int count=preferences.getInt("count",1);
        Toast.makeText(CountUsedTimes.this,"程序被使用了："+count+"次",Toast.LENGTH_LONG).show();
        SharedPreferences.Editor editor=preferences.edit();
        editor.putInt("count",++count);
        editor.commit();
    }
}
