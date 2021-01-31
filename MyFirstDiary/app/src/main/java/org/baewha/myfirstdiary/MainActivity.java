package org.baewha.myfirstdiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityManagerCompat;
import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    EditText et1;
    Button btn1;
    String filename;
    private File file;
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("나만의 심플 일기장");
        dp = findViewById(R.id.dp);//이벤트가 발생하는곳
        et1 = findViewById(R.id.et1);
        btn1 = findViewById(R.id.btn1);

       // ActivityCompat.requestPermissions(this, new String[] {
       //         android.Manifest.permission.WRITE_EXTERNAL_STORAGE} ,MODE_PRIVATE);
       // ActivityCompat.requestPermissions(this, new String[] {
       //         android.Manifest.permission.READ_EXTERNAL_STORAGE} ,MODE_PRIVATE);

        path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/mydiary";
        file = new File(path);
        if(file.exists())
            file.mkdir(); //MyFirstDiary 폴더 만들기

        Calendar sss = Calendar.getInstance();//클래스 메서드로 캘린더 정보를 가져옴
        int cy = sss.get(Calendar.YEAR);
        int cm = sss.get(Calendar.MONTH);
        int cd = sss.get(Calendar.DAY_OF_MONTH);

        dp.init(cy, cm, cd, new DatePicker.OnDateChangedListener() { //초기화시키고, 정보가 있으면 실행
            @Override//바뀐 날짜를 기준으로 파일 이름을 만듦
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                filename = Integer.toString(i) + "_" + Integer.toString(i1 + 1) + "_" + Integer.toString(i2) + ".txt";
                String str = readDiary(filename);//filename의 일기를 문자열로 읽어옴
                et1.setText(str);//일기를 표시
                btn1.setEnabled(true);//일기를 수정할 수 있도록 한다.(버튼을 동작하도록)

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() { //파일을 저장함
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream outFs = new FileOutputStream(path+"/"+filename);
                    //FileOutputStream outFs = openFileOutput(filename, Context.MODE_PRIVATE);
                    //파일을 저장.  파일을 오픈해서 파일을 생성
                    String str = et1.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(),"파일이 저장되었습니다.",Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });
    }
        public String readDiary(String filename) {
            String diarystr = null;
            try {
                FileInputStream inFs = new FileInputStream(path+"/"+filename);
                //FileInputStream inFs = openFileInput(filename);
                byte[] txt = new byte[100];
                inFs.read(txt);//byte단위로 읽음
                inFs.close();
                String str = new String(txt);//String으로 변환
                diarystr = str.trim();//불필요한 공백 제거
                btn1.setText("수정하기");
            } catch (IOException e) {
                et1.setHint("일기 없음");
                btn1.setText("새로 저장");
            }
           return diarystr;

        }
}