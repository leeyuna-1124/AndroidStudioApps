package org.baewha.studymath;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FruitItemView extends LinearLayout {
    TextView fruitTextView;
    TextView priceTextView;
    ImageView imgView;
    public FruitItemView(Context context) {
        super(context);
        inflation_init(context);

        fruitTextView = findViewById(R.id.fruitTextView);
        priceTextView = findViewById(R.id.priceTextView);
        imgView = findViewById(R.id.imageView);
    }
    private void inflation_init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.fruit_item, this, true);
    }
    public void setFruit(String fruit){
        fruitTextView.setText(fruit);
    }
    public void setPrice(String price){
        priceTextView.setText(price);
    }

    public ImageView getImgView() {
        return imgView;
    }
}
