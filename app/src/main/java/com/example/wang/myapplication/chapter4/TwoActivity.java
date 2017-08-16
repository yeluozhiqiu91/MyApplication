package com.example.wang.myapplication.chapter4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.wang.myapplication.R;

/**
 * Created by wang on 2017/8/16.
 */

public class TwoActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twoactivity);
        Button button= (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username=(EditText)findViewById(R.id.username);
                EditText password=(EditText)findViewById(R.id.password);
                RadioButton male=(RadioButton)findViewById(R.id.male);
                String gender=male.isChecked()?"男":"女";
                Person p=new Person(username.getText().toString(),password.getText().toString(),gender);
                Bundle data=new Bundle();
                data.putSerializable("person",p);
                Intent intent=new Intent(TwoActivity.this,ResultActivity.class);
                intent.putExtras(data);
                startActivity(intent);
            }
        });
    }
}
