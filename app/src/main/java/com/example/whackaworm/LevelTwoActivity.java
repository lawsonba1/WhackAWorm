package com.example.whackaworm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LevelTwoActivity extends AppCompatActivity {
    TextView textView;
    ImageView[] wormImageViews = new ImageView[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);

        textView = findViewById(R.id.timerTextView);
        ImageView imageViewWorm1 = findViewById(R.id.imageViewWorm1);
        ImageView imageViewWorm2 = findViewById(R.id.imageViewWorm2);
        ImageView imageViewWorm3 = findViewById(R.id.imageViewWorm3);
        ImageView imageViewWorm4 = findViewById(R.id.imageViewWorm4);
        ImageView imageViewWorm5 = findViewById(R.id.imageViewWorm5);
        ImageView imageViewWorm6 = findViewById(R.id.imageViewWorm6);
        ImageView imageViewWorm7 = findViewById(R.id.imageViewWorm7);
        ImageView imageViewWorm8 = findViewById(R.id.imageViewWorm8);

        imageViewWorm1.setVisibility(View.INVISIBLE);
        imageViewWorm2.setVisibility(View.INVISIBLE);
        imageViewWorm3.setVisibility(View.INVISIBLE);
        imageViewWorm4.setVisibility(View.INVISIBLE);
        imageViewWorm5.setVisibility(View.INVISIBLE);
        imageViewWorm6.setVisibility(View.INVISIBLE);
        imageViewWorm7.setVisibility(View.INVISIBLE);
        imageViewWorm8.setVisibility(View.INVISIBLE);

        imageViewWorm1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(getApplicationContext(), "Worm 1 was Touched", Toast.LENGTH_SHORT).show();
                //Add the code to increment the score
                return false;
            }
        });
        imageViewWorm2.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(getApplicationContext(), "Worm 2 was Touched", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        imageViewWorm3.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(getApplicationContext(), "Worm 3 was Touched", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        imageViewWorm4.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(getApplicationContext(), "Worm 4 was Touched", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        imageViewWorm5.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(getApplicationContext(), "Worm 5 was Touched", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        imageViewWorm6.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(getApplicationContext(), "Worm 6 was Touched", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        imageViewWorm7.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(getApplicationContext(), "Worm 7 was Touched", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        imageViewWorm8.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(getApplicationContext(), "Worm 8 was Touched", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        wormImageViews[0] = imageViewWorm1;
        wormImageViews[1] = imageViewWorm2;
        wormImageViews[2] = imageViewWorm3;
        wormImageViews[3] = imageViewWorm4;
        wormImageViews[4] = imageViewWorm5;
        wormImageViews[5] = imageViewWorm6;
        wormImageViews[6] = imageViewWorm7;
        wormImageViews[7] = imageViewWorm8;

        /*
            1. Figure out how to end the level when the timer of 50 seconds has completed
            2. Add onTouch Listeners to all worm image views
         */
        //Make a worm appear and than disappear after 3 seconds
        CountDownTimer wormTimer = new CountDownTimer(3000, 3000) {
            //Declare a global variable here
            Random random = new Random();
            int randNum;

            public void onTick(long millisUntilFinished) {
                //Get the actual random value here
                randNum = random.nextInt(8);
                wormImageViews[randNum].setVisibility(View.VISIBLE);
            }

            public void onFinish() {
                wormImageViews[randNum].setVisibility(View.INVISIBLE);

                start();


            }
        }.start();

        CountDownTimer mainTimer = new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                long sec = millisUntilFinished / 1000;
                textView.setText(sec+"");
            }
            // When the task is over it will print 00:00:00 there
            public void onFinish() {
                wormTimer.cancel();
                textView.setText("0");
            }
        }.start();



    }
}