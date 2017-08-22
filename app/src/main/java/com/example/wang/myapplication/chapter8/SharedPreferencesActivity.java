package com.example.wang.myapplication.chapter8;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.wang.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wang on 2017/8/22.
 */

public class SharedPreferencesActivity extends Activity{
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedpreference);
        preferences=getSharedPreferences("fkaz",MODE_PRIVATE);
        editor=preferences.edit();
        Button read=(Button)findViewById(R.id.read);
        Button write=(Button)findViewById(R.id.write);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=preferences.getString("time",null);
                int randNum=preferences.getInt("random",0);
                String result=time;
                if(result==null){
                    result="您暂时还未写入数据";
                }else{
                    result="写入时间为："+time+"\n上次生成随机数为："+randNum;
                }
                Toast.makeText(SharedPreferencesActivity.this,result,Toast.LENGTH_SHORT).show();
            }
        });
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                editor.putString("time",sf.format(new Date()));
                editor.putInt("random",(int)(Math.random()*100));
                editor.commit();
                Toast.makeText(SharedPreferencesActivity.this,"写入成功",Toast.LENGTH_SHORT).show();
                String time=preferences.getString("time",null);
                int randNum=preferences.getInt("random",0);
                System.out.println(time+"  "+randNum);
            }
        });
    }
}
