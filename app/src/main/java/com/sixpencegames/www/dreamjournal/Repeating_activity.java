package com.sixpencegames.www.dreamjournal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Thomas on 24/08/2017.
 */

public class Repeating_activity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("clicking on the notification worked");
    }
}
