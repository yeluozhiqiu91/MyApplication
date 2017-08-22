package com.example.wang.myapplication.chapter7;

import android.app.Activity;
import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.wang.myapplication.R;

/**
 * Created by wang on 2017/8/22.
 */

public class DoubleBufferDrawActivity extends Activity{
    EmbossMaskFilter emboss;
    BlurMaskFilter blur;
    DrawView drawView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout=new LinearLayout(this);
        DisplayMetrics displayMetrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        drawView=new DrawView(this,displayMetrics.widthPixels,displayMetrics.heightPixels);
        linearLayout.addView(drawView);
        setContentView(linearLayout);
        emboss=new EmbossMaskFilter(new float[]{1.5f,1.5f,1.5f},0.6f,6,4.2f);
        blur=new BlurMaskFilter(8,BlurMaskFilter.Blur.NORMAL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=new MenuInflater(this);
        inflater.inflate(R.menu.draw_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.red:
                drawView.paint.setColor(Color.RED);
                item.setChecked(true);
                break;
            case R.id.green:
                drawView.paint.setColor(Color.GREEN);
                item.setChecked(true);
                break;
            case R.id.blue:
                drawView.paint.setColor(Color.BLUE);
                item.setChecked(true);
                break;
            case R.id.width_1:
                drawView.paint.setStrokeWidth(1);
                item.setChecked(true);
                break;
            case R.id.width_3:
                drawView.paint.setStrokeWidth(3);
                item.setChecked(true);
                break;
            case R.id.width_5:
                drawView.paint.setStrokeWidth(5);
                item.setChecked(true);
                break;
            case R.id.blur:
                drawView.paint.setMaskFilter(blur);
                item.setChecked(true);
                break;
            case R.id.emboss:
                drawView.paint.setMaskFilter(emboss);
                item.setChecked(true);
                break;
        }
        return true;
    }
}
