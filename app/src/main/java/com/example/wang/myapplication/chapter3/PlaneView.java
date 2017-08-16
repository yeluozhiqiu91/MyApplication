package com.example.wang.myapplication.chapter3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.example.wang.myapplication.R;

/**
 * Created by wang on 2017/8/15.
 */

public class PlaneView extends View{
    public float currentX;
    public float currentY;
    Bitmap plane;
    public PlaneView(Context context) {
        super(context);
        plane= BitmapFactory.decodeResource(context.getResources(), R.drawable.plane);
        setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p=new Paint();
        canvas.drawBitmap(plane,currentX,currentY,p);
    }
}
