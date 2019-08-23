package com.liamure.podcasteron.podcasteron;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.File;


/**
 * A simple {@link Fragment} subclass.
 */
public class Season1Fragment extends Fragment {


    public Season1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_season1, container, false);
        View returnView = inflater.inflate(R.layout.fragment_season1, container, false);


        // All the code in this fragment relates to changing the download button text to "Play" if it already exists on the device

        Button s1e1 = (Button)returnView.findViewById(R.id.button6001);
        Button s1e2 = (Button)returnView.findViewById(R.id.button1);
        Button s1e3 = (Button)returnView.findViewById(R.id.button2);
        Button s1e4 = (Button)returnView.findViewById(R.id.button3);
        Button s1e5 = (Button)returnView.findViewById(R.id.button4);
        Button s1e6 = (Button)returnView.findViewById(R.id.button5);
        Button s1e7 = (Button)returnView.findViewById(R.id.button6);
        Button s1e8 = (Button)returnView.findViewById(R.id.button7);
        Button s1e9 = (Button)returnView.findViewById(R.id.button8);
        Button s1e10 = (Button)returnView.findViewById(R.id.button9);
        Button s1e11 = (Button)returnView.findViewById(R.id.button10);
        Button s1e12 = (Button)returnView.findViewById(R.id.button11);


        for(int i=0; i<13; i++){
            File file = new File("/sdcard/music/Season-1-Episode-"+i+".MP3");
            int number = 0;
            if(file.exists()){

            }
            else{

                Log.i("Check", "checkDownloadedis:Not Here ");


                if(i==1){
                    s1e1.setText("Download");


                }else if (i==2){
                    s1e2.setText("Download");


                }else if (i==3){
                    s1e3.setText("Download");

                }else if (i==4){
                    s1e4.setText("Download");

                }else if (i==5){
                    s1e5.setText("Download");

                }else if (i==6){
                    s1e6.setText("Download");

                }else if (i==7){
                    s1e7.setText("Download");

                }else if (i==8){
                    s1e8.setText("Download");

                }else if (i==9){
                    s1e9.setText("Download");

                }else if (i==10){
                    s1e10.setText("Download");

                }else if (i==11){
                    s1e11.setText("Download");

                }else if (i==12){
                    s1e12.setText("Download");

                }


            }

        }



    return returnView;
    }

}
