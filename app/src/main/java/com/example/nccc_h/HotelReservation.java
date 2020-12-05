package com.example.nccc_h;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.jaygoo.widget.RangeSeekBar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class HotelReservation extends AppCompatActivity {

    Spinner spinCity;
    Spinner spinType;

    String cityValue = "전체";
    String typeValue = "전체 이용후기";
    String min;
    String max;

    Button searchBtn;
    Button cancelBtn;

    EditText minPrice;
    EditText maxPrice;

    int minT;
    int maxT;

    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_reservation);

        userID = getIntent().getStringExtra("userID");

        setFirst();
        setSpinner();

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (minPrice.getText().toString().equals("") || maxPrice.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "가격을 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    minT = Integer.parseInt(minPrice.getText().toString());
                    maxT = Integer.parseInt(maxPrice.getText().toString());

                    if (minT > maxT || minT < 0 || minT > 2000000 || maxT < 0 || maxT > 2000000) {
                        Toast.makeText(getApplicationContext(), "범위에 맞는 가격을 다시 입력해주세요.", Toast.LENGTH_SHORT).show();
                    } else {
                        min = minPrice.getText().toString();
                        max = maxPrice.getText().toString();

                        Intent intent = new Intent(getApplicationContext(), HotelRecomView.class);
                        intent.putExtra("userID", userID);
                        intent.putExtra("cityValue", cityValue);
                        intent.putExtra("typeValue", typeValue);
                        intent.putExtra("min", min);
                        intent.putExtra("max", max);
                        Log.i(min, max);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });

    }

    public String getDeviceId() {
        String userId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        return userId;
    }

    private void setSpinner() {
        spinCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinCity.getSelectedItem().toString().equals("달랏")) {
                    cityValue = "DaL";
                } else if (spinCity.getSelectedItem().toString().equals("다낭")) {
                    cityValue = "DaN";
                } else if (spinCity.getSelectedItem().toString().equals("나트랑")) {
                    cityValue = "Nha";
                } else if (spinCity.getSelectedItem().toString().equals("하노이")) {
                    cityValue = "Ha";
                } else if (spinCity.getSelectedItem().toString().equals("호이안")) {
                    cityValue = "Hoi";
                } else if (spinCity.getSelectedItem().toString().equals("호치민")) {
                    cityValue = "Ho";
                } else {
                    cityValue = "전체";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    typeValue = "전체 이용후기";
                } else {
                    typeValue = spinType.getSelectedItem().toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setFirst() {
        minPrice = (EditText) findViewById(R.id.reservation_min_price);
        maxPrice = (EditText) findViewById(R.id.reservation_max_price);

        searchBtn = (Button) findViewById(R.id.hotel_reservation_search);
        cancelBtn = (Button) findViewById(R.id.hotel_reservation_cancel);

        spinCity = (Spinner) findViewById(R.id.hotel_reservation_city);

        ArrayAdapter cityAdapter = ArrayAdapter.createFromResource(this, R.array.city,
                android.R.layout.simple_spinner_dropdown_item);
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinCity.setAdapter(cityAdapter);
        spinCity.setSelection(0);
        cityValue = spinCity.getSelectedItem().toString();

        spinType = (Spinner) findViewById(R.id.hotel_reservation_type);

        ArrayAdapter typeAdapter = ArrayAdapter.createFromResource(this, R.array.type,
                android.R.layout.simple_spinner_dropdown_item);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinType.setAdapter(typeAdapter);
        spinType.setSelection(0);
        typeValue = spinType.getSelectedItem().toString();

        cancelBtn = (Button) findViewById(R.id.hotel_reservation_cancel);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        searchBtn = (Button) findViewById(R.id.hotel_reservation_search);
    }

}
