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
public class Radio1Fragment extends Fragment {


    public Radio1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_radio1, container, false);
        View returnView = inflater.inflate(R.layout.fragment_radio1, container, false);

        // All the code in this fragment relates to changing the download button text to "Play" if it already exists on the device



        Button r1e1 = (Button)returnView.findViewById(R.id.button600);
        Button r1e2 = (Button)returnView.findViewById(R.id.button6001);
        Button r1e3 = (Button)returnView.findViewById(R.id.button21);
        Button r1e4 = (Button)returnView.findViewById(R.id.button22);
        Button r1e5 = (Button)returnView.findViewById(R.id.button23);
        Button r1e6 = (Button)returnView.findViewById(R.id.button24);
        Button r1e7 = (Button)returnView.findViewById(R.id.button25);
        Button r1e8 = (Button)returnView.findViewById(R.id.button26);
        Button r1e9 = (Button)returnView.findViewById(R.id.button27);
        Button r1e10 = (Button)returnView.findViewById(R.id.button28);
        Button r1e11 = (Button)returnView.findViewById(R.id.button29);
        Button r1e12 = (Button)returnView.findViewById(R.id.button30);
        Button r1e13 = (Button)returnView.findViewById(R.id.button31);
        Button r1e14 = (Button)returnView.findViewById(R.id.button32);
        Button r1e15 = (Button)returnView.findViewById(R.id.button33);
        Button r1e16 = (Button)returnView.findViewById(R.id.button34);
        Button r1e17 = (Button)returnView.findViewById(R.id.button35);
        Button r1e18 = (Button)returnView.findViewById(R.id.button36);
        Button r1e19 = (Button)returnView.findViewById(R.id.button37);
        Button r1e20 = (Button)returnView.findViewById(R.id.button38);
        Button r1e21 = (Button)returnView.findViewById(R.id.button39);
        Button r1e22 = (Button)returnView.findViewById(R.id.button40);
        Button r1e23 = (Button)returnView.findViewById(R.id.button41);
        





        for(int i=0; i<24; i++){
            File file = new File("/sdcard/music/Radio-1-Episode-"+i+".MP3");
            int number = 0;
            if(file.exists()){






            }
            else{

                Log.i("Check", "checkDownloadedis:Not Here ");


                if(i==1){
                    r1e1.setText("Download");


                }else if (i==2){
                    r1e2.setText("Download");


                }else if (i==3){
                    r1e3.setText("Download");

                }else if (i==4){
                    r1e4.setText("Download");

                }else if (i==5){
                    r1e5.setText("Download");

                }else if (i==6){
                    r1e6.setText("Download");

                }else if (i==7){
                    r1e7.setText("Download");

                }else if (i==8){
                    r1e8.setText("Download");

                }else if (i==9){
                    r1e9.setText("Download");

                }else if (i==10){
                    r1e10.setText("Download");

                }else if (i==11){
                    r1e11.setText("Download");

                }else if (i==12){
                    r1e12.setText("Download");

                }else if (i==13){
                    r1e13.setText("Download");

                }else if (i==14){
                    r1e14.setText("Download");

                }else if (i==15){
                    r1e15.setText("Download");

                }else if (i==16){
                    r1e16.setText("Download");

                }else if (i==17){
                    r1e17.setText("Download");

                }else if (i==18){
                    r1e18.setText("Download");

                }else if (i==19){
                    r1e19.setText("Download");

                }else if (i==20){
                    r1e20.setText("Download");

                }else if (i==21){
                    r1e21.setText("Download");

                }else if (i==22){
                    r1e22.setText("Download");

                }else if (i==23){
                    r1e23.setText("Download");

                }




            }

        }



        return returnView;
    }

}
