package com.example.kosta.broadcastexam01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView number = (TextView)findViewById(R.id.phoneNumber);
        TextView message = (TextView)findViewById(R.id.message);

        Intent i = getIntent();
        number.setText(i.getStringExtra("phone"));
        message.setText(i.getStringExtra("message"));
    }
}
