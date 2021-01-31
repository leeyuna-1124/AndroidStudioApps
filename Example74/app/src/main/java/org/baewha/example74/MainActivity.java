package org.baewha.example74;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView ImgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImgPet = findViewById(R.id.ImgPet);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, R.drawable.dog, 0, "강아지");
        menu.add(0, R.drawable.cat, 0, "고양이");
        menu.add(0, R.drawable.rabbit, 0, "토끼");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.drawable.dog:
                ImgPet.setImageResource(R.drawable.dog);
                break;
            case R.drawable.cat:
                ImgPet.setImageResource(R.drawable.cat);
                break;
            case R.drawable.rabbit:
                ImgPet.setImageResource(R.drawable.rabbit);
                break;
        }
                return super.onOptionsItemSelected(item);
        }


    }
