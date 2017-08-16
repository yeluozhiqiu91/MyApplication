package com.example.wang.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by wang on 2017/8/2.
 */

public class FrameLayoutActivity extends Activity{
    private int currentColor = 0;
    final int[] colors={
            R.color.colorRed,
            R.color.colorOrange,
            R.color.colorYellow,
            R.color.colorGreen,
            R.color.colorCyan,
            R.color.colorBlue,
            R.color.colorPurple
    };
    final int[] names={
            R.id.view01,
            R.id.view02,
            R.id.view03,
            R.id.view04,
            R.id.view05,
            R.id.view06,
            R.id.view07,
    };

    TextView[] views=new TextView[names.length];
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==0x125){
                for(int i=0;i<names.length;i++){
                    views[i].setBackgroundResource(colors[(i+currentColor)%names.length]);
                }
                currentColor++;
                super.handleMessage(msg);
            }

        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.framelayout);
        for(int i=0;i<names.length;i++){
            views[i]=(TextView)findViewById(names[i]);
        }
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x125);
            }
        },0,500);
    }
}
