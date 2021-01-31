package org.baewha.test519;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    ImageView v1, v2, v3;
    int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn); //멤버변수에 대입한다.
        v1 = findViewById(R.id.iv1);
        v2 = findViewById(R.id.iv2);
        v3 = findViewById(R.id.iv3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i==0){
                    v1.setVisibility(View.VISIBLE);
                    v2.setVisibility(View.INVISIBLE);
                    v3.setVisibility(View.INVISIBLE);
                    i++;
                }else if(i==1){
                    v1.setVisibility(View.INVISIBLE);
                    v2.setVisibility(View.VISIBLE);
                    v3.setVisibility(View.INVISIBLE);
                    i++;
                }else if(i==2){
                    v1.setVisibility(View.INVISIBLE);
                    v2.setVisibility(View.INVISIBLE);
                    v3.setVisibility(View.VISIBLE);
                    i=0;
                }
            }
        });
    }
}