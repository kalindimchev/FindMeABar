package com.example.findmeabar.findmeabar;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class BarAdapter extends ArrayAdapter<Bar> {

    private Context context;
    private int layoutId;
    private List<Bar> bars;

    public BarAdapter(Context context, int textViewResourceId, List<Bar> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.layoutId = textViewResourceId;
        this.bars = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(layoutId, parent, false);

        TextView twName = (TextView) row.findViewById(R.id.tw_name);
        twName.setText(bars.get(position).getName());

        TextView twAddress = (TextView) row.findViewById(R.id.tw_address);
        twAddress.setText(bars.get(position).getAddress());

        TextView twPhone = (TextView) row.findViewById(R.id.tw_phone);
        twPhone.setText(bars.get(position).getPhone());

        TextView rating = (TextView) row.findViewById(R.id.rating);
        rating.setText(bars.get(position).getRating());

        return row;
    }

}
