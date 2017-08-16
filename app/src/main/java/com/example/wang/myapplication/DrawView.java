package com.example.wang.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by wang on 2017/8/1.
 */

public class DrawView extends View{
    public float currentX=40;
    public float currentY=50;
    Paint p=new Paint();
    public DrawView(Context context) {
        super(context);
    }
    public DrawView(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }
    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        p.setColor(Color.GREEN);
        canvas.drawCircle(currentX,currentY,35,p);
    }

    public boolean onTouchEvent(MotionEvent motionEvent){
        currentX=motionEvent.getX();
        currentY=motionEvent.getY();
        invalidate();
        return true;
    }
}
