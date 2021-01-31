package org.baewha.test103;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티");

        final EditText edtNum1 = (EditText) findViewById(R.id.editNum1);
        final EditText edtNum2 = (EditText) findViewById(R.id.editNum2);
        final RadioGroup rdoGroup = (RadioGroup) findViewById(R.id.rdoGroup);

        Button btnActivity = (Button) findViewById(R.id.btnNewActivity);
        btnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                switch (rdoGroup.getCheckedRadioButtonId()) {
                    case R.id.rdoAdd:
                        intent.putExtra("Calc", "+");
                        break;
                    case R.id.rdoSub:
                        intent.putExtra("Calc", "-");
                        break;
                    case R.id.rdoMul:
                        intent.putExtra("Calc", "*");
                        break;
                    case R.id.rdoDiv:
                        intent.putExtra("Calc", "/");
                        break;
                }
                intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));

                startActivityForResult(intent, 0);

            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            int hap = data.getIntExtra("Hap", 0);
            Toast.makeText(getApplicationContext(), "결과 :" + hap,
                    Toast.LENGTH_SHORT).show();
        }
    }
}