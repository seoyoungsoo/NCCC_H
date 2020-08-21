package com.example.nccc_h;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1000;
    boolean isFirst;
    boolean firstCheck = true;

    Handler handler = new Handler();
    FirstUserCheck firstUserCheck = new FirstUserCheck();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final String userID = getDeviceId();
        String result;

        try {
            result = firstUserCheck.execute(userID).get();
            if(result.equals("N")){
                Log.i("hihi", "nnnnnnnnnnnnnnnnnnnnn");
                isFirst = true;
            } else if(result.equals("Y")){
                Log.i("hihi", "yyyyyyyyyyyyyyyyyyyyy");
                isFirst = false;
            } else {
                Log.i("hihi", ""+result);
            }
            firstCheck = false;
        } catch (Exception e){
            e.printStackTrace();
        }

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                while(firstCheck);
                if(isFirst){
                    Intent intent = new Intent(SplashActivity.this, HotelGrasp.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    i.putExtra("userID", userID);
                    startActivity(i);
                    finish();
                }
            }
        }, SPLASH_TIME_OUT);

    }

    public String getDeviceId() {
        String userId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        return userId;
    }

    class FirstUserCheck extends AsyncTask<String, Void, String> {

        String sendMsg, receiveMsg;

        @Override
        protected String doInBackground(String... strings) {
            try {
                String str;
                URL url = new URL("http://222.116.135.77:8080/NCCC_H/firstusercheck.jsp");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());

                //GET 방식으로 작성
                sendMsg = "userid=" + strings[0];
                osw.write(sendMsg);
                osw.flush();

                if (conn.getResponseCode() == conn.HTTP_OK) {
                    InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    BufferedReader reader = new BufferedReader(tmp);
                    StringBuffer buffer = new StringBuffer();

                    while ((str = reader.readLine()) != null) {
                        buffer.append(str);
                    }
                    receiveMsg = buffer.toString();
                } else {
                    Log.i("통신 결과", conn.getResponseCode() + "에러");
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //jsp로부터 받은 리턴 값
            return receiveMsg;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }



}

