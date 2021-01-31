package org.baewha.studymath;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    myAdapter adapter;
    String[] fruits = {"자몽", "천일향", "한라봉", "귤", "오렌지", "스위티"};
    String [] price = {"200", "300", "400", "300", "400", "300"};
    int Img[]  = {R.drawable.ban2, R.drawable.ban1, R.drawable.bab2,
    R.drawable.ggi1, R.drawable.ggi2, R.drawable.gan2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//상태바 없애기
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView2);
        adapter = new myAdapter();
        listView.setAdapter(adapter);
    }
    class myAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return fruits.length;
        }

        @Override
        public Object getItem(int position) {
            return fruits[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            FruitItemView view = new FruitItemView(getApplicationContext());
            view.setFruit(fruits[position]);
            view.setPrice(price[position]);

            ImageView imgView = new ImageView(getApplicationContext());
            imgView.setImageResource(Img[position]);

            return view;
        }
    }
}