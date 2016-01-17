package com.example.findmeabar.findmeabar;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class DrinksAdapter extends ArrayAdapter<Drink> {
    private Context context;
    private int layoutId;
    private List<Drink> drinks;

    public DrinksAdapter(Context context, int textViewResourceId, List<Drink> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        layoutId = textViewResourceId;
        drinks = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(layoutId, parent, false);

        TextView tvName = (TextView) row.findViewById(R.id.tv_food_name);
        tvName.setText(drinks.get(position).getName());

        TextView tvPrice = (TextView) row.findViewById(R.id.tv_food_price);
        tvPrice.setText(drinks.get(position).getPrice());

        return row;
    }


}
