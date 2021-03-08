package com.example.onlineshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FoodListAdapter extends ArrayAdapter<Food> {

    private final List<Food> foodList;
    private final Context context;

    public FoodListAdapter(@NonNull Context context, int resource, List<Food> foodList) {
        super(context, resource);
        this.foodList = foodList;
        this.context = context;
    }

    @Nullable
    @Override
    public Food getItem(int position) {
        return foodList.get(position);
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.food_item_layout, parent, false);
        }

        Food currentFood = foodList.get(position);

        ((TextView)convertView.findViewById(R.id.food_name)).setText(currentFood.getName());
        ((TextView)convertView.findViewById(R.id.food_price)).setText(String.valueOf(currentFood.getPrice()));
        ((TextView)convertView.findViewById(R.id.food_description)).setText(currentFood.getDescription());

        return convertView;
    }
}
