package com.example.wang.myapplication.chapter2;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wang.myapplication.R;

/**
 * Created by wang on 2017/8/15.
 */

public class BaseAdapterActivity extends Activity{

    ListView myList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baseadapterlayout);
        myList=(ListView)findViewById(R.id.myList);
        BaseAdapter baseAdapter=new BaseAdapter() {
            @Override
            public int getCount() {
                return 40;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LinearLayout linearLayout=new LinearLayout(BaseAdapterActivity.this);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                ImageView image=new ImageView(BaseAdapterActivity.this);
                image.setImageResource(R.drawable.java);
                TextView textView=new TextView(BaseAdapterActivity.this);
                textView.setText("第"+(position+1)+"个列表项");
                textView.setTextSize(20);
                textView.setTextColor(Color.GREEN);
                linearLayout.addView(image);
                linearLayout.addView(textView);
                return linearLayout;
            }
        };
        myList.setAdapter(baseAdapter);
    }
}
