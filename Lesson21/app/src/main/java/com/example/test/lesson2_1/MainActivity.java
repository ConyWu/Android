package com.example.test.lesson2_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        // The activity is about to become visible.
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        // The activity is between stopped and started.
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        // The activity has become visible
        // it is now "resumed"
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus
        // this activity is about to be "paused"
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible
        // it is now "stopped"
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // The activity is about to be destroyed.
        Log.d(TAG, "onDestroy");
    }

}
