package com.example.test.lesson4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by fengjen on 2018/2/5.
 */

public class SecondActivity extends AppCompatActivity {
    private CheckBox chocolate_syrup;
    private CheckBox sprinkles;
    private CheckBox crushed_nuts;
    private CheckBox cherries;
    private CheckBox orio_cookie_crumbles;
    private Button btn1;
    private String message = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        chocolate_syrup = (CheckBox)findViewById(R.id.chocolate_syrup);
        sprinkles = (CheckBox)findViewById(R.id.sprinkles);
        crushed_nuts = (CheckBox)findViewById(R.id.crushed_nuts);
        cherries = (CheckBox)findViewById(R.id.cherries);
        orio_cookie_crumbles = (CheckBox)findViewById(R.id.orio_cookie_crumbles);

        chocolate_syrup.setOnCheckedChangeListener(chklistener);
        sprinkles.setOnCheckedChangeListener(chklistener);
        crushed_nuts.setOnCheckedChangeListener(chklistener);
        cherries.setOnCheckedChangeListener(chklistener);
        orio_cookie_crumbles.setOnCheckedChangeListener(chklistener);

        btn1 = (Button) findViewById(R.id.show_toast);
        btn1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Toppings："+ message,Toast.LENGTH_LONG).show();
            }
        });
    }

    private CheckBox.OnCheckedChangeListener chklistener = new CheckBox.OnCheckedChangeListener(){

        @Override
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {
            // TODO Auto-generated method stub
            int n = 0;
            String s1,s2,s3,s4,s5;

            if (chocolate_syrup.isChecked()){
                n++;
                s1 = chocolate_syrup.getText().toString();
            } else {
                s1 = "";
            }
            if (sprinkles.isChecked()){
                n++;
                s2 = sprinkles.getText().toString();
            } else    {
                s2= "";
            }
            if (crushed_nuts.isChecked()){
                n++;
                s3 = crushed_nuts.getText().toString();
            } else {
                s3="";
            }
            if (cherries.isChecked()){
                n++;
                s4 = cherries.getText().toString();
            } else {
                s4="";
            }
            if (orio_cookie_crumbles.isChecked()){
                n++;
                s5 = orio_cookie_crumbles.getText().toString();
            } else {
                s5="";
            }
            message = s1+" "+s2+" "+s3+" "+s4+" "+s5+" ";
            //Toast.makeText(getApplicationContext(),"Toppings："+s1+" "+s2+" "+s3+" "+s4+" "+s5+" ",Toast.LENGTH_LONG).show();
        }

    };
}