package com.example.wang.myapplication.chapter3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.wang.myapplication.R;

/**
 * Created by wang on 2017/8/15.
 * 通过键盘上的WASD控制飞机移动
 */

public class PlaneActivity extends Activity{
    private int speed=10;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final PlaneView planeView=new PlaneView(this);
        setContentView(planeView);
        planeView.setBackgroundResource(R.drawable.sky_back);
        WindowManager windowManager=getWindowManager();
        Display display=windowManager.getDefaultDisplay();
        DisplayMetrics metrics=new DisplayMetrics();
        display.getMetrics(metrics);
        planeView.currentX=metrics.widthPixels/2-50;
        planeView.currentY=metrics.heightPixels-120;
        planeView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                switch (event.getKeyCode()){
                    case KeyEvent.KEYCODE_S:
                        planeView.currentY+=speed;
                        break;
                    case KeyEvent.KEYCODE_W:
                        planeView.currentY-=speed;
                        break;
                    case KeyEvent.KEYCODE_A:
                        planeView.currentX-=speed;
                        break;
                    case KeyEvent.KEYCODE_D:
                        planeView.currentX+=speed;
                        break;
                }
                planeView.invalidate();//重新绘制
                return true;
            }
        });
    }
}
