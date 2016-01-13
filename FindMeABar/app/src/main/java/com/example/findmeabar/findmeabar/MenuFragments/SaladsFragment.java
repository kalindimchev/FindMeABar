package com.example.findmeabar.findmeabar.MenuFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.findmeabar.findmeabar.R;

import java.util.List;

public class SaladsFragment extends Fragment {

    ListView listView;
    String[] data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu_salads, container, false);

        listView = (ListView) rootView.findViewById(R.id.lv_menu_item);

        data = getResources().getStringArray(R.array.data);

        ArrayAdapter<String> adap = new ArrayAdapter<String>(this.getActivity(), R.layout.layout_single_menu_item, R.id.tv_food_name, data);

        listView.setAdapter(adap);
        return rootView;
    }
}
