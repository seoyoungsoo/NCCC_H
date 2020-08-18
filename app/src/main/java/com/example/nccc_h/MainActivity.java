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
            public void onClick(View v) {  // AI 전체보기
                Intent intent = new Intent(getApplicationContext(), HotelAllListview.class);
                startActivity(intent);
            }
        });

        hotelSrch = (Button) findViewById(R.id.main_second_button);
        hotelSrch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // AI 검색
                Intent intent = new Intent(getApplicationContext(), HotelReservation.class);
                startActivity(intent);
            }
        });

        addshow_layout = (LinearLayout) findViewById(R.id.main_addshow_layout);
        addshow_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 더보기
                Intent intent = new Intent(getApplicationContext(), HotelDetail.class);
                //호텔 정보 putExtra
                startActivity(intent);
            }
        });
    }
}
