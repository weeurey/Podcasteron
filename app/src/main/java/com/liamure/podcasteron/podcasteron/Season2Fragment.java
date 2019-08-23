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
public class Season2Fragment extends Fragment {


    public Season2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_season2, container, false);
        View returnView = inflater.inflate(R.layout.fragment_season2, container, false);

        // All the code in this fragment relates to changing the download button text to "Play" if it already exists on the device



        Button s2e1 = (Button)returnView.findViewById(R.id.button6001);
        Button s2e2 = (Button)returnView.findViewById(R.id.button16);
        Button s2e3 = (Button)returnView.findViewById(R.id.button17);
        Button s2e4 = (Button)returnView.findViewById(R.id.button18);
        Button s2e5 = (Button)returnView.findViewById(R.id.button19);
        Button s2e6 = (Button)returnView.findViewById(R.id.button20);





        for(int i=0; i<7; i++){
            File file = new File("/sdcard/music/Season-2-Episode-"+i+".MP3");
            int number = 0;
            if(file.exists()){

            }
            else{

                Log.i("Check", "checkDownloadedis:Not Here ");


                if(i==1){
                    s2e1.setText("Download");


                }else if (i==2){
                    s2e2.setText("Download");


                }else if (i==3){
                    s2e3.setText("Download");

                }else if (i==4){
                    s2e4.setText("Download");

                }else if (i==5){
                    s2e5.setText("Download");

                }else if (i==6){
                    s2e6.setText("Download");

                }




            }

        }



        return returnView;
    }

}
