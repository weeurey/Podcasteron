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
public class Radio4Fragment extends Fragment {


    public Radio4Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_radio4, container, false);
        View returnView = inflater.inflate(R.layout.fragment_radio4, container, false);

        // All the code in this fragment relates to changing the download button text to "Play" if it already exists on the device



        Button r4e1 = (Button)returnView.findViewById(R.id.button600);
        Button r4e2 = (Button)returnView.findViewById(R.id.button6001);
        Button r4e3 = (Button)returnView.findViewById(R.id.button21);
        Button r4e4 = (Button)returnView.findViewById(R.id.button22);
        Button r4e5 = (Button)returnView.findViewById(R.id.button23);
        Button r4e6 = (Button)returnView.findViewById(R.id.button24);





        for(int i=0; i<13; i++){
            File file = new File("/sdcard/music/Radio-4-Episode-"+i+".MP3");
            int number = 0;
            if(file.exists()){






            }
            else{

                Log.i("Check", "checkDownloadedis:Not Here ");


                if(i==1){
                    r4e1.setText("Download");


                }else if (i==2){
                    r4e2.setText("Download");


                }else if (i==3){
                    r4e3.setText("Download");

                }else if (i==4){
                    r4e4.setText("Download");

                }else if (i==5){
                    r4e5.setText("Download");

                }else if (i==6){
                    r4e6.setText("Download");

                }




            }

        }



        return returnView;
    }

}
