package com.example.test.lesson2_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

/**
 * Created by fengjen on 2018/2/1.
 */

public class SecondActivity extends Activity {

    public TextView tv = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        if (intent == null) {
            Log.d("123", "null");
        } else {
            Log.d("123", "sssssss");
        }
        int intValue = intent.getIntExtra("getSum", 0);
        Log.d("123", Integer.toString(intValue));

        tv=(TextView)findViewById(R.id.sum);
        tv.setText(Integer.toString(intValue));

        Button button1=(Button)findViewById(R.id.back);
        button1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                int message= Integer.parseInt(tv.getText().toString());
                Intent intent=new Intent();
                intent.putExtra("backSum",message);
                setResult(2,intent);
                finish();//finishing activity
            }
        });
    }
}
