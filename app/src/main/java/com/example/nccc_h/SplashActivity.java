package com.example.nccc_h;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1000;
    int year,month,day,hour,minute;
    boolean isFirst;
    boolean firstCheck = true;
    FirstUserCheck firstUserCheck;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //   ActivityCompat.requestPermissions(SplashActivity.this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},0);
        GregorianCalendar calendar = new GregorianCalendar();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day= calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        firstUserCheck = new FirstUserCheck();

        final String userID = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
        String result;

        try{
            result = firstUserCheck.execute(userID).get();
            if(result.equals("N")){
                Log.i("hihi","nnnnnnnnnnnnnnnnnnnnn");
                isFirst = true;
            } else if(result.equals("Y")){
                Log.i("hihi","yyyyyyyyyyyyyyyyyyyyy");
                isFirst = false;
            } else {
                Log.i("hihi",""+result);
            }
            firstCheck = false;
        } catch (Exception e){
            Log.i("hihi", ""+e);
        }

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                while(firstCheck);
                if(isFirst){
                    Intent intent = new Intent(getApplicationContext(), HotelGrasp.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        }, SPLASH_TIME_OUT);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    class FirstUserCheck extends AsyncTask<String, Void, String> {

        String sendMsg, receiveMsg;

        @Override
        protected String doInBackground(String... strings) {
            try {
                String str;
                URL url = new URL("http://222.116.135.77:8080/NCCC_H/firstusercheck.jsp");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "apllication/x-www-form-urlencoded");
                conn.setRequestMethod("POST");

                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());

                //전송할 데이터. GET 방식으로 작성
                sendMsg = "userid="+strings[0];
                osw.write(sendMsg);
                osw.flush();

                //jsp와 통신 성공 시 수행
                if(conn.getResponseCode() == conn.HTTP_OK) {
                    InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    BufferedReader reader = new BufferedReader(tmp);
                    StringBuffer buffer = new StringBuffer();

                    while ((str = reader.readLine()) != null) {
                        buffer.append((str));
                    }
                    receiveMsg = buffer.toString();

                } else {
                    Log.i("통신 결과", conn.getResponseCode()+"에러");
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //jsp로부터 받은 리턴 값
            return receiveMsg;
        }
    }
}
