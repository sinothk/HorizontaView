package com.sinothk.view.horizontalView.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HorizontalView horizontalView = findViewById(R.id.horizontalView);
        horizontalView.initView(this);

    }
}
