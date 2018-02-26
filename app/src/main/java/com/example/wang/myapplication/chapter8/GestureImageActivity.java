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
import android.widget.ImageView;

import com.example.wang.myapplication.R;

/**
 * Created by wang on 2018/2/26.
 * 通过手势放大或缩小图片，从左向右滑动放大图片，从右向左缩小图片
 */

public class GestureImageActivity extends Activity implements GestureDetector.OnGestureListener{
    GestureDetector detector;
    ImageView imageView;
    Bitmap bitmap;
    int width,height;
    float currentScale=1;
    Matrix matrix;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gestureimage);
        detector=new GestureDetector(this,this);
        imageView= (ImageView) findViewById(R.id.show);
        matrix=new Matrix();
        bitmap= BitmapFactory.decodeResource(this.getResources(),R.drawable.java);
        width=bitmap.getWidth();
        height=bitmap.getHeight();
        imageView.setImageBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.java));
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
        velocityX=velocityX>4000? 4000:velocityX;
        velocityX=velocityX<-4000? -4000:velocityX;
        currentScale +=currentScale*velocityX/4000.0f;
        currentScale +=currentScale>0.01f? currentScale:0.01f;
        matrix.reset();
        matrix.setScale(currentScale,currentScale,160,200);
        BitmapDrawable tmp=(BitmapDrawable)imageView.getDrawable();
        if(!tmp.getBitmap().isRecycled()){
            tmp.getBitmap().recycle();
        }
        Bitmap bitmap2=Bitmap.createBitmap(bitmap,0,0,width,height,matrix,true);
        imageView.setImageBitmap(bitmap2);
        return true;
    }

}
