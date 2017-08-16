package com.example.wang.myapplication.chapter2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.wang.myapplication.R;

/**
 * Created by wang on 2017/8/8.
 */

public class CheckButton extends Activity{
    RadioGroup rg;
    TextView show;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbuttonlayout);
        rg=(RadioGroup)findViewById(R.id.rg);
        show=(TextView)findViewById(R.id.show);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                String tip= (checkedId==R.id.male?"您选择的性别是：男":"您选择的性别是：女");
                show.setText(tip);
            }
        });
    }
}
