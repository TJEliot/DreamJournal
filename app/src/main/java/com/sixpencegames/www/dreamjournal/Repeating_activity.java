package com.sixpencegames.www.dreamjournal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import static com.sixpencegames.www.dreamjournal.R.id.dreamText;

/**
 * Created by Thomas on 24/08/2017.
 */

public class Repeating_activity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("clicking on the notification worked");



        final TextView tv = (TextView)findViewById(dreamText);
        final Button button = (Button) findViewById(R.id.button);
        final Button recorder = (Button) findViewById(R.id.recordDream);
        final File path = this.getFilesDir();
        button.setVisibility(View.GONE);


        recorder.setOnClickListener(new View.OnClickListener(){
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
                    recorder.setVisibility(View.GONE);
                    System.out.println("clicking on the recorder button worked");
                }
                catch(IOException ex) {
                    System.out.println(ex);
                }
            }
        });

    }
}
