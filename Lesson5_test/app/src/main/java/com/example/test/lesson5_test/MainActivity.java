package com.example.test.lesson5_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.content.LocalBroadcastManager;

/**
 * Created by fengjen on 2018/2/9.
 */

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private int count = 0;
    private CustomReceiver mReceiver = new CustomReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.textView2);


        //Use LocalBroadcastManager so that the broadcast is not received by other applications.
        /*LocalBroadcastManager.getInstance(this).registerReceiver
                (mReceiver, new IntentFilter(CustomReceiver.ACTION_CUSTOM_BROADCAST));

        LocalBroadcastManager.getInstance(this).registerReceiver
                (mReceiver, new IntentFilter(Intent.ACTION_POWER_CONNECTED));

        LocalBroadcastManager.getInstance(this).registerReceiver
                (mReceiver, new IntentFilter(Intent.ACTION_POWER_DISCONNECTED));
                */
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        registerReceiver(mReceiver, filter);

        //IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        //Intent batteryStatus = this.registerReceiver(null, ifilter);
    }


    class CustomReceiver extends BroadcastReceiver {

        //String constant that defines the custom Broadcast Action
        static final String ACTION_CUSTOM_BROADCAST =
                "com.example.android.powerreceiver.ACTION_CUSTOM_BROADCAST";


        //Empty constructor
        public CustomReceiver() {
        }


        /**
         * This method gets called when the Broadcast Receiver receives a broadcast that
         * it is registered for.
         *
         * @param context The context of the application when the broadcast is received.
         * @param intent The broadcast is delivered in the form of an intent which contains
         *               the broadcast action.
         */
        @Override
        public void onReceive(Context context, Intent intent) {
            String intentAction = intent.getAction();
            String toastMessage = null;
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    count = count+1;
                    //toastMessage = context.getString(R.string.power_connected);
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    count = count+1;
                    //toastMessage = context.getString(R.string.power_disconnected);
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    count = count+1;
                    //toastMessage = context.getString(R.string.custom_broadcast_toast);
                    break;
            }
            mTextView.setText(Integer.toString(count));
            //Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}
