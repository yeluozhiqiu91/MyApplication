package com.example.wang.myapplication.chapter4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.wang.myapplication.R;

/**
 * Created by wang on 2017/8/16.
 */

public class TwoReturnResultActivityTest extends Activity{
    Button btn;
    EditText city;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.returnresult);
        btn=(Button)findViewById(R.id.btn);
        city=(EditText)findViewById(R.id.city);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TwoReturnResultActivityTest.this,SelectCityActivity.class);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==0&&requestCode==0){
            Bundle bundle=data.getExtras();
            String resultCity=bundle.getString("city");
            city.setText(resultCity);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
