package com.example.wang.myapplication.chapter5;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;

import com.example.wang.myapplication.R;

/**
 * Created by wang on 2017/8/17.
 */

public class StartSystemActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startsystem);
        Button bn=(Button)findViewById(R.id.bn1);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                String data="http://www.baidu.com";
                Uri uri= Uri.parse(data);
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(uri);
                startActivity(intent);
            }
        });

        Button edit=(Button)findViewById(R.id.bn2);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_EDIT);
                String data="content://com.android.contacts/contacts/1";//编辑第一个联系人（我猜测是编辑第一个添加的联系人）
                Uri uri=Uri.parse(data);
                intent.setData(uri);
                startActivity(intent);
            }
        });

        Button call=(Button)findViewById(R.id.bn3);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_CALL);
                String data="tel:18520712585";
                Uri uri=Uri.parse(data);
                intent.setData(uri);
                int checkPermission = ContextCompat.checkSelfPermission(StartSystemActivity.this, Manifest.permission.CALL_PHONE);
                if (checkPermission != PackageManager.PERMISSION_GRANTED) {
                        //ActivityCompat.requestPermissions(StartSystemActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 0);
                    showDialogTipUserRequestPermission();

                } else {
                    startActivity(intent);
                }

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 0:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    System.out.println("有权限了");
                    Intent intent=new Intent();
                    intent.setAction(Intent.ACTION_CALL);
                    String data="tel:18520712585";
                    Uri uri=Uri.parse(data);
                    intent.setData(uri);
                    startActivity(intent);
                }else{
                    System.out.println("还是没有权限");
                }
                return;
        }
    }
    private void showDialogTipUserRequestPermission(){
        new AlertDialog.Builder(this).setTitle("获取联系人权限不可用").setMessage("需要获取联系人权限，否则无法正常使用该程序").setPositiveButton("立即开启", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startRequestPermission();
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        }).setCancelable(false).show();
    }

    // 开始提交请求权限
    private void startRequestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 0);
    }
}
