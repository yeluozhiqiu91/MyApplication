package com.example.wang.myapplication.chapter2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.wang.myapplication.R;

/**
 * Created by wang on 2017/8/8.
 */

public class ArrayAdapterActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arrayadapterlayout);
        ListView list1=(ListView)findViewById(R.id.list1);
        String[] arr1={"孙猴子","猪八戒","沙僧"};
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,R.layout.array_item,arr1);
        list1.setAdapter(adapter1);

        ListView list2=(ListView)findViewById(R.id.list2);
        String[] arr2={"JAVA","C++","PYTHON"};
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this,R.layout.array_item,arr2);
        list2.setAdapter(adapter2);
    }
}
