package com.example.nccc_h;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.ModelLoader;

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

import javax.net.ssl.HandshakeCompletedEvent;


public class HotelTutorial extends AppCompatActivity {

    private static int TIME_OUT = 500;
    private static int PROGRESS_TIME = 10000;

    ImageView tutImage1_lay1;
    ImageView tutImage2_lay1;

    ProgressBar tutPrgrBar1_lay1;
    ProgressBar tutPrgrBar2_lay1;
    ProgressBar tutPrgrBar3_lay1;
    ProgressBar tutPrgrBar4_lay1;
    ProgressBar tutPrgrBar5_lay1;
    ProgressBar tutPrgrBar6_lay1;

    TextView tutPrgrNum1_lay1;
    TextView tutPrgrNum2_lay1;
    TextView tutPrgrNum3_lay1;
    TextView tutPrgrNum4_lay1;
    TextView tutPrgrNum5_lay1;
    TextView tutPrgrNum6_lay1;

    RatingBar tutRating_lay1;

    ImageView tutImage1_lay2;
    ImageView tutImage2_lay2;

    ProgressBar tutPrgrBar1_lay2;
    ProgressBar tutPrgrBar2_lay2;
    ProgressBar tutPrgrBar3_lay2;
    ProgressBar tutPrgrBar4_lay2;
    ProgressBar tutPrgrBar5_lay2;
    ProgressBar tutPrgrBar6_lay2;

    TextView tutPrgrNum1_lay2;
    TextView tutPrgrNum2_lay2;
    TextView tutPrgrNum3_lay2;
    TextView tutPrgrNum4_lay2;
    TextView tutPrgrNum5_lay2;
    TextView tutPrgrNum6_lay2;

    RatingBar tutRating_lay2;

    ImageView tutImage1_lay3;
    ImageView tutImage2_lay3;

    ProgressBar tutPrgrBar1_lay3;
    ProgressBar tutPrgrBar2_lay3;
    ProgressBar tutPrgrBar3_lay3;
    ProgressBar tutPrgrBar4_lay3;
    ProgressBar tutPrgrBar5_lay3;
    ProgressBar tutPrgrBar6_lay3;

    TextView tutPrgrNum1_lay3;
    TextView tutPrgrNum2_lay3;
    TextView tutPrgrNum3_lay3;
    TextView tutPrgrNum4_lay3;
    TextView tutPrgrNum5_lay3;
    TextView tutPrgrNum6_lay3;

    RatingBar tutRating_lay3;

    ImageView tutImage1_lay4;
    ImageView tutImage2_lay4;

    ProgressBar tutPrgrBar1_lay4;
    ProgressBar tutPrgrBar2_lay4;
    ProgressBar tutPrgrBar3_lay4;
    ProgressBar tutPrgrBar4_lay4;
    ProgressBar tutPrgrBar5_lay4;
    ProgressBar tutPrgrBar6_lay4;

    TextView tutPrgrNum1_lay4;
    TextView tutPrgrNum2_lay4;
    TextView tutPrgrNum3_lay4;
    TextView tutPrgrNum4_lay4;
    TextView tutPrgrNum5_lay4;
    TextView tutPrgrNum6_lay4;

    RatingBar tutRating_lay4;

    ImageView tutImage1_lay5;
    ImageView tutImage2_lay5;

    ProgressBar tutPrgrBar1_lay5;
    ProgressBar tutPrgrBar2_lay5;
    ProgressBar tutPrgrBar3_lay5;
    ProgressBar tutPrgrBar4_lay5;
    ProgressBar tutPrgrBar5_lay5;
    ProgressBar tutPrgrBar6_lay5;

    TextView tutPrgrNum1_lay5;
    TextView tutPrgrNum2_lay5;
    TextView tutPrgrNum3_lay5;
    TextView tutPrgrNum4_lay5;
    TextView tutPrgrNum5_lay5;
    TextView tutPrgrNum6_lay5;

    RatingBar tutRating_lay5;

    ImageView tutImage1_lay6;
    ImageView tutImage2_lay6;

    ProgressBar tutPrgrBar1_lay6;
    ProgressBar tutPrgrBar2_lay6;
    ProgressBar tutPrgrBar3_lay6;
    ProgressBar tutPrgrBar4_lay6;
    ProgressBar tutPrgrBar5_lay6;
    ProgressBar tutPrgrBar6_lay6;

    TextView tutPrgrNum1_lay6;
    TextView tutPrgrNum2_lay6;
    TextView tutPrgrNum3_lay6;
    TextView tutPrgrNum4_lay6;
    TextView tutPrgrNum5_lay6;
    TextView tutPrgrNum6_lay6;

    RatingBar tutRating_lay6;

    ImageView tutImage1_lay7;
    ImageView tutImage2_lay7;

    ProgressBar tutPrgrBar1_lay7;
    ProgressBar tutPrgrBar2_lay7;
    ProgressBar tutPrgrBar3_lay7;
    ProgressBar tutPrgrBar4_lay7;
    ProgressBar tutPrgrBar5_lay7;
    ProgressBar tutPrgrBar6_lay7;

    TextView tutPrgrNum1_lay7;
    TextView tutPrgrNum2_lay7;
    TextView tutPrgrNum3_lay7;
    TextView tutPrgrNum4_lay7;
    TextView tutPrgrNum5_lay7;
    TextView tutPrgrNum6_lay7;

    RatingBar tutRating_lay7;

    ImageView tutImage1_lay8;
    ImageView tutImage2_lay8;

    ProgressBar tutPrgrBar1_lay8;
    ProgressBar tutPrgrBar2_lay8;
    ProgressBar tutPrgrBar3_lay8;
    ProgressBar tutPrgrBar4_lay8;
    ProgressBar tutPrgrBar5_lay8;
    ProgressBar tutPrgrBar6_lay8;

    TextView tutPrgrNum1_lay8;
    TextView tutPrgrNum2_lay8;
    TextView tutPrgrNum3_lay8;
    TextView tutPrgrNum4_lay8;
    TextView tutPrgrNum5_lay8;
    TextView tutPrgrNum6_lay8;

    RatingBar tutRating_lay8;

    ImageView tutImage1_lay9;
    ImageView tutImage2_lay9;

    ProgressBar tutPrgrBar1_lay9;
    ProgressBar tutPrgrBar2_lay9;
    ProgressBar tutPrgrBar3_lay9;
    ProgressBar tutPrgrBar4_lay9;
    ProgressBar tutPrgrBar5_lay9;
    ProgressBar tutPrgrBar6_lay9;

    TextView tutPrgrNum1_lay9;
    TextView tutPrgrNum2_lay9;
    TextView tutPrgrNum3_lay9;
    TextView tutPrgrNum4_lay9;
    TextView tutPrgrNum5_lay9;
    TextView tutPrgrNum6_lay9;

    RatingBar tutRating_lay9;

    ImageView tutImage1_lay10;
    ImageView tutImage2_lay10;

    ProgressBar tutPrgrBar1_lay10;
    ProgressBar tutPrgrBar2_lay10;
    ProgressBar tutPrgrBar3_lay10;
    ProgressBar tutPrgrBar4_lay10;
    ProgressBar tutPrgrBar5_lay10;
    ProgressBar tutPrgrBar6_lay10;

