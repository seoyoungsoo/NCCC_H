package com.example.nccc_h;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

public class HotelDetail extends AppCompatActivity {

    final int max = 10;
    final int min = 0;
    final float step = (float) 0.1;

    ImageView backBtn;
    ImageView htlImage1;
    ImageView htlImage2;

    TextView htlTitle;
    TextView htlCountry;
    TextView htlAddr;

    TextView htlPrgrNum1;
    TextView htlPrgrNum2;
    TextView htlPrgrNum3;
    TextView htlPrgrNum4;
    TextView htlPrgrNum5;

    TextView htlValue;

    TextView evalValue1;
    TextView evalValue2;
    TextView evalValue3;
    TextView evalValue4;
    TextView evalValue5;

    TextView popTourList;
    TextView nearTourList;

    Button htlEval;
    Button htlReservation;
    Button htlEval_Eval;

    ImageButton evalBack;

    ProgressBar htlPrgrBar1;
    ProgressBar htlPrgrBar2;
    ProgressBar htlPrgrBar3;
    ProgressBar htlPrgrBar4;
    ProgressBar htlPrgrBar5;

    CheckBox evalVisited;

    SeekBar evalSeek1;
    SeekBar evalSeek2;
    SeekBar evalSeek3;
    SeekBar evalSeek4;
    SeekBar evalSeek5;

    RatingBar evalRating;

    LinearLayout linearEvaluation;
    LinearLayout evalVisible;
    LinearLayout backGround;

    FrameLayout subBackGround;

    Boolean inflateView = false;
    Boolean evalCont = false; // 평가 유무확인 true면 평가한 것

    String result;

    String userID;
    String hotelname; //호텔이름
    String hotelcode;
    String cityname; //도시이름

    String ratingVal;

    //AsyncTask 연동을 통해 받아올 내용
    List<String> address = new ArrayList<>();
    List<String> value1 = new ArrayList<>();
    List<String> value2 = new ArrayList<>();
    List<String> value3 = new ArrayList<>();
    List<String> value4 = new ArrayList<>();
    List<String> value5 = new ArrayList<>();
    List<String> average = new ArrayList<>();
    List<String> price = new ArrayList<>();
    List<String> popular = new ArrayList<>();
    List<String> near = new ArrayList<>();
    List<String> url = new ArrayList<>();

    //방문 호텔의 사용자 평점
    String userVal1;
    String userVal2;
    String userVal3;
    String userVal4;
    String userVal5;


