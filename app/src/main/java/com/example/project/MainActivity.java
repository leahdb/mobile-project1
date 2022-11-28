package com.example.project;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatButton btn1 = findViewById(R.id.btngame1);
        AppCompatButton btn2 = findViewById(R.id.btngame2);

        btn1.setOnClickListener(view -> {

            Intent intent1 = new Intent(MainActivity.this, Game1.class);
            startActivity(intent1);
        });

        btn2.setOnClickListener(view -> {
            Intent intent2 = new Intent(MainActivity.this, Game2.class);
            startActivity(intent2);
        });

    }


}