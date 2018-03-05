package com.example.test.lesson2_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.net.Uri;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    private String phone_number = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView)findViewById(R.id.phone_number);
        phone_number = tv.getText().toString();
        tv.setOnClickListener(this);
    }

    public void onClick(View view) {
        Uri uri = Uri.parse("tel:"+phone_number);
        Intent it = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(it);
    }
}
