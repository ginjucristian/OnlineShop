package com.example.onlineshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "ON CREATE");
        setContentView(R.layout.activity_main);

        List<Food> foodList = new ArrayList<>();
        foodList.add(new Food("Burger", "Burger cu pui si vita, de la vivo", 10.0f, new Date()));
        foodList.add(new Food("Pizzza", "Pizza cu pui si vita, de la vivo", 10.0f, new Date()));
        foodList.add(new Food("Lapte", "Lapte cu cu cereale tot de la vivo", 10.0f, new Date()));
        foodList.add(new Food("Burger", "Burger cu pui si vita, de la vivo", 10.0f, new Date()));
        foodList.add(new Food("Burger", "Burger cu pui si vita, de la vivo", 10.0f, new Date()));
        foodList.add(new Food("Burger", "Burger cu pui si vita, de la vivo", 10.0f, new Date()));

        FoodListAdapter foodListAdapter = new FoodListAdapter(this, R.layout.food_item_layout, foodList);



        ((ListView)findViewById(R.id.food_list)).setAdapter(foodListAdapter);
        ((ListView)findViewById(R.id.food_list)).setOnItemClickListener(new FoodItemClickListner(foodListAdapter));

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "ON START");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "ON RESUME");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "ON PAUSE");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "ON STOP");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "ON DESTROY");
    }

    public void openFoodDescription(Food food) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

        Bundle b = new Bundle();
        b.putString("food_name", food.getName());
        b.putString("food_description", food.getDescription());
        b.putFloat("food_price", food.getPrice());
        b.putString("food_date", sdf.format(food.getExpirationDate()));

        Intent openFoodDescriptionIntent= new Intent(getApplicationContext(), FoodDescriptionActivity.class);
        openFoodDescriptionIntent.putExtra("food_bundle", b);

        startActivity(openFoodDescriptionIntent);

    }

    public class FoodItemClickListner implements AdapterView.OnItemClickListener {


        private final FoodListAdapter foodListAdapter;

        public FoodItemClickListner (FoodListAdapter foodListAdapter) {

            this.foodListAdapter = foodListAdapter;
        }


        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            openFoodDescription(this.foodListAdapter.getItem(position));

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return true;
    }
}