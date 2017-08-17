package com.example.wang.myapplication.chapter5;

import android.app.Activity;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.wang.myapplication.R;

/**
 * Created by wang on 2017/8/17.
 * 这个程序有问题，选择某个联系人时会报错，已经配置了权限，但还是报错，不知道什么问题
 */

public class ContacterActivity extends Activity{
    final int PICK_CONTACT=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
        Button button=(Button)findViewById(R.id.viewContacter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("vnd.android.cursor.item/phone");
                startActivityForResult(intent,PICK_CONTACT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case PICK_CONTACT:
                if(resultCode==Activity.RESULT_OK){
                    Uri contactData=data.getData();
                    CursorLoader cursorLoader=new CursorLoader(this,contactData,null,null,null,null);
                    Cursor cursor=cursorLoader.loadInBackground();
                    if(cursor.moveToFirst()){
                        String contactId=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                        String name=cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));
                        String phoneNumber="此联系人暂未输入电话号码";
                        Cursor phones=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"="+contactId,null,null);
                        if(phones.moveToFirst()){
                            phoneNumber=phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        }
                        phones.close();
                        EditText contactername=(EditText)findViewById(R.id.contactername);
                        contactername.setText(name);
                        EditText contactnumber=(EditText)findViewById(R.id.contacternumber);
                        contactnumber.setText(phoneNumber);
                    }
                    cursor.close();
                }
                break;
        }
    }
}
