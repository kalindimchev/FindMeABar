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
    private List<Bar> data;

    public BarAdapter(Context context, int resource, List<Bar> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutId = resource;
        this.data = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(layoutId, parent, false);

        TextView twName = (TextView) row.findViewById(R.id.tw_name);
        twName.setText(data.get(position).getName());
        TextView twAddress = (TextView) row.findViewById(R.id.tw_address);
        twName.setText(data.get(position).getAddress());
        TextView twPhone = (TextView) row.findViewById(R.id.tw_phone);
        twName.setText(data.get(position).getPhone());

        return row;
    }

}
