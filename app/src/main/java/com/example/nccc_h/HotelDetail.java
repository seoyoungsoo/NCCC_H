package com.example.nccc_h;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
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

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_detail);

        this.setFirst();
        this.evalHotel();
        this.setBack();

    }

    public void evalHotel() {
        htlEval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (evalCont) {
                    Toast.makeText(getApplicationContext(), "이미 평가한 호텔입니다.", Toast.LENGTH_SHORT).show();
                } else {

                    setEvaluation();
                    setEval();

                    htlEval_Eval.setOnClickListener(new View.OnClickListener() { //평가하기 버튼
                        @Override
                        public void onClick(View v) {
                            evalCont = true;

                            //Asynctask 연동

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

    public void setEval() {
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

}
