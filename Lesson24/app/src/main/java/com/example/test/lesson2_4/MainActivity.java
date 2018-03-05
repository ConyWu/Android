package com.example.test.lesson2_4;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private EditText txt1;
    private EditText txt2;
    //public static final String EXTRA_MESSAGE_KEY = "com.example.test.lesson2_4.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.sum);
        txt1 = (EditText) findViewById(R.id.number1);
        txt2 = (EditText) findViewById(R.id.number2);

        btn1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number1 = Integer.parseInt(txt1.getText().toString());
                int number2 = Integer.parseInt(txt2.getText().toString());
                int sum = getSum(number1, number2);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("getSum", sum);
                Log.d("123456", Integer.toString(sum));
                startActivityForResult(intent, 2);
            }
        });
    }

    private int getSum(int number1, int number2){
        return number1+number2;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(resultCode==2)
        {
            int reply = data.getIntExtra("backSum", 0);
            Log.d("123456", Integer.toString(reply));
            Toast.makeText(this, Integer.toString(reply),
                    Toast.LENGTH_LONG).show();
        }
    }

}
