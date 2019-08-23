package com.liamure.podcasteron.podcasteron;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.PowerManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
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
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExtraActivity extends AppCompatActivity {

    //Sets up the vars for the download process

    ProgressDialog mProgressDialog;
    String downloadName;

    //Sets up vars used for the User Interface

    int currentScroll;
    ScrollView scrollview;
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

            Log.i("radioResults - descr","Created DB");



            eventsDB.execSQL("CREATE TABLE IF NOT EXISTS desc (episode VARCHAR, date VARCHAR, descr VARCHAR)");
            eventsDB.execSQL("DELETE FROM desc");

//            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-1', '', '')");

            //                              RADIO 1 Inserts data into the DB
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Extra-1-Episode-1', '30 December 2008', 'A fella with no arms and legs needs Karls help havin it away with his lover. Karl comes up with a new way for doctors to administer diagnoses.')");






//WHERE episode = 'Season-2-Episode-1'

            //Test of the DB. Logs info to the IDE
            Cursor c = eventsDB.rawQuery("SELECT * FROM desc WHERE episode = 'Radio-1-Episode-1'", null);

            int episodeIndex = c.getColumnIndex("episode");
            int dateIndex = c.getColumnIndex("date");
            int descIndex = c.getColumnIndex("descr");


            c.moveToFirst();

            //Test of the DB. Logs info to the IDE


            while (c != null) {

                Log.i("rrrResults - episode", c.getString(episodeIndex));
                Log.i("Results - date", c.getString(dateIndex));
                Log.i("Results - descr", c.getString(descIndex));


                c.moveToNext();
            }


        }
        catch (Exception e) {

            e.printStackTrace();

        }




    }





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
        scrollview = (ScrollView)findViewById(R.id.r1Scroll);
        currentScroll = scrollview.getScrollY();

        //Return to top of scrollview
        scrollview.scrollTo(0, scrollview.getTop());


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
        WebView webView = (WebView) findViewById(R.id.webView6);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        webView.loadUrl("http://liamure.net23.net/rsk/rsk2.html?ep=" + episodeRequested);
        Log.i("http requested", "http://liamure.net23.net/rsk/rsk2.html?ep=" + episodeRequested);


    }

    public void showMediaDataR2(View view){

        //This method is currently almost identical to showMediaData()

        DescLayout = (RelativeLayout)findViewById(R.id.relDescriptionLayoutR2);
        episodeGrid = (GridLayout)findViewById(R.id.gridEpisodesR2) ;
        textViewDesc = (TextView)findViewById(R.id.txtDescR2);
        textViewDescDate = (TextView)findViewById(R.id.txtDateR2);
        textViewDescTitle = (TextView)findViewById(R.id.txtTitleR2);
        episodeGrid.setVisibility(View.INVISIBLE);
        DescLayout.setVisibility(View.VISIBLE);
        episodeRequested = view.getTag().toString();

        scrollview = (ScrollView)findViewById(R.id.r2Scroll);
        currentScroll = scrollview.getScrollY();



        scrollview.scrollTo(0, scrollview.getTop());



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
        WebView webView = (WebView) findViewById(R.id.webView7);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        webView.loadUrl("http://liamure.net23.net/rsk/rsk2.html?ep=" + episodeRequested);
        Log.i("http requested", "http://liamure.net23.net/rsk/rsk2.html?ep=" + episodeRequested);


    }

    public void showMediaDataR3(View view){

        //This method is currently almost identical to showMediaData()


        DescLayout = (RelativeLayout)findViewById(R.id.relDescriptionLayoutR3);
        episodeGrid = (GridLayout)findViewById(R.id.gridEpisodesR3) ;
        textViewDesc = (TextView)findViewById(R.id.txtDescR3);
        textViewDescDate = (TextView)findViewById(R.id.txtDateR3);
        textViewDescTitle = (TextView)findViewById(R.id.txtTitleR3);
        episodeGrid.setVisibility(View.INVISIBLE);
        DescLayout.setVisibility(View.VISIBLE);
        episodeRequested = view.getTag().toString();

        scrollview = (ScrollView)findViewById(R.id.r3Scroll);
        currentScroll = scrollview.getScrollY();



        scrollview.scrollTo(0, scrollview.getTop());



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
        WebView webView = (WebView) findViewById(R.id.webView8);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        webView.loadUrl("http://liamure.net23.net/rsk/rsk2.html?ep=" + episodeRequested);
        Log.i("http requested", "http://liamure.net23.net/rsk/rsk2.html?ep=" + episodeRequested);


    }


    public void showMediaDataR4(View view){

        //This method is currently almost identical to showMediaData()


        DescLayout = (RelativeLayout)findViewById(R.id.relDescriptionLayoutR4);
        episodeGrid = (GridLayout)findViewById(R.id.gridEpisodesR4) ;
        textViewDesc = (TextView)findViewById(R.id.txtDescR4);
        textViewDescDate = (TextView)findViewById(R.id.txtDateR4);
        textViewDescTitle = (TextView)findViewById(R.id.txtTitleR4);
        episodeGrid.setVisibility(View.INVISIBLE);
        DescLayout.setVisibility(View.VISIBLE);
        episodeRequested = view.getTag().toString();

        scrollview = (ScrollView)findViewById(R.id.r4Scroll);
        currentScroll = scrollview.getScrollY();



        scrollview.scrollTo(0, scrollview.getTop());



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
        WebView webView = (WebView) findViewById(R.id.webView9);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        webView.loadUrl("http://liamure.net23.net/rsk/rsk2.html?ep=" + episodeRequested);
        Log.i("http requested", "http://liamure.net23.net/rsk/rsk2.html?ep=" + episodeRequested);


    }


    public void closeDesc(View view) {

        DescLayout = (RelativeLayout) findViewById(R.id.relDescriptionLayout);
        episodeGrid = (GridLayout) findViewById(R.id.gridEpisodes);

        scrollview = (ScrollView)findViewById(R.id.r1Scroll);
        scrollview.scrollTo(0, currentScroll);

        DescLayout.setVisibility(View.INVISIBLE);
        //cusView.setVisibility(View.VISIBLE);
        episodeGrid.setVisibility(View.VISIBLE);


    }


    public void closeDescR2(View view) {

        DescLayout = (RelativeLayout) findViewById(R.id.relDescriptionLayoutR2);
        episodeGrid = (GridLayout) findViewById(R.id.gridEpisodesR2);
        // episodeGrid = (GridLayout) findViewById(R.id.gridEpisodes);

        scrollview = (ScrollView)findViewById(R.id.r2Scroll);
        scrollview.scrollTo(0, currentScroll);




        DescLayout.setVisibility(View.INVISIBLE);
        //cusView.setVisibility(View.VISIBLE);
        episodeGrid.setVisibility(View.VISIBLE);

    }

    public void closeDescR3(View view) {

        DescLayout = (RelativeLayout) findViewById(R.id.relDescriptionLayoutR3);
        episodeGrid = (GridLayout) findViewById(R.id.gridEpisodesR3);
        // episodeGrid = (GridLayout) findViewById(R.id.gridEpisodes);

        scrollview = (ScrollView)findViewById(R.id.r3Scroll);
        scrollview.scrollTo(0, currentScroll);




        DescLayout.setVisibility(View.INVISIBLE);
        //cusView.setVisibility(View.VISIBLE);
        episodeGrid.setVisibility(View.VISIBLE);

    }

    public void closeDescR4(View view) {

        DescLayout = (RelativeLayout) findViewById(R.id.relDescriptionLayoutR4);
        episodeGrid = (GridLayout) findViewById(R.id.gridEpisodesR4);
        // episodeGrid = (GridLayout) findViewById(R.id.gridEpisodes);

        scrollview = (ScrollView)findViewById(R.id.r4Scroll);
        scrollview.scrollTo(0, currentScroll);




        DescLayout.setVisibility(View.INVISIBLE);
        //cusView.setVisibility(View.VISIBLE);
        episodeGrid.setVisibility(View.VISIBLE);

    }

    private class DownloadTask extends AsyncTask<String, Integer, String> {

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
        final ExtraActivity.DownloadTask downloadTask = new ExtraActivity.DownloadTask(ExtraActivity.this);
        downloadName =  view.getTag().toString();


        Toast.makeText(getApplicationContext(), "This app is free and features NO ads, please donate to keep it this way!", Toast.LENGTH_LONG).show();




        File file = new File("/sdcard/music/"+downloadName+".MP3");
        if(file.exists()){
            System.out.println("Play Content here");

            Intent intent = new Intent();
            intent.setAction(android.content.Intent.ACTION_VIEW);
            File file1 = new File("/sdcard/music/"+downloadName+".MP3");

            intent.setDataAndType(Uri.fromFile(file1), "audio/*");
            startActivity(intent);

        }else{

            System.out.println("DOES NOT EXIST");
            System.out.println("http://files.liamure.xyz/" + view.getTag().toString());
            downloadTask.execute("http://files.liamure.xyz/" + view.getTag().toString() + ".mp3");
            Button pressed = (Button) view;

            pressed.setText("Play");
            mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    downloadTask.cancel(true);
                }
            });
        }

    }

    protected boolean shouldAskPermissions() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    @TargetApi(23)
    protected void askPermissions() {
        String[] permissions = {
                "android.permission.READ_EXTERNAL_STORAGE",
                "android.permission.WRITE_EXTERNAL_STORAGE"
        };
        int requestCode = 200;
        requestPermissions(permissions, requestCode);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        eventsDB = this.openOrCreateDatabase("App8908734", MODE_PRIVATE, null);


        createDB();


        toolbar = (Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new Extra1Fragment(),"Guides");








        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        cusView =  (View)findViewById(R.id.view);


        if (shouldAskPermissions()) {
            askPermissions();
        }




        mProgressDialog = new ProgressDialog(ExtraActivity.this);
        mProgressDialog.setMessage("Downloading your episode now!");
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.setCancelable(true);

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


        Toast.makeText(getApplicationContext(), "This app is free and features NO ads, please donate to keep it this way!", Toast.LENGTH_LONG).show();



    }

    public void deleteEpisode(View view){

        //This method allows a user to delete an individual episode



        File file = new File("/sdcard/music/"+ episodeRequested +".MP3");
        Log.i("DELETE", "/sdcard/music/"+ episodeRequested +".MP3");
        file.delete();



        Intent intent = getIntent();
        finish();
        startActivity(intent);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public void OpenChangeLog(MenuItem item){
        Intent myIntent = new Intent(this, ChangeLog.class);
        startActivity(myIntent);
    }

    public void OpenPodcasts(MenuItem item){
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

    public void OpenRadio(MenuItem item){
        Intent myIntent = new Intent(this, RadioActivity.class);
        startActivity(myIntent);
    }

    public void openDonate(MenuItem item){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://liamure.net23.net/donate.html"));
        startActivity(browserIntent);
    }

    public void openSettings(MenuItem item){
        Intent myIntent = new Intent(this, Settings.class);
        startActivity(myIntent);
    }
    public void openExtras(MenuItem item){
        Intent myIntent = new Intent(this, ExtraActivity.class);
        startActivity(myIntent);
    }





}
