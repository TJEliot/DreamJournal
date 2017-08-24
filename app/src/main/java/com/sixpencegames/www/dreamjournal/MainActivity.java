package com.sixpencegames.www.dreamjournal;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Calendar;

import static android.R.attr.button;
import static com.sixpencegames.www.dreamjournal.R.id.dreamText;

public class MainActivity extends AppCompatActivity {
//    File path = this.getFilesDir();
/*    File file = new File(path, "dreamWritings.txt");

    FileOutputStream stream;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv = (TextView)findViewById(dreamText);
        final Button button = (Button) findViewById(R.id.recordDream);
        final File path = this.getFilesDir();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, 15);
                calendar.set(Calendar.MINUTE, 44);

                Intent intent = new Intent(getApplicationContext(),Notification_receiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),001,intent, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
            }
        });{

        };


/*        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("Time to record your dream")
                        .setContentText("As soon as you wake up");
        Intent resultIntent = new Intent(this, MainActivity.class);
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(this, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);

    //    NotificationCompat.Builder mBuilder;
        int mNotificationId = 001;
        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotifyMgr.notify(mNotificationId, mBuilder.build());

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 7);
        calendar.set(Calendar.MINUTE, 07);
        calendar.set(Calendar.SECOND, 00);

        Intent notifyIntent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast
                (this, 1, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,  calendar.getTimeInMillis(),
                1000 * 60 * 60 * 24, pendingIntent);*/






        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String dreamWords = tv.getText().toString();
                FileOutputStream stream;
                File file = new File(path, "dreamWritings.txt");
                try {
                        stream = new FileOutputStream(file, true);
                    }
                catch(FileNotFoundException ex2){
                    stream = null;
                    System.out.println(ex2);
                    }
                try {
                    stream.write(dreamWords.getBytes());
                    stream.close();
                    tv.setText("Your skills at astral projection grow every day");
                }
                catch(IOException ex) {
                    System.out.println(ex);
                }
            }
        });
    }


    }





