package com.example.wang.myapplication.chapter8;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.wang.myapplication.R;

/**
 * Created by wang on 2018/2/26.
 * 通过手势翻页
 */

public class GesturePageActivity extends Activity implements GestureDetector.OnGestureListener{
    ViewFlipper flipper;
    GestureDetector detector;
    Animation[] animations=new Animation[4];
    final int FLIP_DISTANCE=50;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gesturepage);
        detector=new GestureDetector(this,this);
        flipper= (ViewFlipper) findViewById(R.id.flipper);
        flipper.addView(addImageView(R.drawable.java));
        flipper.addView(addImageView(R.drawable.ajax));
        flipper.addView(addImageView(R.drawable.html));
        flipper.addView(addImageView(R.drawable.javaee));
        animations[0]= AnimationUtils.loadAnimation(this,R.anim.left_in);
        animations[1]= AnimationUtils.loadAnimation(this,R.anim.left_out);
        animations[2]= AnimationUtils.loadAnimation(this,R.anim.right_in);
        animations[3]= AnimationUtils.loadAnimation(this,R.anim.right_out);
    }

    private View addImageView(int resId){
        ImageView imageView=new ImageView(this);
        imageView.setImageResource(resId);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        return imageView;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if(e1.getX()-e2.getX()>FLIP_DISTANCE){
            flipper.setInAnimation(animations[2]);
            flipper.setOutAnimation(animations[1]);
            flipper.showPrevious();
            return true;
        }else if(e2.getX()-e1.getX()>FLIP_DISTANCE){
            flipper.setInAnimation(animations[0]);
            flipper.setOutAnimation(animations[3]);
            flipper.showNext();
            return true;
        }
        return false;
    }

}
