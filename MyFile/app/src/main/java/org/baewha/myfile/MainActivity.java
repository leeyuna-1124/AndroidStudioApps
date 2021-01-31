package org.baewha.myfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.content.Context.MODE_PRIVATE;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    FileOutputStream aaa = openFileOutput("File.txt", MODE_PRIVATE);
                    String str = "연습이야 걱정마";
                    aaa.write(str.getBytes());
                    aaa.close();
                    Toast.makeText(getApplicationContext(), "File.txt 가 생성됨", Toast.LENGTH_SHORT).show();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    FileInputStream aaa = openFileInput("file.txt");
                    byte[] txt = new byte[30];
                    aaa.read(txt);
                    String str = new String(txt);
                    aaa.close();
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });

    }
}