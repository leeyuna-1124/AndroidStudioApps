package org.baewha.exam4_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView Text1, Text2;
    Switch SwAgree;
    RadioGroup Rgroup1;
    RadioButton oreo,pie,q10;
    ImageView ImgAndroid;
    Button btnQuit, btnRerun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");

        Text1=findViewById(R.id.Text1);
        Text2=findViewById(R.id.Text2);
        SwAgree=findViewById(R.id.SwAgree);
        Rgroup1=findViewById(R.id.Rgroup1);
        oreo=(RadioButton)findViewById(R.id.oreo);
        pie=(RadioButton)findViewById(R.id.pie);
        q10=(RadioButton)findViewById(R.id.q10);
        ImgAndroid=findViewById(R.id.ImgAndroid);
        btnQuit=findViewById(R.id.BtnQuit);
        btnRerun = findViewById(R.id.BtnRerun);


        SwAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (SwAgree.isChecked() == true) {
                    Text2.setVisibility(View.VISIBLE);
                    Rgroup1.setVisibility(View.VISIBLE);
                    ImgAndroid.setVisibility(View.VISIBLE);
                    btnQuit.setVisibility(android.view.View.VISIBLE);
                    btnRerun.setVisibility(android.view.View.VISIBLE);
                } else {
                    Text2.setVisibility(View.INVISIBLE);
                    Rgroup1.setVisibility(View.INVISIBLE);
                    ImgAndroid.setVisibility(View.INVISIBLE);
                    btnQuit.setVisibility(android.view.View.INVISIBLE);
                    btnRerun.setVisibility(android.view.View.INVISIBLE);

                }



                oreo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ImgAndroid.setImageResource(R.drawable.oreo);
                    }
                });
                pie.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ImgAndroid.setImageResource(R.drawable.pie);
                    }
                });
                q10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ImgAndroid.setImageResource(R.drawable.q10);
                    }
                });

                // 종료 버튼을 클릭하면
                btnQuit.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        finish();
                    }
                });

                // 처음으로 버튼을 클릭하면
                btnRerun.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Text2.setVisibility(android.view.View.INVISIBLE);
                        Rgroup1.setVisibility(android.view.View.INVISIBLE);
                        ImgAndroid.setVisibility(android.view.View.INVISIBLE);
                        btnQuit.setVisibility(android.view.View.INVISIBLE);
                        btnRerun.setVisibility(android.view.View.INVISIBLE);

                        Rgroup1.clearCheck();
                        SwAgree.setChecked(false);

                    }
                });

                        }

                });

            }
        }
