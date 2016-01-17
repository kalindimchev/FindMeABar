package com.example.findmeabar.findmeabar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ListView;

import com.telerik.everlive.sdk.core.EverliveApp;
import com.telerik.everlive.sdk.core.EverliveAppSettings;
import com.telerik.everlive.sdk.core.result.RequestResult;
import com.telerik.everlive.sdk.core.result.RequestResultCallbackAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kalin on 17.1.2016 г..
 */
public class PopularRestaurantsActiviy extends AppCompatActivity {
    ListView listView;
    String[] data;
    List<Bar> r;
    EverliveApp myApp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_restaurants);

        listView = (ListView) findViewById(R.id.lv_all_restaurants);

        initializeSdk();
        r = new ArrayList<Bar>();
        getAllEntries();

        BarAdapter adapter = new BarAdapter(this, R.layout.layout_list_bars, r);

        try {
            Thread.sleep(700);
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
                        r.add(f);
                    }
                } else {
                    System.out.println("*****Error*****: " + requestResult.getError().toString());
                }
            }
        });
    }
}
