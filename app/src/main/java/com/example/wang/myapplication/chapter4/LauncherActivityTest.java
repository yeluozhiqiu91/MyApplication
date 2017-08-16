package com.example.wang.myapplication.chapter4;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by wang on 2017/8/16.
 */

public class LauncherActivityTest extends LauncherActivity{
    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
    }

    @Override
    protected Intent intentForPosition(int position) {
        return super.intentForPosition(position);
    }
}
