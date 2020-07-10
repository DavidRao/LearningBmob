package com.example.bmobtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this, "1bfc00caac31c7809a1a6f25d8c1396f");

        Person person = new Person();
        person.setName("David");
        person.setAddress("China");
        person.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(e!=null){
                    Toast.makeText(MainActivity.this,
                            e.getMessage(), Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,
                            "Insert Data successfully!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
