package org.baewha.q7;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(//리니어 레이아웃을 생성하는 JAVA코드
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
                LinearLayout base = new LinearLayout(this);
                base.setOrientation(LinearLayout.VERTICAL);
                setContentView(base,params);

        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,1);
                LinearLayout base2 = new LinearLayout(this);
                base2.setLayoutParams(params2);
                base2.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams redparams = new LinearLayout.LayoutParams(//빨간색 레이아웃
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,1);
                LinearLayout red = new LinearLayout(this);
                red.setLayoutParams(redparams);
                red.setOrientation(LinearLayout.VERTICAL);
                red.setBackgroundColor(Color.RED);

        LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,1);
                LinearLayout base3 = new LinearLayout(this);
                base3.setLayoutParams(params3);
                base3.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams yellowparams = new LinearLayout.LayoutParams(//노란색 레이아웃
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,1);
                LinearLayout yellow = new LinearLayout(this);
                yellow.setLayoutParams(yellowparams);
                yellow.setBackgroundColor(Color.YELLOW);

        LinearLayout.LayoutParams blackparams = new LinearLayout.LayoutParams(//검정색 레이아웃
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,1);
                LinearLayout black = new LinearLayout(this);
                black.setLayoutParams(blackparams);
                black.setOrientation(LinearLayout.VERTICAL);
                black.setBackgroundColor(Color.BLACK);

        LinearLayout.LayoutParams blueparams = new LinearLayout.LayoutParams(//파란색 레이아웃
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,1);
                LinearLayout blue = new LinearLayout(this);
                blue.setLayoutParams(blueparams);
                blue.setOrientation(LinearLayout.VERTICAL);
                blue.setBackgroundColor(Color.BLUE);

                base3.addView(yellow);
                base3.addView(black);

                base2.addView(red);
                base2.addView(base3);

                base.addView(base2);
                base.addView(blue);

                setContentView(base);




    }
}