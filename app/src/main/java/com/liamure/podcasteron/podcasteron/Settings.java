package com.liamure.podcasteron.podcasteron;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    //Currently the settings page will allow users to delete all episodes that are stored on their devices

    public void a(View view){

        //Set dir to the music folder
        File folder = new File("/sdcard/music/");

        File[] filenamestemp = folder.listFiles();

        for (int i = 0; i < filenamestemp.length; i++) {
            //loop through each file in directory and delete any with the appropriate prefix
            if (filenamestemp[i].getAbsolutePath().toString().contains("Episode"))
                filenamestemp[i].delete();
        }



        //Restart app
        Intent i = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage( getBaseContext().getPackageName() );
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);



    }



}
