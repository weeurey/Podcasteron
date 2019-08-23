package com.liamure.podcasteron.podcasteron;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.PowerManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    //This is the landing page of the app.


    //Sets up the vars for the download process
    ProgressDialog mProgressDialog;
    String downloadName;


    //Sets up vars used for the User Interface
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    View cusView;
    TextView selectLbl;
    Button selectBtn;
    TextView textViewDescTitle;
    TextView textViewDesc;
    TextView textViewDescDate;
    String episodeRequested;


    //Sets up the vars used for the episode description interface
    RelativeLayout DescLayout;
    GridLayout episodeGrid;
    SQLiteDatabase eventsDB;

    public void createDB(){
        //This method creates and populates the database primarily used for the description layouts
        //I would have liked to have all the database code in its own class file but I was having trouble setting it up


            try {


                //Creates the table
                eventsDB.execSQL("CREATE TABLE IF NOT EXISTS desc (episode VARCHAR, date VARCHAR, descr VARCHAR)");
                eventsDB.execSQL("DELETE FROM desc");

                //Inserts the data into the database
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-1-Episode-1', '5 December 2005', 'The boys embark on the first episode of their strange journey, peddling Karl to the rest of the world. Topics such as flies, condoms, tankards, dinosaurs, and space monkeys are discussed. Its good to be back.')");
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-1-Episode-2', '12 December 2005', 'Not a show for the easily offended, this show primarily features knob talk. The boys flex their censor-free format going over sex aids and nudists. And apparently a load of Cambodian midgets died.')");
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-1-Episode-3', '19 December 2005', 'This episode features a double-dose of monkey related features and a probing into Karls thoughts on nature, evolution, and reproduction.')");
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-1-Episode-4', '26 December 2005', 'Its the last show of 2005 and the gang discusses Christmas, gifts, spacemen and more. Karl gives some of his most infamous quotes, including \"bungled in\" and \"Chinese Homeless Fella.n')");
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-1-Episode-5', '2 January 2006', 'Karl Pilkington finally gets quoted after almost five years on the air, as his personal mantra floods the internet.')");
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-1-Episode-6', '9 January 2006', 'Homeless fellas, freaks, monkey news. Karl Pilkington.')");
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-1-Episode-7', '16 January 2006', 'Ricky, Steve and Karl move swiftly along to their seventh online podcast.')");
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-1-Episode-8', '23 January 2006', 'The introduction of Karls Diary, Guinness Book chat, nickname chat, and another impossible Monkey News.')");
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-1-Episode-9', '30 January 2006', 'A few retro cuts: a throw back to Do We Need Em and Liam (Horse in the House kid) comes up, along with some Monkey News.')");
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-1-Episode-10', '6 February 2006', 'Ricky finally buckles calling the podcast \"The Karl Pilkington Show\". Hes just the ringmaster and Karl is center stage.')");
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-1-Episode-11', '13 February 2006', 'In the penultimate episode of the first series the trio discuss Karls celebrity and loads of questions are sent in by fans.')");
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-1-Episode-12', '20 February 2006', 'Description')");

                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-2-Episode-1', '27 Feb 2006\t', 'A new and improved show has begun where listeners pay a quid to hear drivel. Karl has difficulty understanding time travel and imagines what he would do with his doppelganger. Although Monkey News was retired, Karls Diary as well as the popular feature Rockbusters replace it.\n')");
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-2-Episode-2', '7 Mar 2006\t', 'Ricky reports that Karl is well received in America, but people continue to demand more Monkey News. Steve shares his infamous Rio anecdote and reads another installment of Karls Diary. Karl continues his campaign to rid the world of jellyfish and gives out more Rockbuster clues.\n')");
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-2-Episode-3', '14 Mar 2006\t', 'A fan criticises Ricky, Steve, and Karl via email for not swearing enough. Rickys embarrassed himself by messing up the heaven and hell conundrum in the first episode. Karl puts forward some truly ludicrous theories about fingers used as knobs and throat cancer that eats meat. Ricky swears that this is the end of Rockbusters.\n')");
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-2-Episode-4', '21 Mar 2006\t', 'Ricky and Steve are criticized by the listeners for the way they bully Karl. Ricky annoys Karl with some animal facts and Steve tells an anecdote about his luck with the ladies. Rockbusters is back again, but Ricky and Steve are fairly certain that Karl has no idea what the word cryptic means.\n')");
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-2-Episode-5', '28 Mar 2006\t', 'Karl was supposed to learn about Sigmund Freud in the week but he gave up when he couldnt find any good quotes. Karl talks about another Pilkington pet, Harry the Housefly, and Steve reads about Karls trip to Cotswolds with Suzanne for her birthday from his diary. Clues for the final Rockbusters ever are given out.\n')");
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-2-Episode-6', '4 Apr 2006\t', 'In this final episode, Steve asks Karl questions from Inside the Actors Studio, Ricky lets out a string of obscenities, and Karl wonders if he is in control of his brain or if his brain controls him. Karl also gets annoyed at a killer octopus that spits venom. Finally, the answers and winner of Rockbusters are given out for the last time.\n')");

                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-3-Episode-1', '22 Aug 2006\t', 'The boys have returned for their third series of podcasts after a few months off. In the break Ricky and Steve filmed series 2 of Extras and Karl wandered about London watching insects and writing poems. Topics of this episode include bees having heart attacks and cavemen wearing hair gel.\n')");
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-3-Episode-2', '29 Aug 2006\t', 'Karl has been in the hospital during the week with kidney stones. They put a tube up his knob and he has to go back again to finish the procedure. More entries from Karls diary are read and Karl has written another poem about a particularly emotional day for him.\n')");
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-3-Episode-3', '5 Sep 2006\t', 'Its been a boring week for Karl due to his kidney stones. But all the free time has given him a chance to look things up on the internet to get him thinking. He was also able to write 3 new poems during the week about jellyfish and kidney stones.\n')");
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-3-Episode-4', '12 Sep 2006\t', 'Things get a bit heated between Ricky, Steve, and Karl. Ricky and Steve have had enough of Karls constant moaning about his kidney stones. Steves parents have found some criticism for Karls television appearance and Steve tries to set the record straight about his dancing ability.\n')");
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-3-Episode-5', '19 Sep 2006\t', 'Karl has some ideas on how he can improve the human body, he also talks about monkey toll collectors, slugs, and a man whose skull fell off. Steve went out to a club during the week where his celebrity status failed to get him in yet still got him recognized by others that did get in the club.\n')");
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-3-Episode-6', '26 Sep 2006\t', 'The final episode of the series features Karls take on philosophy and freaks, as well as more stories about Karls experiences in the hospital with kidney stones. The show ends with Ricky and Steve saying they plan to take a break from podcasts and audiobooks. There is also a bonus monkey news about monkeys making fruit drinks.\n')");

                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-4-Episode-1', '31st October 2006', 'Ghostly drivel abounds as Steve consults a text-based oracle. Karl experiences a kidney probing and suggests that doctors should deny the elderly medical treatment. Steve returns home to Bristol and lies to some 9-year-olds to gain their approval. Karl reluctantly becomes a godfather. Ricky tells of some lighter moments at the morgue. Karl explains the ins and outs of neurosurgery.')");
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-4-Episode-2', '23rd November 2006', 'Steve and Karl dont understand why Ricky has chosen to do this podcast on a strictly American holiday. Karl has a rant about the rigidity of holidays. Ricky asks Karl to choose five people to help him create a new society on a distant planet. Karl goes to visit a professional leg-rubber. The legendary \"kicking my height\" story is revisited. Steve reads some choice excerpts from Karls diary. Plus theres another shoddy competition.')");
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-4-Episode-3', '24th December 2006', 'Karl reflects on the past year and singles out an unlikely highlight. Steve stocks up on yuletide essentials. Karl advocates an anarchic Christmas. Karls diary draws to a close with revelations of bothersome footwear and worry-holes. Ricky provides an emotional exit en route to the orphanage.')");

                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-5-Episode-1', '15 September 2008\t', 'The show begins unorganised and a shambles but quickly takes off as the gang discusses iPods, dead owls, ties with pockets and gay marriage.\n')");
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-5-Episode-2', '15 September 2008\t', 'Karl decides what he would put into Room 102. He makes a case for slugs and restless leg syndrome, among other things. Ricky also gives him a chance to address all the scientists of the world.\n')");
                eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Season-5-Episode-34', '15 September 2008\t', 'Ricky, Steve and Karl discuss the growing problem of obesity. Ricky tells an anecdote from when he was in his early twenties and he tried to make a suit out of gold curtains.\n')");



                //Test of the DB. Logs info to the IDE
                Cursor c = eventsDB.rawQuery("SELECT * FROM desc WHERE episode = 'Season-2-Episode-1'", null);

                int episodeIndex = c.getColumnIndex("episode");
                int dateIndex = c.getColumnIndex("date");
                int descIndex = c.getColumnIndex("descr");


                c.moveToFirst();

                //Test of the DB. Logs info to the IDE

                while (c != null) {

                    Log.i("Results - episode", c.getString(episodeIndex));
                    Log.i("Results - date", c.getString(dateIndex));
                    Log.i("Results - descr", c.getString(descIndex));


                    c.moveToNext();
                }


            }
            catch (Exception e) {

                e.printStackTrace();

            }




        }



    //There is a show media data method for each season of podcats.
    //I initialy intended to have each season look slightly different with a new theme
    //However I may still inplement this in the future

    public void showMediaData(View view){

        //Set up vars and objects for description layout
        DescLayout = (RelativeLayout)findViewById(R.id.relDescriptionLayout);
        episodeGrid = (GridLayout)findViewById(R.id.gridEpisodes) ;
        textViewDesc = (TextView)findViewById(R.id.txtDesc);
        textViewDescDate = (TextView)findViewById(R.id.txtDate);
        textViewDescTitle = (TextView)findViewById(R.id.txtTitle);
       episodeGrid.setVisibility(View.INVISIBLE);
        DescLayout.setVisibility(View.VISIBLE);
       episodeRequested = view.getTag().toString();



        //try find the data for the episode from the database
        try {

            Cursor c = eventsDB.rawQuery("SELECT * FROM desc WHERE episode='" + episodeRequested + "'", null);

            int episodeIndex = c.getColumnIndex("episode");
            int dateIndex = c.getColumnIndex("date");
            int descIndex = c.getColumnIndex("descr");

            c.moveToFirst();


            while (c != null) {

                //Set up the UI with the data gatherd from the DB
                textViewDesc.setText(c.getString(descIndex));
                textViewDescTitle.setText(c.getString(episodeIndex));
                textViewDescDate.setText(c.getString(dateIndex));
                c.moveToNext();
            }
        }
    catch (Exception e) {
        e.printStackTrace();
        }

        //Start up a webview to that will load a webpage to allow users to leave comments
        WebView webView = (WebView) findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        webView.loadUrl("" + episodeRequested);
        Log.i("http requested", "" + episodeRequested);


    }

    public void showMediaDataS2(View view){

        //This method is currently almost identical to showMediaData()

        DescLayout = (RelativeLayout)findViewById(R.id.relDescriptionLayoutS2);
        episodeGrid = (GridLayout)findViewById(R.id.gridEpisodesS2) ;
        textViewDesc = (TextView)findViewById(R.id.txtDescS2);
        textViewDescDate = (TextView)findViewById(R.id.txtDateS2);
        textViewDescTitle = (TextView)findViewById(R.id.txtTitleS2);
        episodeGrid.setVisibility(View.INVISIBLE);
        DescLayout.setVisibility(View.VISIBLE);
        episodeRequested = view.getTag().toString();

        try {

            Cursor c = eventsDB.rawQuery("SELECT * FROM desc WHERE episode='" + episodeRequested + "'", null);

            int episodeIndex = c.getColumnIndex("episode");
            int dateIndex = c.getColumnIndex("date");
            int descIndex = c.getColumnIndex("descr");

            c.moveToFirst();


            while (c != null) {
                textViewDesc.setText(c.getString(descIndex));
                textViewDescTitle.setText(c.getString(episodeIndex));
                textViewDescDate.setText(c.getString(dateIndex));
                c.moveToNext();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        WebView webView = (WebView) findViewById(R.id.webView2);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        webView.loadUrl("http://liamure.net23.net/rsk/rsk2.html?ep=" + episodeRequested);
        Log.i("http requested", "http://liamure.net23.net/rsk/rsk2.html?ep=" + episodeRequested);


    }

    public void showMediaDataS3(View view){

        //This method is currently almost identical to showMediaData()


        DescLayout = (RelativeLayout)findViewById(R.id.relDescriptionLayoutS3);
        episodeGrid = (GridLayout)findViewById(R.id.gridEpisodesS3) ;
        textViewDesc = (TextView)findViewById(R.id.txtDescS3);
        textViewDescDate = (TextView)findViewById(R.id.txtDateS3);
        textViewDescTitle = (TextView)findViewById(R.id.txtTitleS3);
        episodeGrid.setVisibility(View.INVISIBLE);
        DescLayout.setVisibility(View.VISIBLE);
        episodeRequested = view.getTag().toString();

        try {

            Cursor c = eventsDB.rawQuery("SELECT * FROM desc WHERE episode='" + episodeRequested + "'", null);

            int episodeIndex = c.getColumnIndex("episode");
            int dateIndex = c.getColumnIndex("date");
            int descIndex = c.getColumnIndex("descr");

            c.moveToFirst();


            while (c != null) {
                textViewDesc.setText(c.getString(descIndex));
                textViewDescTitle.setText(c.getString(episodeIndex));
                textViewDescDate.setText(c.getString(dateIndex));
                c.moveToNext();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        WebView webView = (WebView) findViewById(R.id.webView3);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        webView.loadUrl("http://liamure.net23.net/rsk/rsk2.html?ep=" + episodeRequested);
        Log.i("http requested", "http://liamure.net23.net/rsk/rsk2.html?ep=" + episodeRequested);


    }

    public void showMediaDataS4(View view){

        //This method is currently almost identical to showMediaData()


        DescLayout = (RelativeLayout)findViewById(R.id.relDescriptionLayoutS4);
        episodeGrid = (GridLayout)findViewById(R.id.gridEpisodesS4) ;
        textViewDesc = (TextView)findViewById(R.id.txtDescS4);
        textViewDescDate = (TextView)findViewById(R.id.txtDateS4);
        textViewDescTitle = (TextView)findViewById(R.id.txtTitleS4);
        episodeGrid.setVisibility(View.INVISIBLE);
        DescLayout.setVisibility(View.VISIBLE);
        episodeRequested = view.getTag().toString();

        try {

            Cursor c = eventsDB.rawQuery("SELECT * FROM desc WHERE episode='" + episodeRequested + "'", null);

            int episodeIndex = c.getColumnIndex("episode");
            int dateIndex = c.getColumnIndex("date");
            int descIndex = c.getColumnIndex("descr");

            c.moveToFirst();


            while (c != null) {
                textViewDesc.setText(c.getString(descIndex));
                textViewDescTitle.setText(c.getString(episodeIndex));
                textViewDescDate.setText(c.getString(dateIndex));
                c.moveToNext();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        WebView webView = (WebView) findViewById(R.id.webView4);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        webView.loadUrl("http://liamure.net23.net/rsk/rsk2.html?ep=" + episodeRequested);
        Log.i("http requested", "http://liamure.net23.net/rsk/rsk2.html?ep=" + episodeRequested);


    }

    public void showMediaDataS5(View view){

        //This method is currently almost identical to showMediaData()


        DescLayout = (RelativeLayout)findViewById(R.id.relDescriptionLayoutS5);
        episodeGrid = (GridLayout)findViewById(R.id.gridEpisodesS5) ;
        textViewDesc = (TextView)findViewById(R.id.txtDescS5);
        textViewDescDate = (TextView)findViewById(R.id.txtDateS5);
        textViewDescTitle = (TextView)findViewById(R.id.txtTitleS5);
        episodeGrid.setVisibility(View.INVISIBLE);
        DescLayout.setVisibility(View.VISIBLE);
        episodeRequested = view.getTag().toString();

        try {

            Cursor c = eventsDB.rawQuery("SELECT * FROM desc WHERE episode='" + episodeRequested + "'", null);

            int episodeIndex = c.getColumnIndex("episode");
            int dateIndex = c.getColumnIndex("date");
            int descIndex = c.getColumnIndex("descr");

            c.moveToFirst();


            while (c != null) {
                textViewDesc.setText(c.getString(descIndex));
                textViewDescTitle.setText(c.getString(episodeIndex));
                textViewDescDate.setText(c.getString(dateIndex));
                c.moveToNext();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        WebView webView = (WebView) findViewById(R.id.webView5);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        webView.loadUrl("http://liamure.net23.net/rsk/rsk2.html?ep=" + episodeRequested);
        Log.i("http requested", "http://liamure.net23.net/rsk/rsk2.html?ep=" + episodeRequested);


    }

    public void deleteEpisode(View view){

        //This method allows a user to delete an individual episode


        //find the file to delete
        File file = new File("/sdcard/music/"+ episodeRequested +".MP3");

        //log to ide for debug purposes
        Log.i("DELETE", "/sdcard/music/"+ episodeRequested +".MP3");

        //Delete file
        file.delete();


        //Restart current activity
        Intent intent = getIntent();
        finish();
        startActivity(intent);


    }

    public void closeDesc(View view) {

        //Make the description layout invisible
        DescLayout = (RelativeLayout) findViewById(R.id.relDescriptionLayout);
        episodeGrid = (GridLayout) findViewById(R.id.gridEpisodes);

        //Make the episode layout visable
        DescLayout.setVisibility(View.INVISIBLE);
        episodeGrid.setVisibility(View.VISIBLE);


    }


    public void closeDescS2(View view){

        //Method is identical to closeDesc()

        DescLayout = (RelativeLayout)findViewById(R.id.relDescriptionLayoutS2);
        episodeGrid = (GridLayout)findViewById(R.id.gridEpisodesS2) ;

        DescLayout.setVisibility(View.INVISIBLE);
        episodeGrid.setVisibility(View.VISIBLE);


    }

    public void closeDescS3(View view){

        //Method is identical to closeDesc()


        DescLayout = (RelativeLayout)findViewById(R.id.relDescriptionLayoutS3);
        episodeGrid = (GridLayout)findViewById(R.id.gridEpisodesS3) ;

        DescLayout.setVisibility(View.INVISIBLE);
        //cusView.setVisibility(View.VISIBLE);
        episodeGrid.setVisibility(View.VISIBLE);


    }

    public void closeDescS4(View view){

        //Method is identical to closeDesc()


        DescLayout = (RelativeLayout)findViewById(R.id.relDescriptionLayoutS4);
        episodeGrid = (GridLayout)findViewById(R.id.gridEpisodesS4) ;

        DescLayout.setVisibility(View.INVISIBLE);
        //cusView.setVisibility(View.VISIBLE);
        episodeGrid.setVisibility(View.VISIBLE);


    }

    public void closeDescS5(View view){

        //Method is identical to closeDesc()


        DescLayout = (RelativeLayout)findViewById(R.id.relDescriptionLayoutS5);
        episodeGrid = (GridLayout)findViewById(R.id.gridEpisodesS5) ;

        DescLayout.setVisibility(View.INVISIBLE);
        //cusView.setVisibility(View.VISIBLE);
        episodeGrid.setVisibility(View.VISIBLE);


    }





    private class DownloadTask extends AsyncTask<String, Integer, String> {

        //This method deals with the downloading of the episode in a seperate thread.
        //A post on StackOverflow was used to help with this method

        private Context context;
        private PowerManager.WakeLock mWakeLock;

        public DownloadTask(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(String... sUrl) {
            InputStream input = null;
            OutputStream output = null;
            HttpURLConnection connection = null;
            try {
                URL url = new URL(sUrl[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                // expect HTTP 200 OK, so we don't mistakenly save error report
                // instead of the file
                if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    return "Server returned HTTP " + connection.getResponseCode()
                            + " " + connection.getResponseMessage();
                }

                // this will be useful to display download percentage
                // might be -1: server did not report the length
                int fileLength = connection.getContentLength();

                // download the file
                input = connection.getInputStream();
                output = new FileOutputStream("/sdcard/music/"+ downloadName +".MP3");

                byte data[] = new byte[4096];
                long total = 0;
                int count;
                while ((count = input.read(data)) != -1) {
                    // allow canceling with back button
                    if (isCancelled()) {
                        input.close();
                        return null;
                    }
                    total += count;
                    // publishing the progress....
                    if (fileLength > 0) // only if total length is known
                        publishProgress((int) (total * 100 / fileLength));
                    output.write(data, 0, count);
                }
            } catch (Exception e) {
                return e.toString();
            } finally {
                try {
                    if (output != null)
                        output.close();
                    if (input != null)
                        input.close();
                } catch (IOException ignored) {
                }

                if (connection != null)
                    connection.disconnect();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // take CPU lock to prevent CPU from going off if the user
            // presses the power button during download
            PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                    getClass().getName());
            mWakeLock.acquire();
            mProgressDialog.show();
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            super.onProgressUpdate(progress);
            // if we get here, length is known, now set indeterminate to false
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.setMax(100);
            mProgressDialog.setProgress(progress[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            mWakeLock.release();

            mProgressDialog.dismiss();
            if (result != null)
                Toast.makeText(context,"Download error: "+result, Toast.LENGTH_LONG).show();
            else
                Toast.makeText(context,"File downloaded", Toast.LENGTH_SHORT).show();
        }

    }



    public void buttonClicked(View view){
        final DownloadTask downloadTask = new DownloadTask(MainActivity.this);
        downloadName =  view.getTag().toString();

        //Toast to user to try apeal for donations
        Toast.makeText(getApplicationContext(), "This app is free and features NO ads, please donate to keep it this way!", Toast.LENGTH_LONG).show();


        //Change the text on the download button to "play" to reflect the new role
        Button pressed = (Button) view;
        pressed.setText("Play");


        //Check to see if the requested file exists on the device
       File file = new File("/sdcard/music/"+downloadName+".MP3");
        if(file.exists()){

            //If the file exists then it should be played
        System.out.println("Play Content here");


            //Play the media file on the users default media player
            Intent intent = new Intent();
            intent.setAction(android.content.Intent.ACTION_VIEW);
            File file1 = new File("/sdcard/music/"+downloadName+".MP3");
            intent.setDataAndType(Uri.fromFile(file1), "audio/*");
            startActivity(intent);

        }else{

            //If the file does not exist then it will be downloaded from the web
            System.out.println("DOES NOT EXIST");
            System.out.println("http://files.liamure.xyz/" + view.getTag().toString());
            downloadTask.execute("http://files.liamure.xyz/" + view.getTag().toString() + ".mp3");



            mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    downloadTask.cancel(true);
                }
            });
        }

    }



    protected boolean shouldAskPermissions() {
        //Thus method checks the  if version of androud the user is currently using above Lollipop
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    @TargetApi(23)
    protected void askPermissions() {
        //This methiod will ask the user if they accept that the app will need to write to and read from external storage devices

        String[] permissions = {
                "android.permission.READ_EXTERNAL_STORAGE", // Used for opening the files
                "android.permission.WRITE_EXTERNAL_STORAGE" // Used for saving the files
        };
        int requestCode = 200;
        requestPermissions(permissions, requestCode);

    }

    public void OpenChangeLog(MenuItem item){
        //This method opens the Changelog activity
        Intent myIntent = new Intent(this, ChangeLog.class);
        startActivity(myIntent);
    }

    public void OpenPodcasts(MenuItem item){
        //This method opens the Podcasts activity

        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

    public void OpenRadio(MenuItem item){
        //This method opens the Raidio Shows activity

        Intent myIntent = new Intent(this, RadioActivity.class);
        startActivity(myIntent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        //This method inflates the overflow menu
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public void openDonate(MenuItem item){
        //This method opens the web browser and takes them to a page where they may donate

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://liamure.xyz/donate.html"));
        startActivity(browserIntent);
    }

    public void openSettings(MenuItem item){

        //This method opens the Settings activity

        Intent myIntent = new Intent(this, Settings.class);
        startActivity(myIntent);
    }


    public void checkFirstRun() {
        boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRunASSA", true);
        if (isFirstRun){
            // Place your dialog code here to display the dialog
            AlertDialog alertDialog = new AlertDialog.Builder(
                    MainActivity.this).create();

            // Setting Dialog Title
            alertDialog.setTitle("Play Shows in background");

            // Setting Dialog Message
            alertDialog.setMessage("If you are having trouble getting the shows to play in the background, download BlackPlayer from the Google Play store. " +
                    "After that select it when you play a show and you will be able to close the app.");


            // Setting OK Button
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Write your code here to execute after dialog closed
                    Toast.makeText(getApplicationContext(), "Please leave a review on the store page", Toast.LENGTH_SHORT).show();
                }
            });

            /*alertDialog.setButton("OK, Dont be showing me again", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Write your code here to execute after dialog closed
                    Toast.makeText(getApplicationContext(), "Please leave a review on the store page", Toast.LENGTH_SHORT).show();

                    getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                           .edit()
                       .putBoolean("isFirstRun", false)
                       .apply();

                }
            });*/

            // Showing Alert Message
            alertDialog.show();




        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Database is opened or created
        eventsDB = this.openOrCreateDatabase("App2", MODE_PRIVATE, null);
        //Database creation is started
        createDB();

        //Set up the UI elements
        toolbar = (Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Add all fragments to the view pager
        viewPagerAdapter.addFragments(new Season1Fragment(),"Season 1");
        viewPagerAdapter.addFragments(new Season2Fragment(),"Season 2");
        viewPagerAdapter.addFragments(new Season3Fragment(),"Season 3");
        viewPagerAdapter.addFragments(new Season4Fragment(),"Season 4");
       viewPagerAdapter.addFragments(new Season5Fragment(),"Season 5");


        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        cusView =  (View)findViewById(R.id.view);

        //Check if the app needs to ask for any permissions
        if (shouldAskPermissions()) {
            //if true, ask
            askPermissions();
        }

        //Build the progress dialog
        mProgressDialog = new ProgressDialog(MainActivity.this);
        mProgressDialog.setMessage("Downloading your episode now!");
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.setCancelable(false);


        //Check to see if the user has a music directory and create one if it does not
        File folder = new File(Environment.getExternalStorageDirectory() + "/Music");
        boolean success = true;
        if (!folder.exists()) {
            success = folder.mkdir();
        }
        if (success) {
            Log.i("dir creation proc", "Directory Created");
        } else {
            Log.i("dir creation proc", "Directory Exists");
        }

        //Remind users that donations are accepted
        Toast.makeText(getApplicationContext(), "This app is free and features NO ads, please donate to keep it this way!", Toast.LENGTH_LONG).show();
        checkFirstRun();


    }



}
