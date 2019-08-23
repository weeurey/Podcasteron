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
public class Season3Fragment extends Fragment {


    public Season3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_season3, container, false);
        View returnView = inflater.inflate(R.layout.fragment_season3, container, false);

        // All the code in this fragment relates to changing the download button text to "Play" if it already exists on the device



        Button s3e1 = (Button) returnView.findViewById(R.id.button6001);
        Button s3e2 = (Button) returnView.findViewById(R.id.button16);
        Button s3e3 = (Button) returnView.findViewById(R.id.button17);
        Button s3e4 = (Button) returnView.findViewById(R.id.button18);
        Button s3e5 = (Button) returnView.findViewById(R.id.button19);
        Button s3e6 = (Button) returnView.findViewById(R.id.button20);


        for (int i = 0; i < 13; i++) {
            File file = new File("/sdcard/music/Season-3-Episode-" + i + ".MP3");
            int number = 0;
            if (file.exists()) {


            } else {

                Log.i("Check", "checkDownloadedis:Not Here ");


                if (i == 1) {
                    s3e1.setText("Download");


                } else if (i == 2) {
                    s3e2.setText("Download");


                } else if (i == 3) {
                    s3e3.setText("Download");

                } else if (i == 4) {
                    s3e4.setText("Download");

                } else if (i == 5) {
                    s3e5.setText("Download");

                } else if (i == 6) {
                    s3e6.setText("Download");


                }

            }


        }

        return returnView;
    }
}