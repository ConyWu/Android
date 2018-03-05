package com.example.test.mytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    public static final Pattern EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isValidEmail("test@mail.com");
    }

    public static boolean isValidEmail(CharSequence email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
}
