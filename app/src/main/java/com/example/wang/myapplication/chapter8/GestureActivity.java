package com.example.wang.myapplication.chapter8;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import com.example.wang.myapplication.R;

/**
 * Created by wang on 2018/2/26.
 * 简单手势
 */

public class GestureActivity extends Activity implements GestureDetector.OnGestureListener{
    GestureDetector detector;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gesture);
        detector=new GestureDetector(this,this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        Toast.makeText(this,"onDown",Toast.LENGTH_LONG).show();
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Toast.makeText(this,"onShowPress",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Toast.makeText(this,"onSingleTapUp",Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Toast.makeText(this,"onScroll",Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Toast.makeText(this,"onLongPress",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Toast.makeText(this,"onFling",Toast.LENGTH_SHORT).show();
        return false;
    }

}
