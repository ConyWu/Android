package com.example.test.lesson3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;

/**
 * Created by fengjen on 2018/2/5.
 */

public class SecondActivity extends Activity {
    private Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        /*int a=0;
        while(true) {
            a++;
        }*/
        btn1 = (Button) findViewById(R.id.l3_1_1);
        btn1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    Log.e("Test", "", e);
                }
            }
        });
    }
}
