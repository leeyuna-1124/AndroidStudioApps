package org.baewha.ex75;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btn1;
View toastView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제 7-5");

        btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = new Toast(MainActivity.this);
                toastView = (View)view.inflate(MainActivity.this, R.layout.toast1, null);
                Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                toast.setGravity(Gravity.TOP|Gravity.LEFT,
                        (int)(Math.random()*display.getWidth()), (int)(Math.random()*display.getHeight()));
                toast.setView(toastView);
                toast.show();

            }
        });
    }
}