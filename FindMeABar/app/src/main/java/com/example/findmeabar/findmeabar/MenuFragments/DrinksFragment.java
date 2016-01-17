package com.example.findmeabar.findmeabar.MenuFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class DrinksFragment extends Fragment {

    ListView listView;
    List<Drink> drinks;
    EverliveApp myApp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu_drinks, container, false);

        listView = (ListView) rootView.findViewById(R.id.lv_drinks);

        initializeSdk();
        drinks = new ArrayList<Drink>();
        getAllEntries();

        DrinksAdapter adapter = new DrinksAdapter(getContext(), R.layout.layout_single_menu_item, drinks);

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
        myApp.workWith().data(Drink.class).getAll().executeAsync(new RequestResultCallbackAction<ArrayList<Drink>>() {

            @Override
            public void invoke(RequestResult<ArrayList<Drink>> requestResult) {
                if (requestResult.getSuccess()) {
                    for (Drink d : requestResult.getValue()) {
                        drinks.add(d);
                    }
                } else {
                    System.out.println("*****Error*****: " + requestResult.getError().toString());
                }
            }
        });
    }
}
