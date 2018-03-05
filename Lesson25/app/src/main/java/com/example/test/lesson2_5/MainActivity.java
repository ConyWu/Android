package com.example.test.lesson2_5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private Button button = null;
    private EditText et = null;
    private TextView tv = null;
    private String mEditText = null;
    private String mTextView = null;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textCount);
        et = (EditText) findViewById(R.id.editText);
        button = (Button)findViewById(R.id.increase);

        if (savedInstanceState != null) {
            String text = savedInstanceState.getString("textview");
            String edit = savedInstanceState.getString("edittext");
            if (tv != null)
                tv.setText(text);
            if (et != null)
                et.setText(edit);

        }


        button.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                String sCount = Integer.toString(Integer.parseInt(tv.getText().toString())+1);
                tv.setText(sCount);
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Add information for saving HelloToast counter
        // to the to the outState bundle
        outState.putString("textview", String.valueOf(tv.getText()));
        outState.putString("edittext", String.valueOf(et.getText()));
    }
/*
    @Override
    public void onRestoreInstanceState (Bundle mySavedState) {
        super.onRestoreInstanceState(mySavedState);

        if (mySavedState != null) {
            String text = mySavedState.getString("textview");
            String edit = mySavedState.getString("edittext");
            if (tv != null)
                tv.setText(text);
            if (et != null)
                et.setText(edit);

        }
    }
*/

}
