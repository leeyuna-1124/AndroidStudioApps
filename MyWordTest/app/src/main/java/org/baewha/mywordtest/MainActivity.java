package org.baewha.myword;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Add extends AppCompatActivity {
    WordClass wordClass=new WordClass();
    EditText word;
    EditText mean;
    Button addWord;
    private DatabaseReference mDatabase;
    TextView wordVeiw;
    TextView meanView;
    LinearLayout container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addword);

        word = (EditText) findViewById(R.id.word);
        mean = (EditText) findViewById(R.id.mean);
        addWord = (Button) findViewById(R.id.addword);
        wordVeiw=(TextView)findViewById(R.id.wordView);
        meanView=(TextView)findViewById(R.id.meanView);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        container=(LinearLayout)findViewById(R.id.wordListCotainer);

        mDatabase.child("wordbook").child("wordlist").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    words(dataSnapshot1.getKey(),dataSnapshot1.getValue(String.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        addWord.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!word.getText().equals(null) && !mean.getText().equals(null)) {
                    //wordClass.words.put(word.getText().toString(),mean.getText().toString());

                    mDatabase.child("wordbook").child("wordlist").child(word.getText().toString()).setValue(mean.getText().toString());
                    // .setValue(mean.toString());

                    wordVeiw.setText(mDatabase.child("wordlist").child(word.getText().toString()).getKey());

                    mDatabase.child("wordbook").child("wordlist").child(word.getText().toString()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            meanView.setText(dataSnapshot.getValue(String.class));

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    word.setText(""); mean.setText("");

                }
            }
        });

    }
    public void words(String english, String means){
        LinearLayout linear =new LinearLayout(this);
        TextView view1=new TextView(this);
        TextView view2 =new TextView(this);
        view1.setText(english);
        view2.setText(means);
        view1.setTextSize(48);
        view2.setTextSize(48);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linear.setOrientation(LinearLayout.HORIZONTAL);
        linear.setLayoutParams(lp);
        view1.setLayoutParams(lp);
        view2.setLayoutParams(lp);

        linear.addView(view1);
        linear.addView(view2);
        container.addView(linear);
    }

}


