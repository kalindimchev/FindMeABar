package com.example.findmeabar.findmeabar.MenuFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.findmeabar.findmeabar.R;

public class FoodsFragment extends Fragment {
    ListView listView;
    String[] data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu_foods, container, false);

        listView = (ListView) rootView.findViewById(R.id.lv_foods);

        data = getResources().getStringArray(R.array.data);

        ArrayAdapter<String> adap = new ArrayAdapter<String>(this.getActivity(), R.layout.layout_single_menu_item, R.id.tv_food_name, data);

        listView.setAdapter(adap);
        return rootView;
    }
}
