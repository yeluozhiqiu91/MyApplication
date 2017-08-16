package com.example.wang.myapplication.chapter4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.wang.myapplication.R;

/**
 * Created by wang on 2017/8/16.
 */

public class ResultActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        TextView username=(TextView)findViewById(R.id.username);
        TextView password=(TextView)findViewById(R.id.password);
        TextView gender=(TextView)findViewById(R.id.gender);
        Intent intent=getIntent();
        Person p= (Person) intent.getSerializableExtra("person");
        username.setText("您的姓名为："+p.getUsername());
        password.setText("您的密码为："+p.getPassword());
        gender.setText("您的性别为："+p.getGender());
    }
}
