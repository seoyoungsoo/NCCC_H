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

    Button grspStart;
    Button grspExit;

    //시크바 추가

    GraspTask graspTask;

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_grasp);

        final String userID = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);

        this.setFirst();
        this.setBoxClickListener();

        grspStart.setOnClickListener(new View.OnClickListener(){
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
                try {
                    String result;
                    graspTask = new GraspTask();
                    result = graspTask.execute(userID).get();
                    Log.i("리턴 값", result);
                } catch (Exception e) {
                }
            }
        });


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
                    }
                } else if (grspBox1.isChecked() == false) {
                    i--;
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
                    }
                } else if (grspBox2.isChecked() == false) {
                    i--;
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
                    }
                } else if (grspBox3.isChecked() == false) {
                    i--;
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
                    }
                } else if (grspBox4.isChecked() == false) {
                    i--;
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
                    }
                } else if (grspBox5.isChecked() == false) {
                    i--;
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
                URL url = new URL("");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "apllication/x-www-form-urlencoded");
                conn.setRequestMethod("POST");

                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());

                sendMsg = "userid="+strings[0];
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
