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
public class Radio2Fragment extends Fragment {


    public Radio2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_radio2, container, false);
        View returnView = inflater.inflate(R.layout.fragment_radio2, container, false);

        // All the code in this fragment relates to changing the download button text to "Play" if it already exists on the device



        Button r2e1 = (Button)returnView.findViewById(R.id.button600);
        Button r2e2 = (Button)returnView.findViewById(R.id.button6001);
        Button r2e3 = (Button)returnView.findViewById(R.id.button21);
        Button r2e4 = (Button)returnView.findViewById(R.id.button22);
        Button r2e5 = (Button)returnView.findViewById(R.id.button23);
        Button r2e6 = (Button)returnView.findViewById(R.id.button24);
        Button r2e7 = (Button)returnView.findViewById(R.id.button25);
        Button r2e8 = (Button)returnView.findViewById(R.id.button26);
        Button r2e9 = (Button)returnView.findViewById(R.id.button27);
        Button r2e10 = (Button)returnView.findViewById(R.id.button28);
        Button r2e11 = (Button)returnView.findViewById(R.id.button29);
        Button r2e12 = (Button)returnView.findViewById(R.id.button30);

        Button r2e13 = (Button)returnView.findViewById(R.id.button31);
        Button r2e14 = (Button)returnView.findViewById(R.id.button32);
        Button r2e15 = (Button)returnView.findViewById(R.id.button33);
        Button r2e16 = (Button)returnView.findViewById(R.id.button34);
        Button r2e17 = (Button)returnView.findViewById(R.id.button35);
        Button r2e18 = (Button)returnView.findViewById(R.id.button36);
        Button r2e19 = (Button)returnView.findViewById(R.id.button37);
        Button r2e20 = (Button)returnView.findViewById(R.id.button38);
        Button r2e21 = (Button)returnView.findViewById(R.id.button39);
        Button r2e22 = (Button)returnView.findViewById(R.id.button40);
        Button r2e23 = (Button)returnView.findViewById(R.id.button41);
        Button r2e24 = (Button)returnView.findViewById(R.id.button42);
        Button r2e25 = (Button)returnView.findViewById(R.id.button43);
        Button r2e26 = (Button)returnView.findViewById(R.id.button44);
        Button r2e27 = (Button)returnView.findViewById(R.id.button45);
        Button r2e28 = (Button)returnView.findViewById(R.id.button46);
        Button r2e29 = (Button)returnView.findViewById(R.id.button47);
        Button r2e30 = (Button)returnView.findViewById(R.id.button48);
        Button r2e31 = (Button)returnView.findViewById(R.id.button49);
        Button r2e32 = (Button)returnView.findViewById(R.id.button50);
        Button r2e33 = (Button)returnView.findViewById(R.id.button51);
        Button r2e34 = (Button)returnView.findViewById(R.id.button52);
        Button r2e35 = (Button)returnView.findViewById(R.id.button53);
        Button r2e36 = (Button)returnView.findViewById(R.id.button54);
        Button r2e37 = (Button)returnView.findViewById(R.id.button55);
        Button r2e38 = (Button)returnView.findViewById(R.id.button56);
        Button r2e39 = (Button)returnView.findViewById(R.id.button57);
        Button r2e40 = (Button)returnView.findViewById(R.id.button58);
        Button r2e41 = (Button)returnView.findViewById(R.id.button59);
        Button r2e42 = (Button)returnView.findViewById(R.id.button60);
        Button r2e43 = (Button)returnView.findViewById(R.id.button61);
        Button r2e44 = (Button)returnView.findViewById(R.id.button62);
        Button r2e45 = (Button)returnView.findViewById(R.id.button63);
        Button r2e46 = (Button)returnView.findViewById(R.id.button64);
        Button r2e47 = (Button)returnView.findViewById(R.id.button65);
        Button r2e48 = (Button)returnView.findViewById(R.id.button66);
        Button r2e49 = (Button)returnView.findViewById(R.id.button67);
        Button r2e50 = (Button)returnView.findViewById(R.id.button68);
        Button r2e51 = (Button)returnView.findViewById(R.id.button69);






        for(int i=0; i<52; i++){
            File file = new File("/sdcard/music/Radio-2-Episode-"+i+".MP3");
            int number = 0;
            if(file.exists()){






            }
            else{

                Log.i("Check", "checkDownloadedis:Not Here ");


                if(i==1){
                    r2e1.setText("Download");


                }else if (i==2){
                    r2e2.setText("Download");


                }else if (i==3){
                    r2e3.setText("Download");

                }else if (i==4){
                    r2e4.setText("Download");

                }else if (i==5){
                    r2e5.setText("Download");

                }else if (i==6){
                    r2e6.setText("Download");

                }else if (i==7){
                    r2e7.setText("Download");

                }else if (i==8){
                    r2e8.setText("Download");

                }else if (i==9){
                    r2e9.setText("Download");

                }else if (i==10){
                    r2e10.setText("Download");

                }else if (i==11){
                    r2e11.setText("Download");

                }else if (i==12){
                    r2e12.setText("Download");

                }else if (i==13){
                    r2e13.setText("Download");

                }else if (i==14){
                    r2e14.setText("Download");

                }else if (i==15){
                    r2e15.setText("Download");

                }else if (i==16){
                    r2e16.setText("Download");

                }else if (i==17){
                    r2e17.setText("Download");

                }else if (i==18){
                    r2e18.setText("Download");

                }else if (i==19){
                    r2e19.setText("Download");

                }else if (i==20){
                    r2e20.setText("Download");

                }else if (i==21){
                    r2e21.setText("Download");

                }else if (i==22){
                    r2e22.setText("Download");

                }else if (i==23){
                    r2e23.setText("Download");

                }else if (i==24){
                    r2e24.setText("Download");

                }else if (i==25){
                    r2e25.setText("Download");

                }else if (i==26){
                    r2e26.setText("Download");

                }else if (i==27){
                    r2e27.setText("Download");

                }else if (i==28){
                    r2e28.setText("Download");

                }else if (i==29){
                    r2e29.setText("Download");

                }else if (i==30){
                    r2e30.setText("Download");

                }else if (i==31){
                    r2e31.setText("Download");

                }else if (i==32){
                    r2e32.setText("Download");

                }else if (i==33){
                    r2e33.setText("Download");

                }else if (i==34){
                    r2e34.setText("Download");

                }else if (i==35){
                    r2e35.setText("Download");

                }else if (i==36){
                    r2e36.setText("Download");

                }else if (i==37){
                    r2e37.setText("Download");

                }else if (i==38){
                    r2e38.setText("Download");

                }else if (i==39){
                    r2e39.setText("Download");

                }else if (i==40){
                    r2e40.setText("Download");

                }else if (i==41){
                    r2e41.setText("Download");

                }else if (i==42){
                    r2e42.setText("Download");

                }else if (i==43){
                    r2e43.setText("Download");

                }else if (i==44){
                    r2e44.setText("Download");

                }else if (i==45){
                    r2e45.setText("Download");

                }else if (i==46){
                    r2e46.setText("Download");

                }else if (i==47){
                    r2e47.setText("Download");

                }else if (i==48){
                    r2e48.setText("Download");

                }else if (i==49){
                    r2e49.setText("Download");

                }else if (i==50){
                    r2e50.setText("Download");

                }else if (i==51){
                    r2e51.setText("Download");

                }




            }

        }



        return returnView;
    }

}
