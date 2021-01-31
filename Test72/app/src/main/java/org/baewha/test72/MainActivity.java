package org.baewha.test72;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout baseLayout;
    Button btn, btn2;

    @Override
    public void registerForContextMenu(View view) {
        super.registerForContextMenu(view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseLayout = findViewById(R.id.baseLayout);
        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);
        registerForContextMenu(btn);
        registerForContextMenu(btn2);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo); //각 위젯에 해당하는 메뉴 인플레이트
        MenuInflater aaa = getMenuInflater();
        if(v==btn){
            menu.setHeaderTitle("배경색 변경");
            aaa.inflate(R.menu.menu1, menu);
        }
        if(v==btn2) {
            menu.setHeaderTitle("버튼 변경");
            aaa.inflate(R.menu.menu2, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);

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
                btn2.setRotation((float) 45.0);
                return true;

            case R.id.subSize:
                btn2.setScaleX(2);//X축으로 두배
                return true;
        }
        return false; //작업이 잘못 되었을 경우

    }
}