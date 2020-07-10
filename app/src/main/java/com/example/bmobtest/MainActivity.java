package com.example.bmobtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this, "1bfc00caac31c7809a1a6f25d8c1396f");
    }
}
