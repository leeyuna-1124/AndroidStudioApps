package org.baewha.test10_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Result extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표결과");

        Intent intent = getIntent(); //intent를 가져옴
        int[] vote = intent.getIntArrayExtra("vote");//intent의 정수배열을 가져옴
        String[] str = intent.getStringArrayExtra("pictureName");//intent의 문자열 배열을 가져옴

        TextView tv[] = new TextView[str.length];
        RatingBar rb[] = new RatingBar[str.length];

        int tvid[] = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};
        int rbid[] = {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9};

        for(int i=0; i<vote.length; i++){
            tv[i] = findViewById(tvid[i]);
            rb[i] = findViewById(rbid[i]);
        }
        for(int i=0; i<vote.length; i++){
            tv[i].setText(str[i]);
            rb[i].setRating((float)vote[i]); //가져온 결과를 뿌려줌
        }
        Button btn = findViewById(R.id.btnReturn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //버튼을 누르면 종료
            }
        });
    }
}
