package com.example.nccc_h;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
//test
public class MainActivity extends AppCompatActivity {

    Button hotelRecm;
    Button hotelSrch;

    LinearLayout addshow_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFirst();

    }

    private void setFirst() {
        hotelRecm = (Button) findViewById(R.id.main_first_button);
        hotelRecm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HotelAllListview.class);
                startActivity(intent);
            }
        });

        hotelSrch = (Button) findViewById(R.id.main_second_button);
        hotelSrch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HotelReservation.class);
                startActivity(intent);
            }
        });

        addshow_layout = (LinearLayout) findViewById(R.id.main_addshow_layout);
        addshow_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HotelDetail.class);
                startActivity(intent);
            }
        });
    }

    class Task extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... strings) {
            try {
                String str;
                URL url = new URL("jsp 경로"); // 보낼 jsp 주소를 작성
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestMethod("POST"); //데이터를 POST 방식으로 전송


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
