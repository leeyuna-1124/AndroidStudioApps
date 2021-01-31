package org.baewha.test10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnResult; //투표종료 버튼
    int vote[] = new int [9]; //투표결과 저장
    ImageView[] iv = new ImageView[9]; //위젯변수 저장
    int imageId[] = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9};
    //xml id
    String pictureName[] = {"독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀", "이레느깡 단 베르망",
    "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들", "해변에서"};
    //명화 제목 문자열배열 생성
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("명화 선호도 투표");

        for(int i=0; i<imageId.length; i++){ //위젯변수를 저장해서 투표결과로 배열에 넣음
            final int index;
            index = i;
            iv[index] = findViewById(imageId[index]);
            iv[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) { //명화 클릭 이벤트
                    vote[index]++; //투표수 증가
                    Toast.makeText(getApplicationContext(), pictureName[index]+"가"+vote[index]+"표 획득",
                            Toast.LENGTH_LONG).show();
                }
            });
        }
        btnResult = findViewById(R.id.btnResult); //투표종료 버튼
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Result.class);
                intent.putExtra("vote", vote); //투표결과에 대한 정보를 intent에 저장
                intent.putExtra("pictureName", pictureName);//투표한 명화의 제목을 저장
                startActivity(intent); //intent에 있는 정보를 저장해서 새로운 intent시작
            }
        });

    }
}