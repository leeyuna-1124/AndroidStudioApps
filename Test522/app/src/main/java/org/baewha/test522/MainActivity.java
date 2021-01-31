package org.baewha.test522;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Edit1, Edit2;
    Button BtnAdd, BtnSub, BtnMul, BtnDiv;
    TextView TextResult;  //7개의 위젯에 관계되는 변수를 선언한다.
    String num1, num2;  //에디트텍스트에 입력한 문자열값을 저장할 변수이다.
    Integer result;       //두 문자열을 계산한 결과를 저장할 변수이다.
    Button[] numButtons = new Button[10];  //숫자 버튼 10개를 저장할 배열을 선언한다.
    Integer[] numBtnIds = {R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4,
            R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9 };
               //숫자 버튼 10개의 id를 배열에 저장한다. R.id.아이디 값은 정수이다.
    int i;  //for문에서 증가값으로 사용할 변수를 선언한다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("테이블 레이아웃 계산기");

        Edit1 = findViewById(R.id.Edit1);
        Edit2 = findViewById(R.id.Edit2);

        BtnAdd = findViewById(R.id.BtnAdd);
        BtnSub = findViewById(R.id.BtnSub);
        BtnMul = findViewById(R.id.BtnMul);
        BtnDiv = findViewById(R.id.BtnDiv);
        TextResult = findViewById(R.id.TextResult);

        for (int i = 0; i <= 9; i++) {
            numButtons[i] = findViewById(numBtnIds[i]);
        } //숫자id를 배열에 저장한다.

        for (i = 0; i < numBtnIds.length; i++) { //각 숫자버튼에 대해 10번 반복하면서 작업한다. (저장한 id고정시킴)
            final int index;
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() { //이너클래스
                @Override
                public void onClick(View view) {
                    if (Edit1.isFocused() == true) {
                        num1 = Edit1.getText().toString() + numButtons[index].getText().toString();
                        //숫자 버튼을 클릭했을 때 포커스가 되어있는 에디트텍스트에 글자를 추가한다.
                        Edit1.setText(num1); //텍스트를 보여줌
                    } else if (Edit2.isFocused() == true) {
                        num2 = Edit2.getText().toString() + numButtons[index].getText().toString();
                        Edit2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(), "먼저 에디트 텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                    }

                }
            });


            BtnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    num1 = Edit1.getText().toString();
                    num2 = Edit2.getText().toString();
                    result = Integer.parseInt(num1) + Integer.parseInt(num2);
                    TextResult.setText("연산 결과 : " + result.toString());

                }
            });
            BtnSub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    num1 = Edit1.getText().toString();
                    num2 = Edit2.getText().toString();
                    result = Integer.parseInt(num1) - Integer.parseInt(num2);
                    TextResult.setText("연산 결과 : " + result.toString());

                }
            });


            BtnMul.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    num1 = Edit1.getText().toString();
                    num2 = Edit2.getText().toString();
                    result = Integer.parseInt(num1) * Integer.parseInt(num2);
                    TextResult.setText("연산 결과 : " + result.toString());

                }
            });
            BtnDiv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    num1 = Edit1.getText().toString();
                    num2 = Edit2.getText().toString();
                    result = Integer.parseInt(num1) / Integer.parseInt(num2);
                    TextResult.setText("연산 결과 : " + result.toString());

                }


            });
        }
    }}