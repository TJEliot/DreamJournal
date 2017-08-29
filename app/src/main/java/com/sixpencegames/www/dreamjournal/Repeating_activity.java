package com.sixpencegames.www.dreamjournal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.sixpencegames.www.dreamjournal.R.id.dreamText;

/**
 * Created by Thomas on 24/08/2017.
 */

public class Repeating_activity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv = (TextView)findViewById(dreamText);
        final Button reminder = (Button) findViewById(R.id.button);
        final Button recorder = (Button) findViewById(R.id.recordDream);
        final Button showMe = (Button) findViewById(R.id.button2);
        final File path = this.getFilesDir();
        reminder.setVisibility(View.GONE);

        recorder.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String dreamWords = tv.getText().toString();
                String newline = System.getProperty("line.separator");
                String easyTime = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
                FileOutputStream stream;
                File file = new File(path, "dreamWritings.txt");
                try {
                    stream = new FileOutputStream(file, true);
                } catch (FileNotFoundException ex2) {
                    stream = null;
                    System.out.println(ex2);
                }
                try {
                    stream.write(newline.getBytes());
                    stream.write(newline.getBytes());
                    stream.write(easyTime.getBytes());
                    stream.write(newline.getBytes());
                    stream.write(newline.getBytes());
                    stream.write(dreamWords.getBytes());
                    stream.write(newline.getBytes());
                    stream.write(newline.getBytes());
                    stream.close();
                    tv.setText("Your skills at astral projection grow every day");
                    recorder.setVisibility(View.GONE);
                    System.out.println("clicking on the recorder button worked");
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        });

        showMe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream fileIn = openFileInput("dreamWritings.txt");
                    InputStreamReader InputRead= new InputStreamReader(fileIn);
                    char[] inputBuffer= new char[100];
                    String s="";
                    int charRead;
                    while ((charRead=InputRead.read(inputBuffer))>0) {
                        // char to string conversion
                        String readstring=String.copyValueOf(inputBuffer,0,charRead);
                        s +=readstring;
                    }
                    InputRead.close();
                    tv.setText(s);
                    recorder.setVisibility(View.GONE);
                } catch (FileNotFoundException ex3) {
                    System.out.println(ex3);
                } catch (IOException ex4) {
                    System.out.println(ex4);
                }
            }
        });

    }
}
