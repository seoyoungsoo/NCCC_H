package com.example.nccc_h;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

//test
public class MainActivity extends AppCompatActivity {

    ImageView mainImage;

    RatingBar mainRating;

    TextView hotelName;
    TextView cityName;

    Button hotelRecm;
    Button hotelSrch;

    LinearLayout addshow_layout;

    String result;
    String result2;
    String hotelcode;
    String hotelname;
    String citycode;
    String starscore;

    MainTask mainTask = new MainTask();
    MainTask2 mainTask2 = new MainTask2();

    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userID = getDeviceId();

        getJsonData();
        if (hotelcode != null && starscore != null) {
            getJsonData2();
        } else {
            Log.e(userID, "ererererererer");
        }
        setMain();
        setButton();

    }

    public String getDeviceId() {
        String userId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        return userId;
    }

    private void setButton() {
        hotelRecm = (Button) findViewById(R.id.main_first_button);
        hotelRecm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {  // AI 전체보기
                Intent intent = new Intent(getApplicationContext(), HotelAllView.class);
                intent.putExtra("userID", userID);
                startActivity(intent);
            }
        });

        hotelSrch = (Button) findViewById(R.id.main_second_button);
        hotelSrch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // AI 검색
                Intent intent = new Intent(getApplicationContext(), HotelReservation.class);
                intent.putExtra("userID", userID);
                startActivity(intent);
            }
        });

        addshow_layout = (LinearLayout) findViewById(R.id.main_addshow_layout);
        addshow_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 더보기
                Intent intent = new Intent(getApplicationContext(), HotelDetail.class);
                //호텔 정보 putExtra
                intent.putExtra("citycode", citycode);
                intent.putExtra("hotelcode", hotelcode);
                intent.putExtra("hotelname", hotelname);
                intent.putExtra("userID", userID);
                startActivity(intent);
            }
        });
    }

    public void getJsonData() {
        String k;
        try {
            result = mainTask.execute(userID).get();
            JSONArray jsonArray = new JSONObject(result).getJSONArray(userID);

            JSONObject jsonObject = jsonArray.getJSONObject(0);

            hotelcode = jsonObject.getString("hotelcode");
            k = (jsonObject.getString("starscore"));

            float a = Float.parseFloat(k);
            if (a > 5.0) {
                starscore = "5.0";
            } else {
                starscore = String.format("%.1f", a);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void getJsonData2() {
        String j;
        try {
            result2 = mainTask2.execute(userID, hotelcode).get();
            JSONArray jsonArray = new JSONObject(result2).getJSONArray(userID);

            JSONObject jsonObject = jsonArray.getJSONObject(0);

            hotelname = jsonObject.getString("hotelname");
            j = jsonObject.getString("citycode");
            if(j.contains("DaL")) {
                citycode = "달랏";
            } else if(j.contains("DaN")) {
                citycode = "다낭";
            } else if(j.contains("Ha")) {
                citycode = "하노이";
            } else if(j.contains("Nha")) {
                citycode = "나트랑";
            } else if(j.contains("Hoi")) {
                citycode = "호이안";
            } else {
                citycode = "호치민";
            }

            Log.i(hotelname, hotelname);
            Log.i(citycode, citycode);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void setMain() {
        mainImage = (ImageView) findViewById(R.id.main_image);
        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo1/"+hotelcode+".jpg")
                .into(mainImage);

        mainRating = (RatingBar) findViewById(R.id.main_rating);
        mainRating.setRating(Float.parseFloat(starscore));

        hotelName = (TextView) findViewById(R.id.main_hotel_name);
        hotelName.setText(hotelname);

        cityName = (TextView) findViewById(R.id.main_city_name);
        cityName.setText(citycode);
    }

    class MainTask extends AsyncTask<String, Void, String> {

        StringBuffer buffer = new StringBuffer();
        String sendMsg;
        String receiveMsg = "";

        @Override
        protected String doInBackground(String... strings) {
            try {
                String str;
                URL url = new URL("http://222.116.135.77:8080/NCCC_H/mainpage.jsp");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestMethod("POST");

                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());

                sendMsg = "userid="+strings[0];
                osw.write(sendMsg);
                osw.flush();

                if(conn.getResponseCode() == conn.HTTP_OK) {
                    InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    BufferedReader reader = new BufferedReader(tmp);

                    while (true) {
                        str = reader.readLine();
                        if (str == null)
                            break;
                        buffer.append(str);
                    }
                    reader.close();
                    conn.disconnect();

                } else {
                    Log.i("통신 결과", conn.getResponseCode()+"에러");
                }
                receiveMsg = buffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return receiveMsg;
        }
    }

    class MainTask2 extends AsyncTask<String, Void, String> {

        StringBuffer buffer = new StringBuffer();
        String sendMsg;
        String receiveMsg = "";

        @Override
        protected String doInBackground(String... strings) {
            try {
                String str;
                URL url = new URL("http://222.116.135.77:8080/NCCC_H/mainpage2.jsp");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestMethod("POST");

                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());

                sendMsg = "userid="+strings[0]+"&hotelcode="+strings[1];
                osw.write(sendMsg);
                osw.flush();

                if(conn.getResponseCode() == conn.HTTP_OK) {
                    InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    BufferedReader reader = new BufferedReader(tmp);

                    while (true) {
                        str = reader.readLine();
                        if (str == null)
                            break;
                        buffer.append(str);
                    }
                    reader.close();
                    conn.disconnect();

                } else {
                    Log.i("통신 결과", conn.getResponseCode()+"에러");
                }
                receiveMsg = buffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return receiveMsg;
        }
    }
}
