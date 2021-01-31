package org.baewha.list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView english;
    int count=0;
    Random r =new Random();
    Button answerBtn;
    EditText mean;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mean=(EditText)findViewById(R.id.answer);
        english =(TextView)findViewById(R.id.englishQuiz);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        answerBtn =(Button)findViewById(R.id.answerBtn);

        mDatabase.child("wordbook").child("wordlist").addValueEventListener(new ValueEventListener() {

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                count=r.nextInt(6);
                int i=0;
                for(DataSnapshot name : dataSnapshot.getChildren()){
                    if(i==count){
                        english.setText(name.getKey());
                    }
                    i++;
                }
            }
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        answerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.child("wordbook").child("wordlist").child(english.getText().toString()).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.getValue().equals(mean.getText().toString())){
                            startActivity(new Intent(getApplication(),Result.class));
                        }else{
                            startActivity(new Intent(getApplication(),Result.class));
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });



    }
}