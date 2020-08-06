package com.yxd.testmyprogressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.yxd.myprogressbar.MyProgressBar;

public class MainActivity extends AppCompatActivity {

    private MyProgressBar myProgressBar;
    private MyProgressBar myProgressBar2;
    private MyProgressBar myProgressBar3;
    private MyProgressBar myProgressBar4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myProgressBar = findViewById(R.id.mpb);
        myProgressBar.setProgress(95);

        myProgressBar2 = findViewById(R.id.mpb2);
        myProgressBar2.setProgress(80);

        myProgressBar3 = findViewById(R.id.mpb3);
        myProgressBar3.setProgress(50);

        myProgressBar4 = findViewById(R.id.mpb4);
        myProgressBar4.setProgress(75);
    }
}