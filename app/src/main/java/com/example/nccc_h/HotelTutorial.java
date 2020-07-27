package com.example.nccc_h;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class HotelTutorial extends AppCompatActivity {

    ImageView tutImage1_flip1;
    ImageView tutImage2_flip1;

    ProgressBar tutPrgrBar1_flip1;
    ProgressBar tutPrgrBar2_flip1;
    ProgressBar tutPrgrBar3_flip1;
    ProgressBar tutPrgrBar4_flip1;
    ProgressBar tutPrgrBar5_flip1;

    TextView tutPrgrNum1_flip1;
    TextView tutPrgrNum2_flip1;
    TextView tutPrgrNum3_flip1;
    TextView tutPrgrNum4_flip1;
    TextView tutPrgrNum5_flip1;
    TextView tutValue_flip1;

    RatingBar tutRating_flip1;

    ImageView tutImage1_flip2;
    ImageView tutImage2_flip2;

    ProgressBar tutPrgrBar1_flip2;
    ProgressBar tutPrgrBar2_flip2;
    ProgressBar tutPrgrBar3_flip2;
    ProgressBar tutPrgrBar4_flip2;
    ProgressBar tutPrgrBar5_flip2;

    TextView tutPrgrNum1_flip2;
    TextView tutPrgrNum2_flip2;
    TextView tutPrgrNum3_flip2;
    TextView tutPrgrNum4_flip2;
    TextView tutPrgrNum5_flip2;
    TextView tutValue_flip2;

    RatingBar tutRating_flip2;

    ImageView tutImage1_flip3;
    ImageView tutImage2_flip3;

    ProgressBar tutPrgrBar1_flip3;
    ProgressBar tutPrgrBar2_flip3;
    ProgressBar tutPrgrBar3_flip3;
    ProgressBar tutPrgrBar4_flip3;
    ProgressBar tutPrgrBar5_flip3;

    TextView tutPrgrNum1_flip3;
    TextView tutPrgrNum2_flip3;
    TextView tutPrgrNum3_flip3;
    TextView tutPrgrNum4_flip3;
    TextView tutPrgrNum5_flip3;
    TextView tutValue_flip3;

    RatingBar tutRating_flip3;

    ImageView tutImage1_flip4;
    ImageView tutImage2_flip4;

    ProgressBar tutPrgrBar1_flip4;
    ProgressBar tutPrgrBar2_flip4;
    ProgressBar tutPrgrBar3_flip4;
    ProgressBar tutPrgrBar4_flip4;
    ProgressBar tutPrgrBar5_flip4;

    TextView tutPrgrNum1_flip4;
    TextView tutPrgrNum2_flip4;
    TextView tutPrgrNum3_flip4;
    TextView tutPrgrNum4_flip4;
    TextView tutPrgrNum5_flip4;
    TextView tutValue_flip4;

    RatingBar tutRating_flip4;

    ImageView tutImage1_flip5;
    ImageView tutImage2_flip5;

    ProgressBar tutPrgrBar1_flip5;
    ProgressBar tutPrgrBar2_flip5;
    ProgressBar tutPrgrBar3_flip5;
    ProgressBar tutPrgrBar4_flip5;
    ProgressBar tutPrgrBar5_flip5;

    TextView tutPrgrNum1_flip5;
    TextView tutPrgrNum2_flip5;
    TextView tutPrgrNum3_flip5;
    TextView tutPrgrNum4_flip5;
    TextView tutPrgrNum5_flip5;
    TextView tutValue_flip5;

    RatingBar tutRating_flip5;

    ImageView tutImage1_flip6;
    ImageView tutImage2_flip6;

    ProgressBar tutPrgrBar1_flip6;
    ProgressBar tutPrgrBar2_flip6;
    ProgressBar tutPrgrBar3_flip6;
    ProgressBar tutPrgrBar4_flip6;
    ProgressBar tutPrgrBar5_flip6;

    TextView tutPrgrNum1_flip6;
    TextView tutPrgrNum2_flip6;
    TextView tutPrgrNum3_flip6;
    TextView tutPrgrNum4_flip6;
    TextView tutPrgrNum5_flip6;
    TextView tutValue_flip6;

    RatingBar tutRating_flip6;

    ImageView tutImage1_flip7;
    ImageView tutImage2_flip7;

    ProgressBar tutPrgrBar1_flip7;
    ProgressBar tutPrgrBar2_flip7;
    ProgressBar tutPrgrBar3_flip7;
    ProgressBar tutPrgrBar4_flip7;
    ProgressBar tutPrgrBar5_flip7;

    TextView tutPrgrNum1_flip7;
    TextView tutPrgrNum2_flip7;
    TextView tutPrgrNum3_flip7;
    TextView tutPrgrNum4_flip7;
    TextView tutPrgrNum5_flip7;
    TextView tutValue_flip7;

    RatingBar tutRating_flip7;

    ImageView tutImage1_flip8;
    ImageView tutImage2_flip8;

    ProgressBar tutPrgrBar1_flip8;
    ProgressBar tutPrgrBar2_flip8;
    ProgressBar tutPrgrBar3_flip8;
    ProgressBar tutPrgrBar4_flip8;
    ProgressBar tutPrgrBar5_flip8;

    TextView tutPrgrNum1_flip8;
    TextView tutPrgrNum2_flip8;
    TextView tutPrgrNum3_flip8;
    TextView tutPrgrNum4_flip8;
    TextView tutPrgrNum5_flip8;
    TextView tutValue_flip8;

    RatingBar tutRating_flip8;

    ImageView tutImage1_flip9;
    ImageView tutImage2_flip9;

    ProgressBar tutPrgrBar1_flip9;
    ProgressBar tutPrgrBar2_flip9;
    ProgressBar tutPrgrBar3_flip9;
    ProgressBar tutPrgrBar4_flip9;
    ProgressBar tutPrgrBar5_flip9;

    TextView tutPrgrNum1_flip9;
    TextView tutPrgrNum2_flip9;
    TextView tutPrgrNum3_flip9;
    TextView tutPrgrNum4_flip9;
    TextView tutPrgrNum5_flip9;
    TextView tutValue_flip9;

    RatingBar tutRating_flip9;

    ImageView tutImage1_flip10;
    ImageView tutImage2_flip10;

    ProgressBar tutPrgrBar1_flip10;
    ProgressBar tutPrgrBar2_flip10;
    ProgressBar tutPrgrBar3_flip10;
    ProgressBar tutPrgrBar4_flip10;
    ProgressBar tutPrgrBar5_flip10;

    TextView tutPrgrNum1_flip10;
    TextView tutPrgrNum2_flip10;
    TextView tutPrgrNum3_flip10;
    TextView tutPrgrNum4_flip10;
    TextView tutPrgrNum5_flip10;
    TextView tutValue_flip10;

    RatingBar tutRating_flip10;

    ImageView tutImage1_flip11;
    ImageView tutImage2_flip11;

    ProgressBar tutPrgrBar1_flip11;
    ProgressBar tutPrgrBar2_flip11;
    ProgressBar tutPrgrBar3_flip11;
    ProgressBar tutPrgrBar4_flip11;
    ProgressBar tutPrgrBar5_flip11;

    TextView tutPrgrNum1_flip11;
    TextView tutPrgrNum2_flip11;
    TextView tutPrgrNum3_flip11;
    TextView tutPrgrNum4_flip11;
    TextView tutPrgrNum5_flip11;
    TextView tutValue_flip11;

    RatingBar tutRating_flip11;

    ImageView tutImage1_flip12;
    ImageView tutImage2_flip12;

    ProgressBar tutPrgrBar1_flip12;
    ProgressBar tutPrgrBar2_flip12;
    ProgressBar tutPrgrBar3_flip12;
    ProgressBar tutPrgrBar4_flip12;
    ProgressBar tutPrgrBar5_flip12;

    TextView tutPrgrNum1_flip12;
    TextView tutPrgrNum2_flip12;
    TextView tutPrgrNum3_flip12;
    TextView tutPrgrNum4_flip12;
    TextView tutPrgrNum5_flip12;
    TextView tutValue_flip12;

    RatingBar tutRating_flip12;

    Button tutBtn;
    Button bckBtn;

    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_tutorial);

        final ViewFlipper viewFlipper;
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);
        this.setFirst();
        this.SetListener();


        tutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 12) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    viewFlipper.showNext();
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
                    viewFlipper.showPrevious();
                    i--;
                }
            }
        });
    }

    public void setFirst() {
        tutImage1_flip1 = (ImageView) findViewById(R.id.hotel_tutorial_img1_flip1);
        tutImage2_flip1 = (ImageView) findViewById(R.id.hotel_tutorial_img2_flip1);

        tutPrgrBar1_flip1 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress1_flip1);
        tutPrgrBar2_flip1 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress2_flip1);
        tutPrgrBar3_flip1 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress3_flip1);
        tutPrgrBar4_flip1 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress4_flip1);
        tutPrgrBar5_flip1 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress5_flip1);

        tutPrgrNum1_flip1 = (TextView) findViewById(R.id.tutorial_value1_flip1);
        tutPrgrNum2_flip1 = (TextView) findViewById(R.id.tutorial_value2_flip1);
        tutPrgrNum3_flip1 = (TextView) findViewById(R.id.tutorial_value3_flip1);
        tutPrgrNum4_flip1 = (TextView) findViewById(R.id.tutorial_value4_flip1);
        tutPrgrNum5_flip1 = (TextView) findViewById(R.id.tutorial_value5_flip1);

        tutValue_flip1 = (TextView) findViewById(R.id.tutorial_value6_flip1);

        tutRating_flip1 = (RatingBar) findViewById(R.id.hotel_tutorial_rating_flip1);

        tutImage1_flip2 = (ImageView) findViewById(R.id.hotel_tutorial_img1_flip2);
        tutImage2_flip2 = (ImageView) findViewById(R.id.hotel_tutorial_img2_flip2);

        tutPrgrBar1_flip2 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress1_flip2);
        tutPrgrBar2_flip2 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress2_flip2);
        tutPrgrBar3_flip2 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress3_flip2);
        tutPrgrBar4_flip2 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress4_flip2);
        tutPrgrBar5_flip2 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress5_flip2);

        tutPrgrNum1_flip2 = (TextView) findViewById(R.id.tutorial_value1_flip2);
        tutPrgrNum2_flip2 = (TextView) findViewById(R.id.tutorial_value2_flip2);
        tutPrgrNum3_flip2 = (TextView) findViewById(R.id.tutorial_value3_flip2);
        tutPrgrNum4_flip2 = (TextView) findViewById(R.id.tutorial_value4_flip2);
        tutPrgrNum5_flip2 = (TextView) findViewById(R.id.tutorial_value5_flip2);

        tutValue_flip2 = (TextView) findViewById(R.id.tutorial_value6_flip2);

        tutRating_flip2 = (RatingBar) findViewById(R.id.hotel_tutorial_rating_flip2);

        tutImage1_flip3 = (ImageView) findViewById(R.id.hotel_tutorial_img1_flip3);
        tutImage2_flip3 = (ImageView) findViewById(R.id.hotel_tutorial_img2_flip3);

        tutPrgrBar1_flip3 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress1_flip3);
        tutPrgrBar2_flip3 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress2_flip3);
        tutPrgrBar3_flip3 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress3_flip3);
        tutPrgrBar4_flip3 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress4_flip3);
        tutPrgrBar5_flip3 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress5_flip3);

        tutPrgrNum1_flip3 = (TextView) findViewById(R.id.tutorial_value1_flip3);
        tutPrgrNum2_flip3 = (TextView) findViewById(R.id.tutorial_value2_flip3);
        tutPrgrNum3_flip3 = (TextView) findViewById(R.id.tutorial_value3_flip3);
        tutPrgrNum4_flip3 = (TextView) findViewById(R.id.tutorial_value4_flip3);
        tutPrgrNum5_flip3 = (TextView) findViewById(R.id.tutorial_value5_flip3);

        tutValue_flip3 = (TextView) findViewById(R.id.tutorial_value6_flip3);

        tutRating_flip3 = (RatingBar) findViewById(R.id.hotel_tutorial_rating_flip3);

        tutImage1_flip4 = (ImageView) findViewById(R.id.hotel_tutorial_img1_flip4);
        tutImage2_flip4 = (ImageView) findViewById(R.id.hotel_tutorial_img2_flip4);

        tutPrgrBar1_flip4 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress1_flip4);
        tutPrgrBar2_flip4 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress2_flip4);
        tutPrgrBar3_flip4 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress3_flip4);
        tutPrgrBar4_flip4 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress4_flip4);
        tutPrgrBar5_flip4 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress5_flip4);

        tutPrgrNum1_flip4 = (TextView) findViewById(R.id.tutorial_value1_flip4);
        tutPrgrNum2_flip4 = (TextView) findViewById(R.id.tutorial_value2_flip4);
        tutPrgrNum3_flip4 = (TextView) findViewById(R.id.tutorial_value3_flip4);
        tutPrgrNum4_flip4 = (TextView) findViewById(R.id.tutorial_value4_flip4);
        tutPrgrNum5_flip4 = (TextView) findViewById(R.id.tutorial_value5_flip4);

        tutValue_flip4 = (TextView) findViewById(R.id.tutorial_value6_flip4);

        tutRating_flip4 = (RatingBar) findViewById(R.id.hotel_tutorial_rating_flip4);

        tutImage1_flip5 = (ImageView) findViewById(R.id.hotel_tutorial_img1_flip5);
        tutImage2_flip5 = (ImageView) findViewById(R.id.hotel_tutorial_img2_flip5);

        tutPrgrBar1_flip5 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress1_flip5);
        tutPrgrBar2_flip5 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress2_flip5);
        tutPrgrBar3_flip5 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress3_flip5);
        tutPrgrBar4_flip5 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress4_flip5);
        tutPrgrBar5_flip5 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress5_flip5);

        tutPrgrNum1_flip5 = (TextView) findViewById(R.id.tutorial_value1_flip5);
        tutPrgrNum2_flip5 = (TextView) findViewById(R.id.tutorial_value2_flip5);
        tutPrgrNum3_flip5 = (TextView) findViewById(R.id.tutorial_value3_flip5);
        tutPrgrNum4_flip5 = (TextView) findViewById(R.id.tutorial_value4_flip5);
        tutPrgrNum5_flip5 = (TextView) findViewById(R.id.tutorial_value5_flip5);

        tutValue_flip5 = (TextView) findViewById(R.id.tutorial_value6_flip5);

        tutRating_flip5 = (RatingBar) findViewById(R.id.hotel_tutorial_rating_flip5);

        tutImage1_flip6 = (ImageView) findViewById(R.id.hotel_tutorial_img1_flip6);
        tutImage2_flip6 = (ImageView) findViewById(R.id.hotel_tutorial_img2_flip6);

        tutPrgrBar1_flip6 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress1_flip6);
        tutPrgrBar2_flip6 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress2_flip6);
        tutPrgrBar3_flip6 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress3_flip6);
        tutPrgrBar4_flip6 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress4_flip6);
        tutPrgrBar5_flip6 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress5_flip6);

        tutPrgrNum1_flip6 = (TextView) findViewById(R.id.tutorial_value1_flip6);
        tutPrgrNum2_flip6 = (TextView) findViewById(R.id.tutorial_value2_flip6);
        tutPrgrNum3_flip6 = (TextView) findViewById(R.id.tutorial_value3_flip6);
        tutPrgrNum4_flip6 = (TextView) findViewById(R.id.tutorial_value4_flip6);
        tutPrgrNum5_flip6 = (TextView) findViewById(R.id.tutorial_value5_flip6);

        tutValue_flip6 = (TextView) findViewById(R.id.tutorial_value6_flip6);

        tutRating_flip6 = (RatingBar) findViewById(R.id.hotel_tutorial_rating_flip6);

        tutImage1_flip7 = (ImageView) findViewById(R.id.hotel_tutorial_img1_flip7);
        tutImage2_flip7 = (ImageView) findViewById(R.id.hotel_tutorial_img2_flip7);

        tutPrgrBar1_flip7 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress1_flip7);
        tutPrgrBar2_flip7 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress2_flip7);
        tutPrgrBar3_flip7 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress3_flip7);
        tutPrgrBar4_flip7 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress4_flip7);
        tutPrgrBar5_flip7 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress5_flip7);

        tutPrgrNum1_flip7 = (TextView) findViewById(R.id.tutorial_value1_flip7);
        tutPrgrNum2_flip7 = (TextView) findViewById(R.id.tutorial_value2_flip7);
        tutPrgrNum3_flip7 = (TextView) findViewById(R.id.tutorial_value3_flip7);
        tutPrgrNum4_flip7 = (TextView) findViewById(R.id.tutorial_value4_flip7);
        tutPrgrNum5_flip7 = (TextView) findViewById(R.id.tutorial_value5_flip7);

        tutValue_flip7 = (TextView) findViewById(R.id.tutorial_value6_flip7);

        tutRating_flip7 = (RatingBar) findViewById(R.id.hotel_tutorial_rating_flip7);

        tutImage1_flip8 = (ImageView) findViewById(R.id.hotel_tutorial_img1_flip8);
        tutImage2_flip8 = (ImageView) findViewById(R.id.hotel_tutorial_img2_flip8);

        tutPrgrBar1_flip8 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress1_flip8);
        tutPrgrBar2_flip8 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress2_flip8);
        tutPrgrBar3_flip8 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress3_flip8);
        tutPrgrBar4_flip8 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress4_flip8);
        tutPrgrBar5_flip8 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress5_flip8);

        tutPrgrNum1_flip8 = (TextView) findViewById(R.id.tutorial_value1_flip8);
        tutPrgrNum2_flip8 = (TextView) findViewById(R.id.tutorial_value2_flip8);
        tutPrgrNum3_flip8 = (TextView) findViewById(R.id.tutorial_value3_flip8);
        tutPrgrNum4_flip8 = (TextView) findViewById(R.id.tutorial_value4_flip8);
        tutPrgrNum5_flip8 = (TextView) findViewById(R.id.tutorial_value5_flip8);

        tutValue_flip8 = (TextView) findViewById(R.id.tutorial_value6_flip8);

        tutRating_flip8 = (RatingBar) findViewById(R.id.hotel_tutorial_rating_flip8);

        tutImage1_flip9 = (ImageView) findViewById(R.id.hotel_tutorial_img1_flip9);
        tutImage2_flip9 = (ImageView) findViewById(R.id.hotel_tutorial_img2_flip9);

        tutPrgrBar1_flip9 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress1_flip9);
        tutPrgrBar2_flip9 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress2_flip9);
        tutPrgrBar3_flip9 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress3_flip9);
        tutPrgrBar4_flip9 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress4_flip9);
        tutPrgrBar5_flip9 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress5_flip9);

        tutPrgrNum1_flip9 = (TextView) findViewById(R.id.tutorial_value1_flip9);
        tutPrgrNum2_flip9 = (TextView) findViewById(R.id.tutorial_value2_flip9);
        tutPrgrNum3_flip9 = (TextView) findViewById(R.id.tutorial_value3_flip9);
        tutPrgrNum4_flip9 = (TextView) findViewById(R.id.tutorial_value4_flip9);
        tutPrgrNum5_flip9 = (TextView) findViewById(R.id.tutorial_value5_flip9);

        tutValue_flip9 = (TextView) findViewById(R.id.tutorial_value6_flip9);

        tutRating_flip9 = (RatingBar) findViewById(R.id.hotel_tutorial_rating_flip9);

        tutImage1_flip10 = (ImageView) findViewById(R.id.hotel_tutorial_img1_flip10);
        tutImage2_flip10 = (ImageView) findViewById(R.id.hotel_tutorial_img2_flip10);

        tutPrgrBar1_flip10 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress1_flip10);
        tutPrgrBar2_flip10 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress2_flip10);
        tutPrgrBar3_flip10 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress3_flip10);
        tutPrgrBar4_flip10 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress4_flip10);
        tutPrgrBar5_flip10 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress5_flip10);

        tutPrgrNum1_flip10 = (TextView) findViewById(R.id.tutorial_value1_flip10);
        tutPrgrNum2_flip10 = (TextView) findViewById(R.id.tutorial_value2_flip10);
        tutPrgrNum3_flip10 = (TextView) findViewById(R.id.tutorial_value3_flip10);
        tutPrgrNum4_flip10 = (TextView) findViewById(R.id.tutorial_value4_flip10);
        tutPrgrNum5_flip10 = (TextView) findViewById(R.id.tutorial_value5_flip10);

        tutValue_flip10 = (TextView) findViewById(R.id.tutorial_value6_flip10);

        tutRating_flip10 = (RatingBar) findViewById(R.id.hotel_tutorial_rating_flip10);

        tutImage1_flip11 = (ImageView) findViewById(R.id.hotel_tutorial_img1_flip11);
        tutImage2_flip11 = (ImageView) findViewById(R.id.hotel_tutorial_img2_flip11);

        tutPrgrBar1_flip11 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress1_flip11);
        tutPrgrBar2_flip11 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress2_flip11);
        tutPrgrBar3_flip11 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress3_flip11);
        tutPrgrBar4_flip11 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress4_flip11);
        tutPrgrBar5_flip11 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress5_flip11);

        tutPrgrNum1_flip11 = (TextView) findViewById(R.id.tutorial_value1_flip11);
        tutPrgrNum2_flip11 = (TextView) findViewById(R.id.tutorial_value2_flip11);
        tutPrgrNum3_flip11 = (TextView) findViewById(R.id.tutorial_value3_flip11);
        tutPrgrNum4_flip11 = (TextView) findViewById(R.id.tutorial_value4_flip11);
        tutPrgrNum5_flip11 = (TextView) findViewById(R.id.tutorial_value5_flip11);

        tutValue_flip11 = (TextView) findViewById(R.id.tutorial_value6_flip11);

        tutRating_flip11 = (RatingBar) findViewById(R.id.hotel_tutorial_rating_flip11);

        tutImage1_flip12 = (ImageView) findViewById(R.id.hotel_tutorial_img1_flip12);
        tutImage2_flip12 = (ImageView) findViewById(R.id.hotel_tutorial_img2_flip12);

        tutPrgrBar1_flip12 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress1_flip12);
        tutPrgrBar2_flip12 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress2_flip12);
        tutPrgrBar3_flip12 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress3_flip12);
        tutPrgrBar4_flip12 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress4_flip12);
        tutPrgrBar5_flip12 = (ProgressBar) findViewById(R.id.hotel_tutorial_progress5_flip12);

        tutPrgrNum1_flip12 = (TextView) findViewById(R.id.tutorial_value1_flip12);
        tutPrgrNum2_flip12 = (TextView) findViewById(R.id.tutorial_value2_flip12);
        tutPrgrNum3_flip12 = (TextView) findViewById(R.id.tutorial_value3_flip12);
        tutPrgrNum4_flip12 = (TextView) findViewById(R.id.tutorial_value4_flip12);
        tutPrgrNum5_flip12 = (TextView) findViewById(R.id.tutorial_value5_flip12);

        tutValue_flip12 = (TextView) findViewById(R.id.tutorial_value6_flip12);

        tutRating_flip12 = (RatingBar) findViewById(R.id.hotel_tutorial_rating_flip12);

        tutBtn = (Button) findViewById(R.id.tutorial_next);
        bckBtn = (Button) findViewById(R.id.tutorial_back);

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

    public void SetListener() {
        tutRating_flip1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            }
        });

        tutRating_flip2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            }
        });

        tutRating_flip3.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            }
        });

        tutRating_flip4.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            }
        });

        tutRating_flip5.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            }
        });

        tutRating_flip6.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            }
        });

        tutRating_flip7.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            }
        });

        tutRating_flip8.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            }
        });
        tutRating_flip9.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            }
        });

        tutRating_flip10.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            }
        });

        tutRating_flip11.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            }
        });

        tutRating_flip12.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            }
        });

    }
}
