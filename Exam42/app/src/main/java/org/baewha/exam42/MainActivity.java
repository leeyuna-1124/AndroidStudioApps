package org.baewha.exam42;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView Text1, Text2;
    CheckBox ChkAgree;
    RadioGroup Rgroup1;
    RadioButton Dog, Cat, Rabbit;
    Button BtnOK;
    ImageView ImgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");

        Text1=findViewById(R.id.Text1);
        Text2=findViewById(R.id.Text2);
        ChkAgree=findViewById(R.id.ChkAgree);
        Rgroup1=findViewById(R.id.Rgroup1);
        Dog=findViewById(R.id.Dog);
        Cat=findViewById(R.id.Cat);
        Rabbit=findViewById(R.id.Rabbit);
        BtnOK=findViewById(R.id.BtnOK);
        ImgPet=findViewById(R.id.ImgPet);

        ChkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(ChkAgree.isChecked()==true){
                    Text2.setVisibility(View.VISIBLE);
                    Rgroup1.setVisibility(View.VISIBLE);
                    BtnOK.setVisibility(View.VISIBLE);
                    ImgPet.setVisibility(View.VISIBLE);
                }
                else{
                    Text2.setVisibility(View.INVISIBLE);
                    Rgroup1.setVisibility(View.INVISIBLE);
                    BtnOK.setVisibility(View.INVISIBLE);
                    ImgPet.setVisibility(View.INVISIBLE);

                }
            }
        });

        BtnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (Rgroup1.getCheckedRadioButtonId()){
                    case R.id.Dog: ImgPet.setImageResource(R.drawable.dog);
                    break;

                    case R.id.Cat: ImgPet.setImageResource(R.drawable.cat);
                        break;

                    case R.id.Rabbit: ImgPet.setImageResource(R.drawable.rabbit);
                        break;

                    default:
                        Toast.makeText(getApplicationContext(), "동물을 먼저 선택하세요.",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}