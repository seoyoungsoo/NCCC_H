package com.example.nccc_h;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

    String cityValue = "";
    String typeValue = "";

    Button searchBtn;
    Button cancelBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_reservation);

        setFirst();
        setSpinner();

    }

    private void setSpinner() {
        spinCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cityValue = spinCity.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                typeValue = spinType.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setFirst() {
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
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HotelRecommendListview.class);
                intent.putExtra("cityValue", cityValue);
                intent.putExtra("typeValue", typeValue);
                startActivity(intent);
                finish();
            }
        });
    }

}
