package com.example.bmobtest;

import android.content.Context;
import android.widget.Toast;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class BmobBasicHelper{
    public <T extends BmobObject, C extends Context> void addData(C context, T t){
        t.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(e!=null){
                    Toast.makeText(context,
                            e.getMessage(), Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(context,
                            "Insert Data successfully!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
