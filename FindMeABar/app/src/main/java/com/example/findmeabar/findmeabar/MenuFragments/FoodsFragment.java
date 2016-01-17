package com.example.findmeabar.findmeabar.MenuFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.findmeabar.findmeabar.Drink;
import com.example.findmeabar.findmeabar.DrinksAdapter;
import com.example.findmeabar.findmeabar.Food;
import com.example.findmeabar.findmeabar.FoodAdapter;
import com.example.findmeabar.findmeabar.R;
import com.telerik.everlive.sdk.core.EverliveApp;
import com.telerik.everlive.sdk.core.EverliveAppSettings;
import com.telerik.everlive.sdk.core.result.RequestResult;
import com.telerik.everlive.sdk.core.result.RequestResultCallbackAction;

import java.util.ArrayList;
import java.util.List;

public class FoodsFragment extends Fragment {
    ListView listView;
    List<Food> foods;
    EverliveApp myApp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu_foods, container, false);

        listView = (ListView) rootView.findViewById(R.id.lv_foods);

        initializeSdk();
        foods = new ArrayList<Food>();
        getAllEntries();

        FoodAdapter adapter = new FoodAdapter(getContext(), R.layout.layout_single_menu_item, foods);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        listView.setAdapter(adapter);

        return rootView;
    }

    private void initializeSdk() {
        String appId = "ce9fho1ly52u25nl";
        EverliveAppSettings appSettings = new EverliveAppSettings();
        appSettings.setAppId(appId);

        myApp = new EverliveApp(appSettings);
    }

    private void getAllEntries() {
        myApp.workWith().data(Food.class).getAll().executeAsync(new RequestResultCallbackAction<ArrayList<Food>>() {

            @Override
            public void invoke(RequestResult<ArrayList<Food>> requestResult) {
                if (requestResult.getSuccess()) {
                    for (Food f : requestResult.getValue()) {
                        foods.add(f);
                    }
                } else {
                    System.out.println("*****Error*****: " + requestResult.getError().toString());
                }
            }
        });
    }
}
