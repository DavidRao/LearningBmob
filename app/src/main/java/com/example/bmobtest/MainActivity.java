package com.example.bmobtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this, "1bfc00caac31c7809a1a6f25d8c1396f");

        Person person = new Person();
        person.setName("Jenny");
        person.setAddress("England");

        BmobBasicHelper basicHelper = new BmobBasicHelper(MainActivity.this);
        //basicHelper.addData(person);

        /*
        BmobQuery<Person> query = new BmobQuery<>();
        query.getObject("f2bb1b36ac", new QueryListener<Person>() {
            @Override
            public void done(Person person, BmobException e) {
                if(e==null){
                    Toast.makeText(MainActivity.this, person.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
        */

        //person.setAddress("Japan");
        //basicHelper.updateData(person, "c9abdcf653");

        Person p = new Person();
        p.setObjectId("c9abdcf653");
        basicHelper.deleteData(p);
    }
}