    TextView tutPrgrNum1_lay10;
    TextView tutPrgrNum2_lay10;
    TextView tutPrgrNum3_lay10;
    TextView tutPrgrNum4_lay10;
    TextView tutPrgrNum5_lay10;
    TextView tutPrgrNum6_lay10;

    RatingBar tutRating_lay10;

    ImageView tutImage1_lay11;
    ImageView tutImage2_lay11;

    ProgressBar tutPrgrBar1_lay11;
    ProgressBar tutPrgrBar2_lay11;
    ProgressBar tutPrgrBar3_lay11;
    ProgressBar tutPrgrBar4_lay11;
    ProgressBar tutPrgrBar5_lay11;
    ProgressBar tutPrgrBar6_lay11;

    TextView tutPrgrNum1_lay11;
    TextView tutPrgrNum2_lay11;
    TextView tutPrgrNum3_lay11;
    TextView tutPrgrNum4_lay11;
    TextView tutPrgrNum5_lay11;
    TextView tutPrgrNum6_lay11;

    RatingBar tutRating_lay11;

    ImageView tutImage1_lay12;
    ImageView tutImage2_lay12;

    ProgressBar tutPrgrBar1_lay12;
    ProgressBar tutPrgrBar2_lay12;
    ProgressBar tutPrgrBar3_lay12;
    ProgressBar tutPrgrBar4_lay12;
    ProgressBar tutPrgrBar5_lay12;
    ProgressBar tutPrgrBar6_lay12;

    TextView tutPrgrNum1_lay12;
    TextView tutPrgrNum2_lay12;
    TextView tutPrgrNum3_lay12;
    TextView tutPrgrNum4_lay12;
    TextView tutPrgrNum5_lay12;
    TextView tutPrgrNum6_lay12;

    RatingBar tutRating_lay12;

    Button tutBtn;
    Button bckBtn;

    FrameLayout tut_lay1;
    FrameLayout tut_lay2;
    FrameLayout tut_lay3;
    FrameLayout tut_lay4;
    FrameLayout tut_lay5;
    FrameLayout tut_lay6;
    FrameLayout tut_lay7;
    FrameLayout tut_lay8;
    FrameLayout tut_lay9;
    FrameLayout tut_lay10;
    FrameLayout tut_lay11;
    FrameLayout tut_lay12;

    String min;
    String max;
    String userID;
    String result;
    String result2;

    String ratingVal1 = "3";
    String ratingVal2 = "3";
    String ratingVal3 = "3";
    String ratingVal4 = "3";
    String ratingVal5 = "3";
    String ratingVal6 = "3";
    String ratingVal7 = "3";
    String ratingVal8 = "3";
    String ratingVal9 = "3";
    String ratingVal10 = "3";
    String ratingVal11 = "3";
    String ratingVal12 = "3";

    HotelData hotelData = new HotelData();
    HotelAddData hotelAddData = new HotelAddData();

    TutorialData tutorialData1 = new TutorialData();
    TutorialData tutorialData2 = new TutorialData();
    TutorialData tutorialData3 = new TutorialData();
    TutorialData tutorialData4 = new TutorialData();
    TutorialData tutorialData5 = new TutorialData();
    TutorialData tutorialData6 = new TutorialData();
    TutorialData tutorialData7 = new TutorialData();
    TutorialData tutorialData8 = new TutorialData();
    TutorialData tutorialData9 = new TutorialData();
    TutorialData tutorialData10 = new TutorialData();
    TutorialData tutorialData11 = new TutorialData();
    TutorialData tutorialData12 = new TutorialData();

    List<String> hotelcode = new ArrayList<>();
    List<String> score1 = new ArrayList<>();
    List<String> score2 = new ArrayList<>();
    List<String> score3 = new ArrayList<>();
    List<String> score4 = new ArrayList<>();
    List<String> score5 = new ArrayList<>();
    List<String> average = new ArrayList<>();

    List<String> hotelcodeadd = new ArrayList<>();

    Handler handler = new Handler();

    static int i = 0;
    int j = 0;
    int count = 0;

    boolean bn;

    Model_Server model_server = new Model_Server();

    AppCompatDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_tutorial);

        userID = getIntent().getStringExtra("userID");

        this.setFirst();
        this.SetRatingBarListener();
        this.setLayout();
        this.getJsonData();
        if (i <12) {
            this.getJsonHotelData();
        }
        this.getHotelData();
        this.setNextClickListener();


    }

    //tutPrgrBar = 프로그레스 바
    //tutPrgrNum = 프로그레스 값
    //tutValue = 가격
    //tutRating = 레이팅바
    public void setFirst() {
        min = getIntent().getStringExtra("min");
        max = getIntent().getStringExtra("max");

        tutImage1_lay1 = (ImageView) findViewById(R.id.hotel_tutorial_img1_lay1);
        tutImage2_lay1 = (ImageView) findViewById(R.id.hotel_tutorial_img2_lay1);

        tutPrgrBar1_lay1 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress1_lay1);
        tutPrgrBar2_lay1 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress2_lay1);
        tutPrgrBar3_lay1 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress3_lay1);
        tutPrgrBar4_lay1 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress4_lay1);
        tutPrgrBar5_lay1 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress5_lay1);
        tutPrgrBar6_lay1 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress6_lay1);

        tutPrgrNum1_lay1 = (TextView) findViewById(R.id.tutorial_value1_lay1);
        tutPrgrNum2_lay1 = (TextView) findViewById(R.id.tutorial_value2_lay1);
        tutPrgrNum3_lay1 = (TextView) findViewById(R.id.tutorial_value3_lay1);
        tutPrgrNum4_lay1 = (TextView) findViewById(R.id.tutorial_value4_lay1);
        tutPrgrNum5_lay1 = (TextView) findViewById(R.id.tutorial_value5_lay1);
        tutPrgrNum6_lay1 = (TextView) findViewById(R.id.tutorial_value6_lay1);

        tutRating_lay1 = (RatingBar) findViewById(R.id.hotel_tutorial_rating_lay1);

        tutImage1_lay2 = (ImageView) findViewById(R.id.hotel_tutorial_img1_lay2);
        tutImage2_lay2 = (ImageView) findViewById(R.id.hotel_tutorial_img2_lay2);

        tutPrgrBar1_lay2 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress1_lay2);
        tutPrgrBar2_lay2 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress2_lay2);
        tutPrgrBar3_lay2 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress3_lay2);
        tutPrgrBar4_lay2 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress4_lay2);
        tutPrgrBar5_lay2 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress5_lay2);
        tutPrgrBar6_lay2 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress6_lay2);

        tutPrgrNum1_lay2 = (TextView) findViewById(R.id.tutorial_value1_lay2);
        tutPrgrNum2_lay2 = (TextView) findViewById(R.id.tutorial_value2_lay2);
        tutPrgrNum3_lay2 = (TextView) findViewById(R.id.tutorial_value3_lay2);
        tutPrgrNum4_lay2 = (TextView) findViewById(R.id.tutorial_value4_lay2);
        tutPrgrNum5_lay2 = (TextView) findViewById(R.id.tutorial_value5_lay2);
        tutPrgrNum6_lay2 = (TextView) findViewById(R.id.tutorial_value6_lay2);

        tutRating_lay2 = (RatingBar) findViewById(R.id.hotel_tutorial_rating_lay2);

        tutImage1_lay3 = (ImageView) findViewById(R.id.hotel_tutorial_img1_lay3);
        tutImage2_lay3 = (ImageView) findViewById(R.id.hotel_tutorial_img2_lay3);

        tutPrgrBar1_lay3 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress1_lay3);
        tutPrgrBar2_lay3 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress2_lay3);
        tutPrgrBar3_lay3 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress3_lay3);
        tutPrgrBar4_lay3 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress4_lay3);
        tutPrgrBar5_lay3 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress5_lay3);
        tutPrgrBar6_lay3 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress6_lay3);

        tutPrgrNum1_lay3 = (TextView) findViewById(R.id.tutorial_value1_lay3);
        tutPrgrNum2_lay3 = (TextView) findViewById(R.id.tutorial_value2_lay3);
        tutPrgrNum3_lay3 = (TextView) findViewById(R.id.tutorial_value3_lay3);
        tutPrgrNum4_lay3 = (TextView) findViewById(R.id.tutorial_value4_lay3);
        tutPrgrNum5_lay3 = (TextView) findViewById(R.id.tutorial_value5_lay3);
        tutPrgrNum6_lay3 = (TextView) findViewById(R.id.tutorial_value6_lay3);

        tutRating_lay3 = (RatingBar) findViewById(R.id.hotel_tutorial_rating_lay3);

        tutImage1_lay4 = (ImageView) findViewById(R.id.hotel_tutorial_img1_lay4);
        tutImage2_lay4 = (ImageView) findViewById(R.id.hotel_tutorial_img2_lay4);

        tutPrgrBar1_lay4 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress1_lay4);
        tutPrgrBar2_lay4 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress2_lay4);
        tutPrgrBar3_lay4 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress3_lay4);
        tutPrgrBar4_lay4 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress4_lay4);
        tutPrgrBar5_lay4 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress5_lay4);
        tutPrgrBar6_lay4 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress6_lay4);

        tutPrgrNum1_lay4 = (TextView) findViewById(R.id.tutorial_value1_lay4);
        tutPrgrNum2_lay4 = (TextView) findViewById(R.id.tutorial_value2_lay4);
        tutPrgrNum3_lay4 = (TextView) findViewById(R.id.tutorial_value3_lay4);
        tutPrgrNum4_lay4 = (TextView) findViewById(R.id.tutorial_value4_lay4);
        tutPrgrNum5_lay4 = (TextView) findViewById(R.id.tutorial_value5_lay4);
        tutPrgrNum6_lay4 = (TextView) findViewById(R.id.tutorial_value6_lay4);

        tutRating_lay4 = (RatingBar) findViewById(R.id.hotel_tutorial_rating_lay4);

        tutImage1_lay5 = (ImageView) findViewById(R.id.hotel_tutorial_img1_lay5);
        tutImage2_lay5 = (ImageView) findViewById(R.id.hotel_tutorial_img2_lay5);

        tutPrgrBar1_lay5 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress1_lay5);
        tutPrgrBar2_lay5 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress2_lay5);
        tutPrgrBar3_lay5 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress3_lay5);
        tutPrgrBar4_lay5 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress4_lay5);
        tutPrgrBar5_lay5 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress5_lay5);
        tutPrgrBar6_lay5 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress6_lay5);

        tutPrgrNum1_lay5 = (TextView) findViewById(R.id.tutorial_value1_lay5);
        tutPrgrNum2_lay5 = (TextView) findViewById(R.id.tutorial_value2_lay5);
        tutPrgrNum3_lay5 = (TextView) findViewById(R.id.tutorial_value3_lay5);
        tutPrgrNum4_lay5 = (TextView) findViewById(R.id.tutorial_value4_lay5);
        tutPrgrNum5_lay5 = (TextView) findViewById(R.id.tutorial_value5_lay5);
        tutPrgrNum6_lay5 = (TextView) findViewById(R.id.tutorial_value6_lay5);

        tutRating_lay5 = (RatingBar) findViewById(R.id.hotel_tutorial_rating_lay5);

        tutImage1_lay6 = (ImageView) findViewById(R.id.hotel_tutorial_img1_lay6);
        tutImage2_lay6 = (ImageView) findViewById(R.id.hotel_tutorial_img2_lay6);

        tutPrgrBar1_lay6 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress1_lay6);
        tutPrgrBar2_lay6 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress2_lay6);
        tutPrgrBar3_lay6 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress3_lay6);
        tutPrgrBar4_lay6 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress4_lay6);
        tutPrgrBar5_lay6 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress5_lay6);
        tutPrgrBar6_lay6 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress6_lay6);

        tutPrgrNum1_lay6 = (TextView) findViewById(R.id.tutorial_value1_lay6);
        tutPrgrNum2_lay6 = (TextView) findViewById(R.id.tutorial_value2_lay6);
        tutPrgrNum3_lay6 = (TextView) findViewById(R.id.tutorial_value3_lay6);
        tutPrgrNum4_lay6 = (TextView) findViewById(R.id.tutorial_value4_lay6);
        tutPrgrNum5_lay6 = (TextView) findViewById(R.id.tutorial_value5_lay6);
        tutPrgrNum6_lay6 = (TextView) findViewById(R.id.tutorial_value6_lay6);

        tutRating_lay6 = (RatingBar) findViewById(R.id.hotel_tutorial_rating_lay6);

        tutImage1_lay7 = (ImageView) findViewById(R.id.hotel_tutorial_img1_lay7);
        tutImage2_lay7 = (ImageView) findViewById(R.id.hotel_tutorial_img2_lay7);

        tutPrgrBar1_lay7 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress1_lay7);
        tutPrgrBar2_lay7 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress2_lay7);
        tutPrgrBar3_lay7 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress3_lay7);
        tutPrgrBar4_lay7 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress4_lay7);
        tutPrgrBar5_lay7 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress5_lay7);
        tutPrgrBar6_lay7 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress6_lay7);

        tutPrgrNum1_lay7 = (TextView) findViewById(R.id.tutorial_value1_lay7);
        tutPrgrNum2_lay7 = (TextView) findViewById(R.id.tutorial_value2_lay7);
        tutPrgrNum3_lay7 = (TextView) findViewById(R.id.tutorial_value3_lay7);
        tutPrgrNum4_lay7 = (TextView) findViewById(R.id.tutorial_value4_lay7);
        tutPrgrNum5_lay7 = (TextView) findViewById(R.id.tutorial_value5_lay7);
        tutPrgrNum6_lay7 = (TextView) findViewById(R.id.tutorial_value6_lay7);

        tutRating_lay7 = (RatingBar) findViewById(R.id.hotel_tutorial_rating_lay7);

        tutImage1_lay8 = (ImageView) findViewById(R.id.hotel_tutorial_img1_lay8);
        tutImage2_lay8 = (ImageView) findViewById(R.id.hotel_tutorial_img2_lay8);

        tutPrgrBar1_lay8 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress1_lay8);
        tutPrgrBar2_lay8 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress2_lay8);
        tutPrgrBar3_lay8 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress3_lay8);
        tutPrgrBar4_lay8 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress4_lay8);
        tutPrgrBar5_lay8 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress5_lay8);
        tutPrgrBar6_lay8 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress6_lay8);

        tutPrgrNum1_lay8 = (TextView) findViewById(R.id.tutorial_value1_lay8);
        tutPrgrNum2_lay8 = (TextView) findViewById(R.id.tutorial_value2_lay8);
        tutPrgrNum3_lay8 = (TextView) findViewById(R.id.tutorial_value3_lay8);
        tutPrgrNum4_lay8 = (TextView) findViewById(R.id.tutorial_value4_lay8);
        tutPrgrNum5_lay8 = (TextView) findViewById(R.id.tutorial_value5_lay8);
        tutPrgrNum6_lay8 = (TextView) findViewById(R.id.tutorial_value6_lay8);

        tutRating_lay8 = (RatingBar) findViewById(R.id.hotel_tutorial_rating_lay8);

        tutImage1_lay9 = (ImageView) findViewById(R.id.hotel_tutorial_img1_lay9);
        tutImage2_lay9 = (ImageView) findViewById(R.id.hotel_tutorial_img2_lay9);

        tutPrgrBar1_lay9 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress1_lay9);
        tutPrgrBar2_lay9 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress2_lay9);
        tutPrgrBar3_lay9 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress3_lay9);
        tutPrgrBar4_lay9 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress4_lay9);
        tutPrgrBar5_lay9 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress5_lay9);
        tutPrgrBar6_lay9 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress6_lay9);

        tutPrgrNum1_lay9 = (TextView) findViewById(R.id.tutorial_value1_lay9);
        tutPrgrNum2_lay9 = (TextView) findViewById(R.id.tutorial_value2_lay9);
        tutPrgrNum3_lay9 = (TextView) findViewById(R.id.tutorial_value3_lay9);
        tutPrgrNum4_lay9 = (TextView) findViewById(R.id.tutorial_value4_lay9);
        tutPrgrNum5_lay9 = (TextView) findViewById(R.id.tutorial_value5_lay9);
        tutPrgrNum6_lay9 = (TextView) findViewById(R.id.tutorial_value6_lay9);

        tutRating_lay9 = (RatingBar) findViewById(R.id.hotel_tutorial_rating_lay9);

        tutImage1_lay10 = (ImageView) findViewById(R.id.hotel_tutorial_img1_lay10);
        tutImage2_lay10 = (ImageView) findViewById(R.id.hotel_tutorial_img2_lay10);

        tutPrgrBar1_lay10 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress1_lay10);
        tutPrgrBar2_lay10 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress2_lay10);
        tutPrgrBar3_lay10 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress3_lay10);
        tutPrgrBar4_lay10 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress4_lay10);
        tutPrgrBar5_lay10 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress5_lay10);
        tutPrgrBar6_lay10 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress6_lay10);

        tutPrgrNum1_lay10 = (TextView) findViewById(R.id.tutorial_value1_lay10);
        tutPrgrNum2_lay10 = (TextView) findViewById(R.id.tutorial_value2_lay10);
        tutPrgrNum3_lay10 = (TextView) findViewById(R.id.tutorial_value3_lay10);
        tutPrgrNum4_lay10 = (TextView) findViewById(R.id.tutorial_value4_lay10);
        tutPrgrNum5_lay10 = (TextView) findViewById(R.id.tutorial_value5_lay10);
        tutPrgrNum6_lay10 = (TextView) findViewById(R.id.tutorial_value6_lay10);

        tutRating_lay10 = (RatingBar) findViewById(R.id.hotel_tutorial_rating_lay10);

        tutImage1_lay11 = (ImageView) findViewById(R.id.hotel_tutorial_img1_lay11);
        tutImage2_lay11 = (ImageView) findViewById(R.id.hotel_tutorial_img2_lay11);

        tutPrgrBar1_lay11 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress1_lay11);
        tutPrgrBar2_lay11 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress2_lay11);
        tutPrgrBar3_lay11 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress3_lay11);
        tutPrgrBar4_lay11 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress4_lay11);
        tutPrgrBar5_lay11 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress5_lay11);
        tutPrgrBar6_lay11 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress6_lay11);

        tutPrgrNum1_lay11 = (TextView) findViewById(R.id.tutorial_value1_lay11);
        tutPrgrNum2_lay11 = (TextView) findViewById(R.id.tutorial_value2_lay11);
        tutPrgrNum3_lay11 = (TextView) findViewById(R.id.tutorial_value3_lay11);
        tutPrgrNum4_lay11 = (TextView) findViewById(R.id.tutorial_value4_lay11);
        tutPrgrNum5_lay11 = (TextView) findViewById(R.id.tutorial_value5_lay11);
        tutPrgrNum6_lay11 = (TextView) findViewById(R.id.tutorial_value6_lay11);

        tutRating_lay11 = (RatingBar) findViewById(R.id.hotel_tutorial_rating_lay11);

        tutImage1_lay12 = (ImageView) findViewById(R.id.hotel_tutorial_img1_lay12);
        tutImage2_lay12 = (ImageView) findViewById(R.id.hotel_tutorial_img2_lay12);

        tutPrgrBar1_lay12 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress1_lay12);
        tutPrgrBar2_lay12 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress2_lay12);
        tutPrgrBar3_lay12 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress3_lay12);
        tutPrgrBar4_lay12 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress4_lay12);
        tutPrgrBar5_lay12 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress5_lay12);
        tutPrgrBar6_lay12 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress6_lay12);

        tutPrgrNum1_lay12 = (TextView) findViewById(R.id.tutorial_value1_lay12);
        tutPrgrNum2_lay12 = (TextView) findViewById(R.id.tutorial_value2_lay12);
        tutPrgrNum3_lay12 = (TextView) findViewById(R.id.tutorial_value3_lay12);
        tutPrgrNum4_lay12 = (TextView) findViewById(R.id.tutorial_value4_lay12);
        tutPrgrNum5_lay12 = (TextView) findViewById(R.id.tutorial_value5_lay12);
        tutPrgrNum6_lay12 = (TextView) findViewById(R.id.tutorial_value6_lay12);

        tutRating_lay12 = (RatingBar) findViewById(R.id.hotel_tutorial_rating_lay12);

        tutBtn = (Button) findViewById(R.id.tutorial_next);
        //bckBtn = (Button) findViewById(R.id.tutorial_back);

        /* tutBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        bckBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HotelGrasp.class);
                startActivity(intent);
                overridePendingTransition(R.anim.translate_left, R.anim.translate_right);
                finish();
            }
        }); */
    }

    public void SetRatingBarListener() {
        tutRating_lay1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingVal1 = Float.toString(rating);
            }
        });

        tutRating_lay2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingVal2 = Float.toString(rating);
            }
        });

        tutRating_lay3.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingVal3 = Float.toString(rating);
            }
        });

        tutRating_lay4.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingVal4 = Float.toString(rating);
            }
        });

        tutRating_lay5.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingVal5 = Float.toString(rating);
            }
        });

        tutRating_lay6.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingVal6 = Float.toString(rating);
            }
        });

        tutRating_lay7.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingVal7 = Float.toString(rating);
            }
        });

        tutRating_lay8.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingVal8 = Float.toString(rating);
            }
        });
        tutRating_lay9.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingVal9 = Float.toString(rating);
            }
        });

        tutRating_lay10.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingVal10 = Float.toString(rating);
            }
        });

        tutRating_lay11.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingVal11 = Float.toString(rating);
            }
        });

        tutRating_lay12.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingVal12 = Float.toString(rating);
            }
        });

    }

    public void setLayout() {
        tut_lay1 = (FrameLayout) findViewById(R.id.tut_lay1);
        tut_lay2 = (FrameLayout) findViewById(R.id.tut_lay2);
        tut_lay3 = (FrameLayout) findViewById(R.id.tut_lay3);
        tut_lay4 = (FrameLayout) findViewById(R.id.tut_lay4);
        tut_lay5 = (FrameLayout) findViewById(R.id.tut_lay5);
        tut_lay6 = (FrameLayout) findViewById(R.id.tut_lay6);
        tut_lay7 = (FrameLayout) findViewById(R.id.tut_lay7);
        tut_lay8 = (FrameLayout) findViewById(R.id.tut_lay8);
        tut_lay9 = (FrameLayout) findViewById(R.id.tut_lay9);
        tut_lay10 = (FrameLayout) findViewById(R.id.tut_lay10);
        tut_lay11 = (FrameLayout) findViewById(R.id.tut_lay11);
        tut_lay12 = (FrameLayout) findViewById(R.id.tut_lay12);

    }

    public void getJsonData() {
        try {
            result = hotelData.execute(userID).get();
            JSONArray jsonArray = new JSONObject(result).getJSONArray(userID);

            if (jsonArray != null) {
                for (i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    hotelcode.add(jsonObject.getString("hotelcode"));
                    score1.add(jsonObject.getString("score1"));
                    score2.add(jsonObject.getString("score2"));
                    score3.add(jsonObject.getString("score3"));
                    score4.add(jsonObject.getString("score4"));
                    score5.add(jsonObject.getString("score5"));
                    average.add(jsonObject.getString("average"));
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

    public void getJsonHotelData() {
        try {
            result2 = hotelAddData.execute(userID).get();
            JSONArray jsonArrayAdd = new JSONObject(result2).getJSONArray(userID);

            if (jsonArrayAdd != null) {
                for (int r = i; r < jsonArrayAdd.length(); r++, j++) {
                    JSONObject jsonAddObject = jsonArrayAdd.getJSONObject(j);
                    bn = true;
                    List<String> a = new ArrayList<>();
                    List<String> b = new ArrayList<>();

                    hotelcodeadd.add(jsonAddObject.getString("hotelcodeadd"));

                    while (bn) {
                        for (int k = 0; k < r; k++) {
                            if(a.add(hotelcode.get(k)) == b.add(hotelcodeadd.get(j))) {
                                bn = false;
                                break;
                            }
                        }
                        score1.add(jsonAddObject.getString("score1add"));
                        score2.add(jsonAddObject.getString("score2add"));
                        score3.add(jsonAddObject.getString("score3add"));
                        score4.add(jsonAddObject.getString("score4add"));
                        score5.add(jsonAddObject.getString("score5add"));
                        average.add(jsonAddObject.getString("averageadd"));
                        bn = false;
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void getHotelData() {
        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo1/"+hotelcode.get(0)+".jpg")
                .into(tutImage1_lay1);
        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo2/"+hotelcode.get(0)+".jpg")
                .into(tutImage2_lay1);
        tutPrgrBar1_lay1.setProgress((int)(Float.parseFloat(score1.get(0))*10));
        tutPrgrNum1_lay1.setText(score1.get(0));
        tutPrgrBar2_lay1.setProgress((int)(Float.parseFloat(score2.get(0))*10));
        tutPrgrNum2_lay1.setText(score2.get(0));
        tutPrgrBar3_lay1.setProgress((int)(Float.parseFloat(score3.get(0))*10));
        tutPrgrNum3_lay1.setText(score3.get(0));
        tutPrgrBar4_lay1.setProgress((int)(Float.parseFloat(score4.get(0))*10));
        tutPrgrNum4_lay1.setText(score4.get(0));
        tutPrgrBar5_lay1.setProgress((int)(Float.parseFloat(score5.get(0))*10));
        tutPrgrNum5_lay1.setText(score5.get(0));
        tutPrgrBar6_lay1.setProgress((int)(Float.parseFloat(average.get(0))*10));
        tutPrgrNum6_lay1.setText(average.get(0));


        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo1/"+hotelcode.get(1)+".jpg")
                .into(tutImage1_lay2);
        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo2/"+hotelcode.get(1)+".jpg")
                .into(tutImage2_lay2);
        tutPrgrBar1_lay2.setProgress((int)(Float.parseFloat(score1.get(1))*10));
        tutPrgrNum1_lay2.setText(score1.get(1));
        tutPrgrBar2_lay2.setProgress((int)(Float.parseFloat(score2.get(1))*10));
        tutPrgrNum2_lay2.setText(score2.get(1));
        tutPrgrBar3_lay2.setProgress((int)(Float.parseFloat(score3.get(1))*10));
        tutPrgrNum3_lay2.setText(score3.get(1));
        tutPrgrBar4_lay2.setProgress((int)(Float.parseFloat(score4.get(1))*10));
        tutPrgrNum4_lay2.setText(score4.get(1));
        tutPrgrBar5_lay2.setProgress((int)(Float.parseFloat(score5.get(1))*10));
        tutPrgrNum5_lay2.setText(score5.get(1));
        tutPrgrBar6_lay2.setProgress((int)(Float.parseFloat(average.get(1))*10));
        tutPrgrNum6_lay2.setText(average.get(1));

        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo1/"+hotelcode.get(2)+".jpg")
                .into(tutImage1_lay3);
        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo2/"+hotelcode.get(2)+".jpg")
                .into(tutImage2_lay3);
        tutPrgrBar1_lay3.setProgress((int)(Float.parseFloat(score1.get(2))*10));
        tutPrgrNum1_lay3.setText(score1.get(2));
        tutPrgrBar2_lay3.setProgress((int)(Float.parseFloat(score2.get(2))*10));
        tutPrgrNum2_lay3.setText(score2.get(2));
        tutPrgrBar3_lay3.setProgress((int)(Float.parseFloat(score3.get(2))*10));
        tutPrgrNum3_lay3.setText(score3.get(2));
        tutPrgrBar4_lay3.setProgress((int)(Float.parseFloat(score4.get(2))*10));
        tutPrgrNum4_lay3.setText(score4.get(2));
        tutPrgrBar5_lay3.setProgress((int)(Float.parseFloat(score5.get(2))*10));
        tutPrgrNum5_lay3.setText(score5.get(2));
        tutPrgrBar6_lay3.setProgress((int)(Float.parseFloat(average.get(2))*10));
        tutPrgrNum6_lay3.setText(average.get(2));

        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo1/"+hotelcode.get(3)+".jpg")
                .into(tutImage1_lay4);
        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo2/"+hotelcode.get(3)+".jpg")
                .into(tutImage2_lay4);
        tutPrgrBar1_lay4.setProgress((int)(Float.parseFloat(score1.get(3))*10));
        tutPrgrNum1_lay4.setText(score1.get(3));
        tutPrgrBar2_lay4.setProgress((int)(Float.parseFloat(score2.get(3))*10));
        tutPrgrNum2_lay4.setText(score2.get(3));
        tutPrgrBar3_lay4.setProgress((int)(Float.parseFloat(score3.get(3))*10));
        tutPrgrNum3_lay4.setText(score3.get(3));
        tutPrgrBar4_lay4.setProgress((int)(Float.parseFloat(score4.get(3))*10));
        tutPrgrNum4_lay4.setText(score4.get(3));
        tutPrgrBar5_lay4.setProgress((int)(Float.parseFloat(score5.get(3))*10));
        tutPrgrNum5_lay4.setText(score5.get(3));
        tutPrgrBar6_lay4.setProgress((int)(Float.parseFloat(average.get(3))*10));
        tutPrgrNum6_lay4.setText(average.get(3));

        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo1/"+hotelcode.get(4)+".jpg")
                .into(tutImage1_lay5);
        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo2/"+hotelcode.get(4)+".jpg")
                .into(tutImage2_lay5);
        tutPrgrBar1_lay5.setProgress((int)(Float.parseFloat(score1.get(4))*10));
        tutPrgrNum1_lay5.setText(score1.get(4));
        tutPrgrBar2_lay5.setProgress((int)(Float.parseFloat(score2.get(4))*10));
        tutPrgrNum2_lay5.setText(score2.get(4));
        tutPrgrBar3_lay5.setProgress((int)(Float.parseFloat(score3.get(4))*10));
        tutPrgrNum3_lay5.setText(score3.get(4));
        tutPrgrBar4_lay5.setProgress((int)(Float.parseFloat(score4.get(4))*10));
        tutPrgrNum4_lay5.setText(score4.get(4));
        tutPrgrBar5_lay5.setProgress((int)(Float.parseFloat(score5.get(4))*10));
        tutPrgrNum5_lay5.setText(score5.get(4));
        tutPrgrBar6_lay5.setProgress((int)(Float.parseFloat(average.get(4))*10));
        tutPrgrNum6_lay5.setText(average.get(4));

        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo1/"+hotelcode.get(5)+".jpg")
                .into(tutImage1_lay6);
        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo2/"+hotelcode.get(5)+".jpg")
                .into(tutImage2_lay6);
        tutPrgrBar1_lay6.setProgress((int)(Float.parseFloat(score1.get(5))*10));
        tutPrgrNum1_lay6.setText(score1.get(5));
        tutPrgrBar2_lay6.setProgress((int)(Float.parseFloat(score2.get(5))*10));
        tutPrgrNum2_lay6.setText(score2.get(5));
        tutPrgrBar3_lay6.setProgress((int)(Float.parseFloat(score3.get(5))*10));
        tutPrgrNum3_lay6.setText(score3.get(5));
        tutPrgrBar4_lay6.setProgress((int)(Float.parseFloat(score4.get(5))*10));
        tutPrgrNum4_lay6.setText(score4.get(5));
        tutPrgrBar5_lay6.setProgress((int)(Float.parseFloat(score5.get(5))*10));
        tutPrgrNum5_lay6.setText(score5.get(5));
        tutPrgrBar6_lay6.setProgress((int)(Float.parseFloat(average.get(5))*10));
        tutPrgrNum6_lay6.setText(average.get(5));

        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo1/"+hotelcode.get(6)+".jpg")
                .into(tutImage1_lay7);
        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo2/"+hotelcode.get(6)+".jpg")
                .into(tutImage2_lay7);
        tutPrgrBar1_lay7.setProgress((int)(Float.parseFloat(score1.get(6))*10));
        tutPrgrNum1_lay7.setText(score1.get(6));
        tutPrgrBar2_lay7.setProgress((int)(Float.parseFloat(score2.get(6))*10));
        tutPrgrNum2_lay7.setText(score2.get(6));
        tutPrgrBar3_lay7.setProgress((int)(Float.parseFloat(score3.get(6))*10));
        tutPrgrNum3_lay7.setText(score3.get(6));
        tutPrgrBar4_lay7.setProgress((int)(Float.parseFloat(score4.get(6))*10));
        tutPrgrNum4_lay7.setText(score4.get(6));
        tutPrgrBar5_lay7.setProgress((int)(Float.parseFloat(score5.get(6))*10));
        tutPrgrNum5_lay7.setText(score5.get(6));
        tutPrgrBar6_lay7.setProgress((int)(Float.parseFloat(average.get(6))*10));
        tutPrgrNum6_lay7.setText(average.get(6));

        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo1/"+hotelcode.get(7)+".jpg")
                .into(tutImage1_lay8);
        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo2/"+hotelcode.get(7)+".jpg")
                .into(tutImage2_lay8);
        tutPrgrBar1_lay8.setProgress((int)(Float.parseFloat(score1.get(7))*10));
        tutPrgrNum1_lay8.setText(score1.get(7));
        tutPrgrBar2_lay8.setProgress((int)(Float.parseFloat(score2.get(7))*10));
        tutPrgrNum2_lay8.setText(score2.get(7));
        tutPrgrBar3_lay8.setProgress((int)(Float.parseFloat(score3.get(7))*10));
        tutPrgrNum3_lay8.setText(score3.get(7));
        tutPrgrBar4_lay8.setProgress((int)(Float.parseFloat(score4.get(7))*10));
        tutPrgrNum4_lay8.setText(score4.get(7));
        tutPrgrBar5_lay8.setProgress((int)(Float.parseFloat(score5.get(7))*10));
        tutPrgrNum5_lay8.setText(score5.get(7));
        tutPrgrBar6_lay8.setProgress((int)(Float.parseFloat(average.get(7))*10));
        tutPrgrNum6_lay8.setText(average.get(7));

        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo1/"+hotelcode.get(8)+".jpg")
                .into(tutImage1_lay9);
        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo2/"+hotelcode.get(8)+".jpg")
                .into(tutImage2_lay9);
        tutPrgrBar1_lay9.setProgress((int)(Float.parseFloat(score1.get(8))*10));
        tutPrgrNum1_lay9.setText(score1.get(8));
        tutPrgrBar2_lay9.setProgress((int)(Float.parseFloat(score2.get(8))*10));
        tutPrgrNum2_lay9.setText(score2.get(8));
        tutPrgrBar3_lay9.setProgress((int)(Float.parseFloat(score3.get(8))*10));
        tutPrgrNum3_lay9.setText(score3.get(8));
        tutPrgrBar4_lay9.setProgress((int)(Float.parseFloat(score4.get(8))*10));
        tutPrgrNum4_lay9.setText(score4.get(8));
        tutPrgrBar5_lay9.setProgress((int)(Float.parseFloat(score5.get(8))*10));
        tutPrgrNum5_lay9.setText(score5.get(8));
        tutPrgrBar6_lay9.setProgress((int)(Float.parseFloat(average.get(8))*10));
        tutPrgrNum6_lay9.setText(average.get(8));

        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo1/"+hotelcode.get(9)+".jpg")
                .into(tutImage1_lay10);
        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo2/"+hotelcode.get(9)+".jpg")
                .into(tutImage2_lay10);
        tutPrgrBar1_lay10.setProgress((int)(Float.parseFloat(score1.get(9))*10));
        tutPrgrNum1_lay10.setText(score1.get(9));
        tutPrgrBar2_lay10.setProgress((int)(Float.parseFloat(score2.get(9))*10));
        tutPrgrNum2_lay10.setText(score2.get(9));
        tutPrgrBar3_lay10.setProgress((int)(Float.parseFloat(score3.get(9))*10));
        tutPrgrNum3_lay10.setText(score3.get(9));
        tutPrgrBar4_lay10.setProgress((int)(Float.parseFloat(score4.get(9))*10));
        tutPrgrNum4_lay10.setText(score4.get(9));
        tutPrgrBar5_lay10.setProgress((int)(Float.parseFloat(score5.get(9))*10));
        tutPrgrNum5_lay10.setText(score5.get(9));
        tutPrgrBar6_lay10.setProgress((int)(Float.parseFloat(average.get(9))*10));
        tutPrgrNum6_lay10.setText(average.get(9));

        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo1/"+hotelcode.get(10)+".jpg")
                .into(tutImage1_lay11);
        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo2/"+hotelcode.get(10)+".jpg")
                .into(tutImage2_lay11);
        tutPrgrBar1_lay11.setProgress((int)(Float.parseFloat(score1.get(10))*10));
        tutPrgrNum1_lay11.setText(score1.get(10));
        tutPrgrBar2_lay11.setProgress((int)(Float.parseFloat(score2.get(10))*10));
        tutPrgrNum2_lay11.setText(score2.get(10));
        tutPrgrBar3_lay11.setProgress((int)(Float.parseFloat(score3.get(10))*10));
        tutPrgrNum3_lay11.setText(score3.get(10));
        tutPrgrBar4_lay11.setProgress((int)(Float.parseFloat(score4.get(10))*10));
        tutPrgrNum4_lay11.setText(score4.get(10));
        tutPrgrBar5_lay11.setProgress((int)(Float.parseFloat(score5.get(10))*10));
        tutPrgrNum5_lay11.setText(score5.get(10));
        tutPrgrBar6_lay11.setProgress((int)(Float.parseFloat(average.get(10))*10));
        tutPrgrNum6_lay11.setText(average.get(10));

        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo1/"+hotelcode.get(11)+".jpg")
                .into(tutImage1_lay12);
        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo2/"+hotelcode.get(11)+".jpg")
                .into(tutImage2_lay12);
        tutPrgrBar1_lay12.setProgress((int)(Float.parseFloat(score1.get(11))*10));
        tutPrgrNum1_lay12.setText(score1.get(11));
        tutPrgrBar2_lay12.setProgress((int)(Float.parseFloat(score2.get(11))*10));
        tutPrgrNum2_lay12.setText(score2.get(11));
        tutPrgrBar3_lay12.setProgress((int)(Float.parseFloat(score3.get(11))*10));
        tutPrgrNum3_lay12.setText(score3.get(11));
        tutPrgrBar4_lay12.setProgress((int)(Float.parseFloat(score4.get(11))*10));
        tutPrgrNum4_lay12.setText(score4.get(11));
        tutPrgrBar5_lay12.setProgress((int)(Float.parseFloat(score5.get(11))*10));
        tutPrgrNum5_lay12.setText(score5.get(11));
        tutPrgrBar6_lay12.setProgress((int)(Float.parseFloat(average.get(11))*10));
        tutPrgrNum6_lay12.setText(average.get(11));
    }

    public void setNextClickListener() {
        tutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (count) {
                    case (0):
                        //AsyncTask 통해 데이터 전달
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                tutorialData1.execute(userID, hotelcode.get(0), score1.get(0), score2.get(0), score3.get(0), score4.get(0), score5.get(0), average.get(0), ratingVal1);
                                tut_lay1.setVisibility(View.GONE);
                                tut_lay2.setVisibility(View.VISIBLE);
                                count++;
                            }
                        }, TIME_OUT);
                        break;
                    case (1):
                        //AsyncTask 통해 데이터 전달
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                tutorialData2.execute(userID, hotelcode.get(1), score1.get(1), score2.get(1), score3.get(1), score4.get(1), score5.get(1), average.get(1), ratingVal2);
                                tut_lay2.setVisibility(View.GONE);
                                tut_lay3.setVisibility(View.VISIBLE);
                                count++;
                            }
                        }, TIME_OUT);
                        break;
                    case (2):
                        //AsyncTask 통해 데이터 전달
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                tutorialData3.execute(userID, hotelcode.get(2), score1.get(2), score2.get(2), score3.get(2), score4.get(2), score5.get(2), average.get(2), ratingVal3);
                                tut_lay3.setVisibility(View.GONE);
                                tut_lay4.setVisibility(View.VISIBLE);
                                count++;
                            }
                        }, TIME_OUT);
                        break;
                    case (3):
                        //AsyncTask 통해 데이터 전달
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                tutorialData4.execute(userID, hotelcode.get(3), score1.get(3), score2.get(3), score3.get(3), score4.get(3), score5.get(3), average.get(3), ratingVal4);
                                tut_lay4.setVisibility(View.GONE);
                                tut_lay5.setVisibility(View.VISIBLE);
                                count++;
                            }
                        }, TIME_OUT);
                        break;
                    case (4):
                        //AsyncTask 통해 데이터 전달
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                tutorialData5.execute(userID, hotelcode.get(4), score1.get(4), score2.get(4), score3.get(4), score4.get(4), score5.get(4), average.get(4), ratingVal5);
                                tut_lay5.setVisibility(View.GONE);
                                tut_lay6.setVisibility(View.VISIBLE);
                                count++;
                            }
                        }, TIME_OUT);
                        break;
                    case (5):
                        //AsyncTask 통해 데이터 전달
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                tutorialData6.execute(userID, hotelcode.get(5), score1.get(5), score2.get(5), score3.get(5), score4.get(5), score5.get(5), average.get(5), ratingVal6);
                                tut_lay6.setVisibility(View.GONE);
                                tut_lay7.setVisibility(View.VISIBLE);
                                count++;
                            }
                        }, TIME_OUT);
                        break;
                    case (6):
                        //AsyncTask 통해 데이터 전달
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                tutorialData7.execute(userID, hotelcode.get(6), score1.get(6), score2.get(6), score3.get(6), score4.get(6), score5.get(6), average.get(6), ratingVal7);
                                tut_lay7.setVisibility(View.GONE);
                                tut_lay8.setVisibility(View.VISIBLE);
                                count++;
                            }
                        }, TIME_OUT);
                        break;
                    case (7):
                        //AsyncTask 통해 데이터 전달
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                tutorialData8.execute(userID, hotelcode.get(7), score1.get(7), score2.get(7), score3.get(7), score4.get(7), score5.get(7), average.get(7), ratingVal8);
                                tut_lay8.setVisibility(View.GONE);
                                tut_lay9.setVisibility(View.VISIBLE);
                                count++;
                            }
                        }, TIME_OUT);
                        break;
                    case (8):
                        //AsyncTask 통해 데이터 전달
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                tutorialData9.execute(userID, hotelcode.get(8), score1.get(8), score2.get(8), score3.get(8), score4.get(8), score5.get(8), average.get(8), ratingVal9);
                                tut_lay9.setVisibility(View.GONE);
                                tut_lay10.setVisibility(View.VISIBLE);
                                count++;
                            }
                        }, TIME_OUT);
                        break;
                    case (9):
                        //AsyncTask 통해 데이터 전달
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                tutorialData10.execute(userID, hotelcode.get(9), score1.get(9), score2.get(9), score3.get(9), score4.get(9), score5.get(9), average.get(9), ratingVal10);
                                tut_lay10.setVisibility(View.GONE);
                                tut_lay11.setVisibility(View.VISIBLE);
                                count++;
                            }
                        }, TIME_OUT);
                        break;
                    case (10):
                        //AsyncTask 통해 데이터 전달
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                tutorialData11.execute(userID, hotelcode.get(10), score1.get(10), score2.get(10), score3.get(10), score4.get(10), score5.get(10), average.get(10), ratingVal11);
                                tut_lay11.setVisibility(View.GONE);
                                tut_lay12.setVisibility(View.VISIBLE);
                                count++;
                            }
                        }, TIME_OUT);
                        break;
                    case (11):
                        //AsyncTask 통해 데이터 전달
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                tutorialData12.execute(userID, hotelcode.get(11), score1.get(11), score2.get(11), score3.get(11), score4.get(11), score5.get(11), average.get(11), ratingVal12);
                                Toast.makeText(getApplicationContext(), "취향찾기가 완료됐습니다.", Toast.LENGTH_SHORT).show();
                                model_server.sendId(userID); //모델 학습
                                //학습 로딩 화면
                                startProgress();
                            }
                        }, TIME_OUT);
                        break;
                }
            }
        });
    }

    public void progressON(Activity activity, String message) {
        if (activity == null || activity.isFinishing()) {
            return;
        }

        if (progressDialog != null && progressDialog.isShowing()) {
            progressSET(message);
        } else {
            progressDialog = new AppCompatDialog(activity);
            progressDialog.setCancelable(false);
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            progressDialog.setContentView(R.layout.progress_loading);
            progressDialog.show();
        }

        final ImageView img_loading_frame = (ImageView) progressDialog.findViewById(R.id.iv_frame_loading);
        final AnimationDrawable frameAnimation = (AnimationDrawable) img_loading_frame.getBackground();
        img_loading_frame.post(new Runnable() {
            @Override
            public void run() {
                frameAnimation.start();
            }
        });

        TextView tv_progress_message = (TextView) progressDialog.findViewById(R.id.tv_message);
        if (!TextUtils.isEmpty(message)) {
            tv_progress_message.setText(message);
        }
    }

    public void progressSET(String message) {
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }

        TextView tv_progress_message = (TextView) progressDialog.findViewById(R.id.tv_message);
        if (!TextUtils.isEmpty(message)) {
            tv_progress_message.setText(message);
        }
    }

    public void progressOFF() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    //로딩 시간 이후 메인화면 호출
    public void startProgress() {
        progressON(this, "Loading..");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressOFF();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, PROGRESS_TIME);
    }

    class HotelData extends AsyncTask<String, Void, String> {

        StringBuffer buffer = new StringBuffer();
        String sendMsg;
        String receiveMsg = "";

        @Override
        protected String doInBackground(String... strings) {
            try {
                String str;
                URL url = new URL("http://222.116.135.77:8080/NCCC_H/tutorial.jsp");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestMethod("POST");

                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());

                sendMsg = "userid="+strings[0]+"&min="+min+"&max="+max;
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
                Log.d("receiveMsg: ", receiveMsg);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return receiveMsg;
        }

        /*@Override
        protected void onPostExecute(String receiveMsg) {
            super.onPostExecute(receiveMsg);
            Log.d(receiveMsg,"<<<<<onPostExecute>>>>>");
            try {
                JSONArray jArray = new JSONObject(receiveMsg).getJSONArray(userID);
                if (jArray != null) {
                    for (i = 0; i < jArray.length() || i < 12; i++) {
                        JSONObject jsonObject = jArray.getJSONObject(i);

                        getJsonData[0] = jsonObject.getString("hotelcode");
                        getJsonData[1] = jsonObject.getString("score1");
                        getJsonData[2] = jsonObject.getString("score2");
                        getJsonData[3] = jsonObject.getString("score3");
                        getJsonData[4] = jsonObject.getString("score4");
                        getJsonData[5] = jsonObject.getString("score5");
                        getJsonData[6] = jsonObject.getString("price");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
    }

    class HotelAddData extends AsyncTask<String, Void, String> {

        StringBuffer buffer = new StringBuffer();
        String sendMsg;
        String receiveMsg = "";

        @Override
        protected String doInBackground(String... strings) {
            try {
                String str;
                URL url = new URL("http://222.116.135.77:8080/NCCC_H/hoteladd.jsp");
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
                Log.d("receiveMsg: ", receiveMsg);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return receiveMsg;
        }

        /*@Override
        protected void onPostExecute(String receiveMsg) {
            super.onPostExecute(receiveMsg);
            Log.d(receiveMsg,"<<<<<onPostExecute>>>>>");
            try {
                JSONArray jArray = new JSONObject(receiveMsg).getJSONArray(userID);
                if (jArray != null) {
                    for (i = 0; i < jArray.length() || i < 12; i++) {
                        JSONObject jsonObject = jArray.getJSONObject(i);

                        getJsonData[0] = jsonObject.getString("hotelcode");
                        getJsonData[1] = jsonObject.getString("score1");
                        getJsonData[2] = jsonObject.getString("score2");
                        getJsonData[3] = jsonObject.getString("score3");
                        getJsonData[4] = jsonObject.getString("score4");
                        getJsonData[5] = jsonObject.getString("score5");
                        getJsonData[6] = jsonObject.getString("price");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
    }

    class TutorialData extends AsyncTask<String, Void, String> {

        StringBuffer buffer = new StringBuffer();
        String sendMsg;
        String receiveMsg = "";

        @Override
        protected String doInBackground(String... strings) {
            try {
                String str;
                URL url = new URL("http://222.116.135.77:8080/NCCC_H/inserttutdata.jsp");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestMethod("POST");

                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());

                sendMsg = "userid="+strings[0]+"&hotelcode="+strings[1]+"&score1="+strings[2]+"&score2="+strings[3]+"&score3="+strings[4]+"&score4="+strings[5]+"&score5="+strings[6]+"&average="+strings[7]+"&starscore="+strings[8];
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
                Log.d("receiveMsg: ", receiveMsg);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return receiveMsg;
        }

        /*@Override
        protected void onPostExecute(String receiveMsg) {
            super.onPostExecute(receiveMsg);
            Log.d(receiveMsg,"<<<<<onPostExecute>>>>>");
            try {
                JSONArray jArray = new JSONObject(receiveMsg).getJSONArray(userID);
                if (jArray != null) {
                    for (i = 0; i < jArray.length() || i < 12; i++) {
                        JSONObject jsonObject = jArray.getJSONObject(i);

                        getJsonData[0] = jsonObject.getString("hotelcode");
                        getJsonData[1] = jsonObject.getString("score1");
                        getJsonData[2] = jsonObject.getString("score2");
                        getJsonData[3] = jsonObject.getString("score3");
                        getJsonData[4] = jsonObject.getString("score4");
                        getJsonData[5] = jsonObject.getString("score5");
                        getJsonData[6] = jsonObject.getString("price");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
    }
}

/*tutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 12) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    viewLayper.showNext();
                    i++;
                }
            }
        });

        bckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 1) {
                    Toast.makeText(getApplicationContext(), "첫 번째 항목입니다..",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    viewLayper.showPrevious();
                    i--;
                }
            }
        });*/