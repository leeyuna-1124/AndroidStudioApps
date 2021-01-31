package org.baewha.test71;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout baseLayout;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기");
        baseLayout = findViewById(R.id.baseLayout);
        btn = findViewById(R.id.btn);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater aaa = getMenuInflater();//메뉴를 보여준다
        aaa.inflate(R.menu.menu1, menu); //xml위치 연결
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {//선택된 항목
       switch (item.getItemId()){
           case R.id.itemRed:
              baseLayout.setBackgroundColor(Color.RED);
              return  true;
           case R.id.itemGreen:
               baseLayout.setBackgroundColor(Color.GREEN);
               return  true;
           case R.id.itemBlue:
               baseLayout.setBackgroundColor(Color.BLUE);
               return  true;
          //서브항목들
           case R.id.subRotate:
               btn.setRotation((float) 45.0);
               return true;

           case R.id.subSize:
               btn.setScaleX(2);//X축으로 두배
               return true;
       }
       return false; //작업이 잘못 되었을 경우
    }
}