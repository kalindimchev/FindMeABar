package com.example.findmeabar.findmeabar;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class FoodAdapter extends ArrayAdapter<Food> {
    private Context context;
    private int layoutId;
    private List<Food> foods;

    public FoodAdapter(Context context, int textViewResourceId, List<Food> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        layoutId = textViewResourceId;
        foods = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(layoutId, parent);

//        TextView tvName = (TextView) row.findViewById(R.id.tv_food_name);
//        tvName.setText(foods.get(position).getName());

//        TextView tvPrice = (TextView) row.findViewById(R.id.tv_food_price);
//        tvPrice.setText(foods.get(position).getPrice());

        return row;
    }


}
