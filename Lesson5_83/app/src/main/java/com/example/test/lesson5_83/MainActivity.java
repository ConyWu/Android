package com.example.test.lesson5_83;

import android.app.AlarmManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.app.NotificationChannel;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;

/**
 * Created by fengjen on 2018/2/14.
 */

public class MainActivity extends AppCompatActivity {

    private static final int JOB_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button broadcastButton = (Button) findViewById(R.id.notificationButton);
        //onClick method for the button
        broadcastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotification();
            }
        });

/*
        ComponentName serviceName = new ComponentName(getPackageName(),
                NotificationJobService.class.getName());


        JobInfo uploadTask = new JobInfo.Builder(JOB_ID, serviceName)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setRequiresDeviceIdle(true)
                .setRequiresCharging(true)
                .build();


        JobScheduler jobScheduler =
                (JobScheduler) this.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        jobScheduler.schedule(uploadTask);
*/
/*
        ComponentName serviceName = new ComponentName(getPackageName(),
                NotificationJobService.class.getName());
        JobInfo.Builder builder = new JobInfo.Builder(JOB_ID, serviceName)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setRequiresDeviceIdle(true)
                .setRequiresCharging(true);
        builder.setPeriodic(1000);
*/
        JobInfo.Builder builder = new JobInfo.Builder(1,
                new ComponentName(getPackageName(),
                        NotificationJobService.class.getName()));

        builder.setPeriodic(3000);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        //builder.setPeriodic(3000);//AlarmManager.INTERVAL_FIFTEEN_MINUTES);

        JobInfo myJobInfo = builder.build();
        JobScheduler jobScheduler =  (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        jobScheduler.schedule(myJobInfo);


    }

    public void sendNotification() {
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= 26)
        {
            //当sdk版本大于26
            String id = "channel_1";
            String description = "143";
            int importance = NotificationManager.IMPORTANCE_LOW;
            NotificationChannel channel = new NotificationChannel(id, description, importance);

            manager.createNotificationChannel(channel);
            Notification notification = new Notification.Builder(MainActivity.this, id)
                    .setCategory(Notification.CATEGORY_MESSAGE)
                    .setSmallIcon(R.drawable.ic_android)
                    .setContentTitle("Performing Work")
                    .setContentText("Download in progress")
                    .setAutoCancel(true)
                    .build();
            manager.notify(1, notification);
        }
        else
        {
            //当sdk版本小于26
            Notification notification = new NotificationCompat.Builder(MainActivity.this)
                    .setContentTitle("Performing Work")
                    .setContentText("Download in progress")
                    .setSmallIcon(R.drawable.ic_android)
                    .build();
            manager.notify(1,notification);
        }
    }

    public abstract class NotificationJobService extends JobService {

        NotificationJobService(){
            super();
        }

        @Override
        public boolean onStartJob(JobParameters jobParameters) {
            Log.e("test", "onStartJob");
            sendNotification();
            return false;
        }


        @Override
        public boolean onStopJob(JobParameters jobParameters) {
            return true;
        }

    }

}
