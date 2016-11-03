package com.jackzc.jacknotifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder builder;
    private static final int UNIQUE_ID = 456128;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        builder = new NotificationCompat.Builder(this);
        builder.setAutoCancel(true);

    }

    public void generateNotification(View view) {

        // Build the notification
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setTicker("This is Jack's Ticker");
        builder.setWhen(System.currentTimeMillis());
        builder.setContentTitle("Here is the Jack's Title");
        builder.setContentText("这是我的第一个 Notification");

        Intent intent = new Intent(this, MainActivity.class);

        // Give the phone the ability to access our app
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        // Builds notification and issues it
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(UNIQUE_ID, builder.build());

    }
}
