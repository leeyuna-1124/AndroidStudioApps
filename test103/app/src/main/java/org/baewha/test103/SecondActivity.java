package org.baewha.test103;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.baewha.test103.MainActivity;
import org.baewha.test103.R;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("Second 액티비티");

        Intent intent = getIntent();

        String calc = (intent.getStringExtra("Calc"));

        int calvalue = 0;
        if (calc.equals("+")) {
            calvalue = intent.getIntExtra("Num1", 0) +
                    intent.getIntExtra("Num2", 0);
        } else if (calc.equals("-")) {
            calvalue = intent.getIntExtra("Num1", 0) -
                    intent.getIntExtra("Num2", 0);
        } else if (calc.equals("*")) {
            calvalue = intent.getIntExtra("Num1", 0) *
                    intent.getIntExtra("Num2", 0);
        } else if (calc.equals("/")) {
            calvalue = intent.getIntExtra("Num1", 0) /
                    intent.getIntExtra("Num2", 0);
        }
        final int retValue = calvalue;

        Button btnReturn = (Button)findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outintent = new Intent(getApplicationContext(), MainActivity.class);
                outintent.putExtra("Hap", retValue);
                setResult(RESULT_OK, outintent);
                finish();
            }
        });
    }
}
