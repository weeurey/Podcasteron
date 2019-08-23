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
public class Season5Fragment extends Fragment {


    public Season5Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_season5, container, false);
        View returnView = inflater.inflate(R.layout.fragment_season5, container, false);

        // All the code in this fragment relates to changing the download button text to "Play" if it already exists on the device



        Button s5e1 = (Button)returnView.findViewById(R.id.button6001);
        Button s5e2 = (Button)returnView.findViewById(R.id.button16);
        Button s5e3 = (Button)returnView.findViewById(R.id.button17);





        for(int i=0; i<13; i++){
            File file = new File("/sdcard/music/Season-1-Episode-"+i+".MP3");
            int number = 0;
            if(file.exists()){






            }
            else{

                Log.i("Check", "checkDownloadedis:Not Here ");


                if(i==1){
                    s5e1.setText("Download");


                }else if (i==2){
                    s5e2.setText("Download");


                }else if (i==3){
                    s5e3.setText("Download");

                }




            }

        }



        return returnView;
    }

}
