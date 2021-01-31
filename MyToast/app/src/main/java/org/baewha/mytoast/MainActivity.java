package org.baewha.mytoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("토스트 연습");
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(MainActivity.this, "토스트 연습", Toast.LENGTH_LONG);
               Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                int xoffset=((int)Math.random()*display.getWidth()); //랜덤으로 x, y위치가 바뀜
                int yoffset=((int)Math.random()*display.getHeight());
                toast.setGravity(Gravity.BOTTOM|Gravity.RIGHT, xoffset, yoffset);//위치 지정
                toast.show();
            }
        });
    }
}