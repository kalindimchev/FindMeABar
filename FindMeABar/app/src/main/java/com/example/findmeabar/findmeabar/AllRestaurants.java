package com.example.findmeabar.findmeabar;

import android.app.ListActivity;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.telerik.everlive.sdk.core.EverliveApp;
import com.telerik.everlive.sdk.core.EverliveAppSettings;
import com.telerik.everlive.sdk.core.result.RequestResult;
import com.telerik.everlive.sdk.core.result.RequestResultCallbackAction;

import java.util.ArrayList;
import java.util.List;

public class AllRestaurants extends AppCompatActivity {
    ListView listView;
    String[] data;
    List<Bar> bars;
    EverliveApp myApp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_restaurants);

        listView = (ListView) findViewById(R.id.lv_all_restaurants);

        initializeSdk();
        bars = new ArrayList<Bar>();
        getAllEntries();

        BarAdapter adapter = new BarAdapter(this, R.layout.layout_list_bars, bars);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        listView.setAdapter(adapter);
    }

    private void initializeSdk() {
        String appId = "ce9fho1ly52u25nl";
        EverliveAppSettings appSettings = new EverliveAppSettings();
        appSettings.setAppId(appId);

        myApp = new EverliveApp(appSettings);
    }

    private void getAllEntries() {
        myApp.workWith().data(Bar.class).getAll().executeAsync(new RequestResultCallbackAction<ArrayList<Bar>>() {

            @Override
            public void invoke(RequestResult<ArrayList<Bar>> requestResult) {
                if (requestResult.getSuccess()) {
                    for (Bar f : requestResult.getValue()) {
                        bars.add(f);
                    }
                } else {
                    System.out.println("*****Error*****: " + requestResult.getError().toString());
                }
            }
        });
    }
}
