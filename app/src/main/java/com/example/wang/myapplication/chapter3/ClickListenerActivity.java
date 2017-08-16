package com.example.wang.myapplication.chapter3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.wang.myapplication.R;

/**
 * Created by wang on 2017/8/15.
 */

public class ClickListenerActivity extends Activity{
    Button button;
    EditText editText;
    int count=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clicklistenerlayout);
        button=(Button)findViewById(R.id.click_btn);
        editText=(EditText)findViewById(R.id.click_text);
        button.setOnClickListener(new MyClickListener());
    }
    class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            editText.setText("按钮第"+(++count)+"次被点击");
        }
    }
}
