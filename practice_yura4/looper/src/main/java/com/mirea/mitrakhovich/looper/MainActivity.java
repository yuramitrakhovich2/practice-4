package com.example.looper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MyLooper myLooper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLooper = new MyLooper();
        myLooper.start();
    }

    public void onClick(View view){
        Message msg = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("work", "mirea");
        bundle.putString("salary", "-176000");
        msg.setData(bundle);
        if (myLooper != null) {
            myLooper.handler.sendMessage(msg);
        }
    }
}