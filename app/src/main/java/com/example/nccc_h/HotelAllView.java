package com.example.nccc_h;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;

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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class HotelAllView extends AppCompatActivity {

    private ArrayList<Hotel> hotelList;
    private HotelAdapter adapter;

    HotelView hotelView = new HotelView();

    String userID;
    String min;
    String max;

    String result;

    int i, count, co;

    List<String> hotelcode = new ArrayList<>();
    List<String> starscore = new ArrayList<>();

    List<String> cityname = new ArrayList<>();
    List<String> hotelname = new ArrayList<>();
    List<String> price = new ArrayList<>();

    JSONArray jsonArray;

    ImageView addShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_all_view);

        Intent intent = getIntent();
        userID = intent.getStringExtra("userID");
        min = intent.getStringExtra("min");
        max = intent.getStringExtra("max");

        addShow = (ImageView) findViewById(R.id.hotel_addshow);

        this.getHotelJsonData();
        this.InitializeData();

        //recyclerView 초기화
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.hotel_all_view);

        LinearLayoutManager manager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(manager);
        //recyclerView.setAdapter(new HotelAdapter(hotelList));

        adapter = new HotelAdapter(hotelList);
        adapter.setOnItemClickListener(new HotelAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent i = new Intent(getApplicationContext(), HotelDetail.class);
                i.putExtra("userID", userID);
                i.putExtra("hotelcode", hotelcode.get(position));
                i.putExtra("hotelname", hotelname.get(position));
                i.putExtra("cityname", cityname.get(position));
                i.putExtra("price", price.get(position));
                startActivity(i);
            }
        });

        recyclerView.setAdapter(adapter);
    }

    public void getHotelJsonData() {
        try {
            String j;
            result = hotelView.execute(userID, min, max).get();
            jsonArray = new JSONObject(result).getJSONArray(userID);

            if (jsonArray != null) {
                for (i = 0; i < jsonArray.length() ; i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    hotelcode.add(jsonObject.getString("hotelcode"));
                    price.add(jsonObject.getString("price"));
                    hotelname.add(jsonObject.getString("hotelname"));
                    //starscore 0~5지만 json의 경우 10까지나오는 경우의 문제점 해결필요 //문제 해결
                    starscore.add(jsonObject.getString("starscore"));

                    j = jsonObject.getString("hotelcode");
                    if(j.contains("DaL")) {
                        cityname.add("달랏");
                    } else if(j.contains("DaN")) {
                        cityname.add("다낭");
                    } else if(j.contains("Ha")) {
                        cityname.add("하노이");
                    } else if(j.contains("Nha")) {
                        cityname.add("나트랑");
                    } else if(j.contains("Hoi")) {
                        cityname.add("호이안");
                    } else {
                        cityname.add("호치민");
                    }
                    //해결방안 1
                    /*j = jsonObject.getString("starscore");
                    k = Float.parseFloat(j);

                    if (k >= 9.7) {
                        starscore.add(i, "5");
                    } else if (k < 9.7 && k >= 9.2) {
                        starscore.add(i, "4.5");
                    } else if (k < 9.2 && k >= 8.3) {
                        starscore.add(i, "4");
                    } else if (k < 8.3 && k >= 7.5) {
                        starscore.add(i, "3.5");
                    } else if (k < 7.5 && k >= 6.5) {
                        starscore.add(i, "3");
                    } else if (k < 6.5 && k >= 4.5) {
                        starscore.add(i, "2.5");
                    } else if (k < 4.5 && k >= 3) {
                        starscore.add(i, "2");
                    } else if (k < 3 && k >= 2) {
                        starscore.add(i, "1.5");
                    } else if (k < 2 && k >= 1) {
                        starscore.add(i, "1");
                    } else if (k < 1) {
                        starscore.add(i, "0");
                    }*/

                }
            } else {
                Log.d(result, "Array is null");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    class HotelView extends AsyncTask<String, Void, String> {

        StringBuffer buffer = new StringBuffer();
        String sendMsg;
        String receiveMsg = "";

        @Override
        protected String doInBackground(String... strings) {
            try {
                String str;
                URL url = new URL("http://222.116.135.77:8080/NCCC_H/hotelallview.jsp");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestMethod("POST");

                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());

                sendMsg = "userid="+strings[0]+"&min="+strings[1]+"&max="+strings[2];
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

    public void InitializeData() {
        hotelList = new ArrayList<>();

        for (count = 0; count < i ; count++) {
            hotelList.add(count, new Hotel(cityname.get(count), hotelname.get(count),
                    "http://222.116.135.77:8080/NCCC_H/photo1/"+hotelcode.get(count)+".jpg",
                    starscore.get(count), "http://222.116.135.77:8080/NCCC_H/drawble/long_addshow.png"));
        }

    }
}