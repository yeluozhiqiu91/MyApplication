package com.example.wang.myapplication.chapter2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.example.wang.myapplication.R;

/**
 * Created by wang on 2017/8/8.
 */

public class ToggleButtonActivity extends Activity{
    ToggleButton toggleButton;
    Switch aSwitch;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.togglebuttonlayout);
        toggleButton=(ToggleButton) findViewById(R.id.toggle);
        aSwitch=(Switch)findViewById(R.id.switcher);
        final LinearLayout test= (LinearLayout) findViewById(R.id.test);
        CompoundButton.OnCheckedChangeListener listener= new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    test.setOrientation(LinearLayout.HORIZONTAL);//水平布局
                    toggleButton.setChecked(true);
                    aSwitch.setChecked(true);
                }else{
                    test.setOrientation(LinearLayout.VERTICAL);//垂直布局
                    toggleButton.setChecked(false);
                    aSwitch.setChecked(false);
                }
            }
        };
        toggleButton.setOnCheckedChangeListener(listener);
        aSwitch.setOnCheckedChangeListener(listener);
    }
}