    DetailTask detailTask = new DetailTask();
    EvalTask evalTask = new EvalTask();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_detail);

        Intent intent = getIntent();
        userID = intent.getStringExtra("userID");
        hotelname = intent.getStringExtra("hotelname");
        hotelcode = intent.getStringExtra("hotelcode");
        cityname = intent.getStringExtra("citycode");

        this.setFirst();
        this.getDetailJsonData();
        this.getHotelData();
        this.evalHotel();
        this.setBack();

    }

    //호텔 평가하기 누를 때 평가 유무 확인 및 AsyncTask 연동
    public void evalHotel() {
        htlEval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (evalCont) {
                    Toast.makeText(getApplicationContext(), "이미 평가한 호텔입니다.", Toast.LENGTH_SHORT).show();
                } else {

                    setEvaluation();
                    setSeek();
                    setEval();

                    htlEval_Eval.setOnClickListener(new View.OnClickListener() { //평가하기 버튼
                        @Override
                        public void onClick(View v) {
                            evalCont = true;

                            //Asynctask 연동
                            if (evalVisited.isChecked() == false) { // deep 테이블에 추가
                                evalTask.execute(userID, hotelcode, value1.get(0), value2.get(0), value3.get(0), value4.get(0), value5.get(0), average.get(0), ratingVal);
                            } else if (evalVisited.isChecked() == true) { // deep 테이블과 visited 테이블에 추가
                                evalTask.execute(userID, hotelcode, userVal1, userVal2, userVal3, userVal4, userVal5, average.get(0), ratingVal);
                            }

                            Toast.makeText(getApplicationContext(), "평가됐습니다.", Toast.LENGTH_SHORT).show();

                            ViewGroup pvGroup = (ViewGroup) linearEvaluation.getParent();
                            pvGroup.removeView(linearEvaluation);
                            inflateView = false;
                        }
                    });
                }
            }
        });
    }

    //평가화면 초기 설정
    public void setEvaluation() {
        inflateView = true;
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        linearEvaluation = (LinearLayout) inflater.inflate(R.layout.activity_hotel_evaluation, null);

        LinearLayout.LayoutParams paramlinear = new LinearLayout.LayoutParams(

                LinearLayout.LayoutParams.MATCH_PARENT,

                LinearLayout.LayoutParams.MATCH_PARENT
        );

        evalBack = (ImageButton) linearEvaluation.findViewById(R.id.back);
        backGround = (LinearLayout) linearEvaluation.findViewById(R.id.background);
        subBackGround = (FrameLayout) linearEvaluation.findViewById(R.id.sub_background);
        evalVisited = (CheckBox) linearEvaluation.findViewById(R.id.hotel_evaluation_checkbox);
        evalSeek1 = (SeekBar) linearEvaluation.findViewById(R.id.hotel_evaluation_seekbar1);
        evalSeek2 = (SeekBar) linearEvaluation.findViewById(R.id.hotel_evaluation_seekbar2);
        evalSeek3 = (SeekBar) linearEvaluation.findViewById(R.id.hotel_evaluation_seekbar3);
        evalSeek4 = (SeekBar) linearEvaluation.findViewById(R.id.hotel_evaluation_seekbar4);
        evalSeek5 = (SeekBar) linearEvaluation.findViewById(R.id.hotel_evaluation_seekbar5);
        evalRating = (RatingBar) linearEvaluation.findViewById(R.id.hotel_evaluation_rating);
        htlEval_Eval = (Button) linearEvaluation.findViewById(R.id.hotel_evaluation_button);

        evalValue1 = (TextView) linearEvaluation.findViewById(R.id.hotel_evaluation_value1);
        evalValue2 = (TextView) linearEvaluation.findViewById(R.id.hotel_evaluation_value2);
        evalValue3 = (TextView) linearEvaluation.findViewById(R.id.hotel_evaluation_value3);
        evalValue4 = (TextView) linearEvaluation.findViewById(R.id.hotel_evaluation_value4);
        evalValue5 = (TextView) linearEvaluation.findViewById(R.id.hotel_evaluation_value5);

        evalVisible = (LinearLayout) linearEvaluation.findViewById(R.id.hotel_evaluation_layout);

        addContentView(linearEvaluation, paramlinear);
        evalVisited.setChecked(false);
        evalVisible.setVisibility(View.GONE);
    }

    //평가하기 시크바 초기 설정
    public void setSeek() {
        evalSeek1.setProgress((int)(Float.parseFloat(value1.get(0))*10));
        evalValue1.setText(value1.get(0));
        evalSeek2.setProgress((int)(Float.parseFloat(value2.get(0))*10));
        evalValue2.setText(value2.get(0));
        evalSeek3.setProgress((int)(Float.parseFloat(value3.get(0))*10));
        evalValue3.setText(value3.get(0));
        evalSeek4.setProgress((int)(Float.parseFloat(value4.get(0))*10));
        evalValue4.setText(value4.get(0));
        evalSeek5.setProgress((int)(Float.parseFloat(value5.get(0))*10));
        evalValue5.setText(value5.get(0));
    }

    //평가하기 시크바 변환
    public void setEval() {
        setSeekBarMax(evalSeek1, max);
        evalSeek1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setSeekBarChange(progress, evalValue1);
                userVal1 = evalValue1.toString();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        setSeekBarMax(evalSeek2, max);
        evalSeek2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setSeekBarChange(progress, evalValue2);
                userVal2 = evalValue2.toString();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        setSeekBarMax(evalSeek3, max);
        evalSeek3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setSeekBarChange(progress, evalValue3);
                userVal3 = evalValue3.toString();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        setSeekBarMax(evalSeek4, max);
        evalSeek4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setSeekBarChange(progress, evalValue4);
                userVal4 = evalValue4.toString();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        setSeekBarMax(evalSeek5, max);
        evalSeek5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setSeekBarChange(progress, evalValue5);
                userVal5 = evalValue5.toString();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        evalRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingVal = Float.toString(rating);
            }
        });

        linearEvaluation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        subBackGround.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup parentViewGroup = (ViewGroup) linearEvaluation.getParent();
                parentViewGroup.removeView(linearEvaluation);
            }
        });

        backGround.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup parentViewGroup = (ViewGroup) linearEvaluation.getParent();
                parentViewGroup.removeView(linearEvaluation);
            }
        });

        evalBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup parentViewGroup = (ViewGroup) linearEvaluation.getParent();
                parentViewGroup.removeView(linearEvaluation);
            }
        });

        evalVisited.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (evalVisited.isChecked() == false) {
                    evalVisible.setVisibility(View.GONE);
                } else if (evalVisited.isChecked() == true) {
                    evalVisible.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    //상세화면 초기 설정
    public void setFirst() {

        backBtn = (ImageView) findViewById(R.id.hotel_detail_back);
        htlImage1 = (ImageView) findViewById(R.id.hotel_detail_img1);
        htlImage2 = (ImageView) findViewById(R.id.hotel_detail_img2);

        htlTitle = (TextView) findViewById(R.id.hotel_detail_title);

        htlCountry = (TextView) findViewById(R.id.hotel_country);
        htlAddr = (TextView) findViewById(R.id.hotel_addr);

        htlPrgrNum1 = (TextView) findViewById(R.id.progress_1);
        htlPrgrNum2 = (TextView) findViewById(R.id.progress_2);
        htlPrgrNum3 = (TextView) findViewById(R.id.progress_3);
        htlPrgrNum4 = (TextView) findViewById(R.id.progress_4);
        htlPrgrNum5 = (TextView) findViewById(R.id.progress_5);

        htlValue = (TextView) findViewById(R.id.hotel_detail_value);

        htlEval = (Button) findViewById(R.id.hotel_detail_evaluation);
        htlReservation = (Button) findViewById(R.id.hotel_detail_reservation);

        htlPrgrBar1 = (ProgressBar) findViewById(R.id.hotel_detail_progress1);
        htlPrgrBar2 = (ProgressBar) findViewById(R.id.hotel_detail_progress2);
        htlPrgrBar3 = (ProgressBar) findViewById(R.id.hotel_detail_progress3);
        htlPrgrBar4 = (ProgressBar) findViewById(R.id.hotel_detail_progress4);
        htlPrgrBar5 = (ProgressBar) findViewById(R.id.hotel_detail_progress5);

        popTourList = (TextView) findViewById(R.id.hotel_popular_Tourlist);
        nearTourList = (TextView) findViewById(R.id.hotel_near_Tourlist);
    }

    //상세화면
    public void getHotelData() {
        htlTitle.setText(hotelname);

        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo1/"+hotelcode+".jpg")
                .into(htlImage1);
        Glide.with(this)
                .load("http://222.116.135.77:8080/NCCC_H/photo2/"+hotelcode+".jpg")
                .into(htlImage2);

        htlCountry.setText(cityname);

        htlAddr.setText(address.get(0));

        htlPrgrBar1.setProgress((int)(Float.parseFloat(value1.get(0))*10));
        htlPrgrNum1.setText(value1.get(0));
        htlPrgrBar2.setProgress((int)(Float.parseFloat(value2.get(0))*10));
        htlPrgrNum2.setText(value2.get(0));
        htlPrgrBar3.setProgress((int)(Float.parseFloat(value3.get(0))*10));
        htlPrgrNum3.setText(value3.get(0));
        htlPrgrBar4.setProgress((int)(Float.parseFloat(value4.get(0))*10));
        htlPrgrNum4.setText(value4.get(0));
        htlPrgrBar5.setProgress((int)(Float.parseFloat(value5.get(0))*10));
        htlPrgrNum5.setText(value5.get(0));

        htlValue.setText(price.get(0));

        popTourList.setText(popular.get(0));
        nearTourList.setText(near.get(0));
    }

    public void setBack() {
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /*public void setEval() {
        htlEval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setEvaluation();

                setSeekBarMax(evalSeek1, max);
                evalSeek1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        setSeekBarChange(progress, evalValue1);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

                setSeekBarMax(evalSeek2, max);
                evalSeek2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        setSeekBarChange(progress, evalValue2);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

                setSeekBarMax(evalSeek3, max);
                evalSeek3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        setSeekBarChange(progress, evalValue3);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

                setSeekBarMax(evalSeek4, max);
                evalSeek4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        setSeekBarChange(progress, evalValue4);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

                setSeekBarMax(evalSeek5, max);
                evalSeek5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        setSeekBarChange(progress, evalValue5);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

                linearEvaluation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });

                subBackGround.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ViewGroup parentViewGroup = (ViewGroup) linearEvaluation.getParent();
                        parentViewGroup.removeView(linearEvaluation);
                    }
                });

                backGround.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ViewGroup parentViewGroup = (ViewGroup) linearEvaluation.getParent();
                        parentViewGroup.removeView(linearEvaluation);
                    }
                });

                evalBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ViewGroup parentViewGroup = (ViewGroup) linearEvaluation.getParent();
                        parentViewGroup.removeView(linearEvaluation);
                    }
                });

                evalVisited.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (evalVisited.isChecked() == false) {
                            evalVisible.setVisibility(View.GONE);
                        } else if (evalVisited.isChecked() == true) {
                            evalVisible.setVisibility(View.VISIBLE);
                        }
                    }
                });
            }

        });

    }*/

    private void setSeekBarMax(SeekBar sb, int max_value) {
        sb.setMax((int)((max_value-min) / step));
    }

    private void setSeekBarChange(int progress, TextView tv) {
        float value = min + (progress * step);
        DecimalFormat format = new DecimalFormat(".#");
        String str = format.format(value);
        tv.setText(""+Float.valueOf(str));
        if (value == 10.0) {
            tv.setText("10");
        } else if (value == 0.0) {
            tv.setText("0");
        }
    }

    @Override
    public void onBackPressed(){
        if(inflateView){ //view 에서 뒤로가기 버튼을 눌렀을 경우 액티비티가 종료되지 않고 뷰만 종료되도록
            ViewGroup parentViewGroup = (ViewGroup) linearEvaluation.getParent();
            parentViewGroup.removeView(linearEvaluation);
            inflateView = false;
        }else{
            super.onBackPressed();
        }
    }

    //상세화면 데이터 연동
    public void getDetailJsonData() {
        try {
            result = detailTask.execute(userID, hotelcode).get();
            JSONArray jsonArray = new JSONObject(result).getJSONArray(userID);

            JSONObject jsonObject = jsonArray.getJSONObject(0);
            address.add(jsonObject.getString("address"));
            value1.add(jsonObject.getString("value1"));
            value2.add(jsonObject.getString("value2"));
            value3.add(jsonObject.getString("value3"));
            value4.add(jsonObject.getString("value4"));
            value5.add(jsonObject.getString("value5"));
            average.add(jsonObject.getString("average"));
            price.add(jsonObject.getString("price"));
            popular.add(jsonObject.getString("popular"));
            near.add(jsonObject.getString("near"));
            url.add(jsonObject.getString("url"));

            Log.i(address.get(0), address.get(0));
            Log.i(url.get(0), url.get(0));


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    class DetailTask extends AsyncTask<String, Void, String> {

        StringBuffer buffer = new StringBuffer();
        String sendMsg;
        String receiveMsg = "";

        @Override
        protected String doInBackground(String... strings) {
            try {
                String str;
                URL url = new URL("http://222.116.135.77:8080/NCCC_H/detailhotel.jsp");
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
    
    //평가하기 버튼 클릭 시 결과값을 전달
    class EvalTask extends AsyncTask<String, Void, String> {

        StringBuffer buffer = new StringBuffer();
        String sendMsg;
        String receiveMsg = "";

        @Override
        protected String doInBackground(String... strings) {
            try {
                String str;
                URL url = new URL("http://222.116.135.77:8080/NCCC_H/detaileval.jsp");
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

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return receiveMsg;
        }
    }
}
