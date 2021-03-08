package com.example.onlineshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FoodDescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_food_description);
        Bundle b = getIntent().getBundleExtra("food_bundle");
        ((TextView)findViewById(R.id.description_food_name)).setText(b.getString("food_name"));
        ((TextView)findViewById(R.id.description_food_info)).setText(b.getString("food_description"));
        ((TextView)findViewById(R.id.description_food_price)).setText(String.valueOf(b.getFloat("food_price")));
        ((TextView)findViewById(R.id.description_food_expiration_date)).setText(b.getString("food_date"));
    }


}