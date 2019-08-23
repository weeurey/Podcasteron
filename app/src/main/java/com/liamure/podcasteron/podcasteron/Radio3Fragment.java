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
public class Radio3Fragment extends Fragment {


    public Radio3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_radio3, container, false);
        View returnView = inflater.inflate(R.layout.fragment_radio3, container, false);

        // All the code in this fragment relates to changing the download button text to "Play" if it already exists on the device



        Button r3e1 = (Button)returnView.findViewById(R.id.button600);
        Button r3e2 = (Button)returnView.findViewById(R.id.button6001);
        Button r3e3 = (Button)returnView.findViewById(R.id.button21);
        Button r3e4 = (Button)returnView.findViewById(R.id.button22);
        Button r3e5 = (Button)returnView.findViewById(R.id.button23);
        Button r3e6 = (Button)returnView.findViewById(R.id.button24);
        Button r3e7 = (Button)returnView.findViewById(R.id.button25);
        Button r3e8 = (Button)returnView.findViewById(R.id.button26);
        Button r3e9 = (Button)returnView.findViewById(R.id.button27);
        Button r3e10 = (Button)returnView.findViewById(R.id.button28);
        Button r3e11 = (Button)returnView.findViewById(R.id.button29);
        Button r3e12 = (Button)returnView.findViewById(R.id.button30);




        for(int i=0; i<13; i++){
            File file = new File("/sdcard/music/Radio-3-Episode-"+i+".MP3");
            int number = 0;
            if(file.exists()){






            }
            else{

                Log.i("Check", "checkDownloadedis:Not Here ");


                if(i==1){
                    r3e1.setText("Download");


                }else if (i==2){
                    r3e2.setText("Download");


                }else if (i==3){
                    r3e3.setText("Download");

                }else if (i==4){
                    r3e4.setText("Download");

                }else if (i==5){
                    r3e5.setText("Download");

                }else if (i==6){
                    r3e6.setText("Download");

                }else if (i==7){
                    r3e7.setText("Download");

                }else if (i==8){
                    r3e8.setText("Download");

                }else if (i==9){
                    r3e9.setText("Download");

                }else if (i==10){
                    r3e10.setText("Download");

                }else if (i==11){
                    r3e11.setText("Download");

                }else if (i==12){
                    r3e12.setText("Download");

                }




            }

        }



        return returnView;
    }

}
