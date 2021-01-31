package org.baewha.gamemain;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainViewActivity extends AppCompatActivity {

    TextView word;
    TextView mean;
    ImageButton wordListbtn;
    ImageButton quizBtn;
    private SQLiteOpenHelper mDatabase;// ...
    ImageButton etcBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quizBtn=(ImageButton)findViewById(R.id.quizBtn);
        word=(TextView)findViewById(R.id.word);
        mean=(TextView)findViewById(R.id.mean);
        mDatabase = SQLiteDatabase.getInstance().getReference();
        wordListbtn =(ImageButton)findViewById(R.id.bottom_list_btn);
        etcBtn =(ImageButton)findViewById(R.id.bottomBar_etc_btn);



        if(mDatabase.child("wordbook").child("wordlist").child("value").getKey().equals(null))
            mDatabase.child("wordbook").child("wordlist").child("value").setValue("가치");

        word.setText(mDatabase.child("wordbook").child("wordlist").child("value").getKey());

        wordListbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MyWordBookActivity.class));
            }
        });

        mDatabase.child("wordbook").child("wordlist").child("value").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mean.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        quizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShortQuizActivity.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);

            }
        });

    }
}
