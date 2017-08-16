package com.example.wang.myapplication.chapter2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.QuickContactBadge;

import com.example.wang.myapplication.R;

/**
 * Created by wang on 2017/8/8.
 */

public class QuickContactActivity extends Activity{
    QuickContactBadge badge;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quickcontactlayout);
        badge=(QuickContactBadge)findViewById(R.id.badge);
        badge.assignContactFromPhone("020-88888888",false);
    }
}
