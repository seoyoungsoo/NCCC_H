package com.example.nccc_h;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class HotelReservation extends AppCompatActivity {

    private Spinner spinner_city;
    private Spinner spinner_type;
    private Spinner spinner_value;

    ArrayList<String> arrayListCity;
    ArrayList<String> arrayListType;
    ArrayList<String> arrayListValue;

    ArrayAdapter<String> arrayAdapterCity;
    ArrayAdapter<String> arrayAdapterType;
    ArrayAdapter<String> arrayAdapterValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_reservation);

        SetSpinner();
    }

    private void SetSpinner() {
        arrayAdapterCity = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, arrayListCity);
        spinner_city = (Spinner)findViewById(R.id.hotel_reservation_city);
        spinner_city.setAdapter(arrayAdapterCity);
        spinner_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), arrayListCity.get(position)+"가 선택됐습니다.",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        arrayAdapterType = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, arrayListType);
        spinner_type = (Spinner)findViewById(R.id.hotel_reservation_type);
        spinner_type.setAdapter(arrayAdapterType);
        spinner_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), arrayListType.get(position)+"가 선택됐습니다.",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        arrayAdapterValue = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, arrayListValue);
        spinner_value = (Spinner)findViewById(R.id.hotel_reservation_value);
        spinner_value.setAdapter(arrayAdapterValue);
        spinner_value.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), arrayListValue.get(position)+"가 선택됐습니다.",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
