package com.example.my;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;
import android.view.View;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class job_scadular extends JobService {

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        NotificationManagerCompat notificationManagerCompat;
        Notification notification;

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("myCh" , "My Channel" , NotificationManager.IMPORTANCE_DEFAULT); // creat channel
            NotificationManager manager = getSystemService(NotificationManager.class); // create mannager
            manager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "myCh")
                .setSmallIcon(R.drawable.icon_notification)
                .setContentTitle("Welcome to DUA ELABRABR")
                .setContentText("Pray to Allah with a humble heart, may Allah will forgive us and accept our dua ")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        notification = builder.build();
        notificationManagerCompat=NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1,notification);

        // Job is complete
        jobFinished(jobParameters, false);

        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
