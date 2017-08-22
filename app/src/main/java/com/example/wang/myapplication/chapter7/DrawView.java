package com.example.wang.myapplication.chapter7;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.wang.myapplication.R;

/**
 * Created by wang on 2017/8/22.
 */

public class DrawView extends View{
    float preX;
    float preY;
    private Path path;
    public Paint paint=null;
    Bitmap cacheBitmap=null;
    Canvas canvas=null;

    public DrawView(Context context,int width,int height) {
        super(context);
        cacheBitmap=Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);
        canvas=new Canvas();
        path=new Path();
        canvas.setBitmap(cacheBitmap);
        paint=new Paint(Paint.DITHER_FLAG);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        paint.setAntiAlias(true);
        paint.setDither(true);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x=event.getX();
        float y=event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                preX=x;
                preY=y;
                break;
            case MotionEvent.ACTION_MOVE:
                path.quadTo(preX,preY,x,y);
                preX=x;
                preY=y;
                break;
            case MotionEvent.ACTION_UP:
                canvas.drawPath(path,paint);
                path.reset();
                break;
        }
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint bmpPaint=new Paint();
        canvas.drawBitmap(cacheBitmap,0,0,bmpPaint);
        canvas.drawPath(path,paint);
    }
}
