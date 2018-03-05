package com.example.test.lesson5hw;

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
import android.app.AlarmManager;
import android.util.Log;

/**
 * Created by fengjen on 2018/2/14.
 */

public class FourActivity extends AppCompatActivity {

    private static final int JOB_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        Button broadcastButton = (Button) findViewById(R.id.notificationButton);
        //onClick method for the button
        broadcastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotification();
            }
        });


        ComponentName serviceName = new ComponentName(getPackageName(),
                NotificationJobService.class.getName());


        JobInfo uploadTask = new JobInfo.Builder(JOB_ID, serviceName)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setRequiresDeviceIdle(true)
                .setRequiresCharging(true)
                .setPeriodic(AlarmManager.INTERVAL_DAY)
                .build();

        JobScheduler jobScheduler =
                (JobScheduler) this.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        jobScheduler.schedule(uploadTask);

    }

    private void sendNotification() {
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= 26)
        {
            //当sdk版本大于26
            String id = "channel_1";
            String description = "143";
            int importance = NotificationManager.IMPORTANCE_LOW;
            NotificationChannel channel = new NotificationChannel(id, description, importance);
//                     channel.enableLights(true);
//                     channel.enableVibration(true);//
            manager.createNotificationChannel(channel);
            Notification notification = new Notification.Builder(FourActivity.this, id)
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
            Notification notification = new NotificationCompat.Builder(FourActivity.this)
                    .setContentTitle("Performing Work")
                    .setContentText("Download in progress")
                    .setSmallIcon(R.drawable.ic_android)
                    .build();
            manager.notify(1,notification);
        }
    }

    public class NotificationJobService extends JobService {

        public NotificationJobService(){
            super();
        }

        /**
         * This is called by the system once it determines it is time to run the job.
         * @param jobParameters Contains the information about the job
         * @return Boolean indicating whether or not the job was offloaded to a separate thread.
         * In this case, it is false since the notification can be posted on the main thread.
         */
        @Override
        public boolean onStartJob(JobParameters jobParameters) {

            Log.e("123", "onStartJob");
            sendNotification();
            return false;
        }

        /**
         * Called by the system when the job is running but the conditions are no longer met.
         * In this example it is never called since the job is not offloaded to a different thread.
         * @param jobParameters Contains the information about the job
         * @return Boolean indicating whether the job needs rescheduling
         */
        @Override
        public boolean onStopJob(JobParameters jobParameters) {
            return true;
        }
/*
        private void doService() {
            JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
            JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(getPackageName(),
                    NotificationJobService.class.getName()));  //指定哪个JobService执行操作
            builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED);
            builder.setRequiresCharging(true);
            builder.setRequiresDeviceIdle(true);
            jobScheduler.schedule(builder.build());
        }
*/
    }
}
