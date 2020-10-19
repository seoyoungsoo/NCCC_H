package com.example.nccc_h;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HotelGrasp extends AppCompatActivity {
    CheckBox grspBox1;
    CheckBox grspBox2;
    CheckBox grspBox3;
    CheckBox grspBox4;
    CheckBox grspBox5;

    int score1 = 0;
    int score2 = 0;
    int score3 = 0;
    int score4 = 0;
    int score5 = 0;

    int minT;
    int maxT;

    String min;
    String max;

    Button grspStart;
    Button grspExit;

    EditText minPrice;
    EditText maxPrice;

    GraspTask graspTask = new GraspTask();

    Boolean insertDB = true;

    static int i = 0;

    String result;

    Model_Data modelData = new Model_Data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_grasp);

        this.setFirst();
        this.setBoxClickListener();

        final String userID = getDeviceId();

        grspStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (i == 0 ) {
                    Toast.makeText(getApplicationContext(), "최소 1가지의 항목을 선택해야 합니다..", Toast.LENGTH_SHORT).show();
                } else {
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

                            try {
                                result = graspTask.execute(userID).get();
                                if (result.equals("S")) {
                                    Log.i("hihi", "ssssss");
                                    insertDB = false;
                                }
                            } catch (Exception e) {
                                Log.i("hihi", ""+e);
                            }
                            while (insertDB);
                            modelData.sendID(userID);
                            Intent i = new Intent(getApplicationContext(), HotelTutorial.class);
                            i.putExtra("min", min);
                            i.putExtra("max", max);
                            i.putExtra("userID", userID);
                            startActivity(i);
                            finish();
                        }
                    }
                }
            }
        });


    }

    public String getDeviceId() {
        String userId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        return userId;
    }

    public void setBoxClickListener() {
        grspBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (grspBox1.isChecked() == true) {
                    if (i >= 3) {
                        Toast.makeText(getApplicationContext(), "최대 3가지만 선택할 수 있습니다.",
                                Toast.LENGTH_SHORT).show();
                        grspBox1.setChecked(false);
                    } else if (i < 3) {
                        i++;
                        score1++;
                    }
                } else if (grspBox1.isChecked() == false) {
                    i--;
                    score1--;
                }
            }
        });

        grspBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (grspBox2.isChecked() == true) {
                    if (i >= 3) {
                        Toast.makeText(getApplicationContext(), "최대 3가지만 선택할 수 있습니다.",
                                Toast.LENGTH_SHORT).show();
                        grspBox2.setChecked(false);
                    } else if (i < 3) {
                        i++;
                        score2++;
                    }
                } else if (grspBox2.isChecked() == false) {
                    i--;
                    score2--;
                }
            }
        });

        grspBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (grspBox3.isChecked() == true) {
                    if (i >= 3) {
                        Toast.makeText(getApplicationContext(), "최대 3가지만 선택할 수 있습니다.",
                                Toast.LENGTH_SHORT).show();
                        grspBox3.setChecked(false);
                    } else if (i < 3) {
                        i++;
                        score3++;
                    }
                } else if (grspBox3.isChecked() == false) {
                    i--;
                    score3--;
                }
            }
        });

        grspBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (grspBox4.isChecked() == true) {
                    if (i >= 3) {
                        Toast.makeText(getApplicationContext(), "최대 3가지만 선택할 수 있습니다.",
                                Toast.LENGTH_SHORT).show();
                        grspBox4.setChecked(false);
                    } else if (i < 3) {
                        i++;
                        score4++;
                    }
                } else if (grspBox4.isChecked() == false) {
                    i--;
                    score4--;
                }
            }
        });

        grspBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (grspBox5.isChecked() == true) {
                    if (i >= 3) {
                        Toast.makeText(getApplicationContext(), "최대 3가지만 선택할 수 있습니다.",
                                Toast.LENGTH_SHORT).show();
                        grspBox5.setChecked(false);
                    } else if (i < 3) {
                        i++;
                        score5++;
                    }
                } else if (grspBox5.isChecked() == false) {
                    i--;
                    score5--;
                }
            }
        });
    }

    private void setFirst() {
        grspBox1 = (CheckBox) findViewById(R.id.hotel_grasp_box1);
        grspBox2 = (CheckBox) findViewById(R.id.hotel_grasp_box2);
        grspBox3 = (CheckBox) findViewById(R.id.hotel_grasp_box3);
        grspBox4 = (CheckBox) findViewById(R.id.hotel_grasp_box4);
        grspBox5 = (CheckBox) findViewById(R.id.hotel_grasp_box5);

        grspStart = (Button) findViewById(R.id.hotel_grasp_start);
        grspExit = (Button) findViewById(R.id.hotel_grasp_exit);

        minPrice = (EditText) findViewById(R.id.grasp_min_price);
        maxPrice = (EditText) findViewById(R.id.grasp_max_price);

        /*grspStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    Toast.makeText(getApplicationContext(), "최소 1가지의 항목을 선택해야 합니다..",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), HotelTutorial.class);
                    startActivity(intent);
                    finish();
                }
            }
        });*/

        grspExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    class GraspTask extends AsyncTask<String, Void, String> {

        String sendMsg, receiveMsg;

        @Override
        protected String doInBackground(String... strings) {
            try {
                String str;
                URL url = new URL("http://222.116.135.77:8080/NCCC_H/insertuser.jsp");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestMethod("POST");

                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());

                sendMsg = "userid="+strings[0]+"&score1="+score1+"&score2="+score2+"&score3="+score3+"&score4="+score4+"&score5="+score5+"&min="+min+"&max="+max;
                osw.write(sendMsg);
                osw.flush();

                if(conn.getResponseCode() == conn.HTTP_OK) {
                    InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    BufferedReader reader = new BufferedReader(tmp);
                    StringBuffer buffer = new StringBuffer();

                    while ((str = reader.readLine()) != null) {
                        buffer.append((str));
                    }
                    receiveMsg = buffer.toString();

                } else {
                    Log.i("통신 결과", conn.getResponseCode()+"에러");
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  receiveMsg;
        }
    }
}
