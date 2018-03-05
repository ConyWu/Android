package com.example.test.lesson4;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.view.ViewTreeObserver;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.view.View;
import android.content.Intent;
import android.util.Log;

/**
 * Created by fengjen on 2018/2/6.
 */

public class FourthActivity extends AppCompatActivity {
    ImageButton iButton1;
    ImageButton iButton2;
    ImageButton iButton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        iButton1 = (ImageButton)findViewById(R.id.image_button1);

        //Setting up on click event function on image button.
        iButton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.w("myApp", "4-1");
                Intent intent = new Intent(FourthActivity.this, SecondoneActivity.class);
                startActivity(intent);

            }
        });

        iButton2 = (ImageButton)findViewById(R.id.image_button2);

        //Setting up on click event function on image button.
        iButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.w("myApp", "4-2");
                Intent intent = new Intent(FourthActivity.this, SecondtwoActivity.class);
                startActivity(intent);

            }
        });

        iButton3 = (ImageButton)findViewById(R.id.image_button3);

        //Setting up on click event function on image button.
        iButton3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.w("myApp", "4-3");
                Intent intent = new Intent(FourthActivity.this, SecondthreeActivity.class);
                startActivity(intent);

            }
        });

    }

}
