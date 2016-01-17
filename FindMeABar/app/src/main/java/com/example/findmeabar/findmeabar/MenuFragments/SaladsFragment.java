package com.example.findmeabar.findmeabar.MenuFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.findmeabar.findmeabar.Food;
import com.example.findmeabar.findmeabar.FoodAdapter;
import com.example.findmeabar.findmeabar.R;
import com.example.findmeabar.findmeabar.Salad;
import com.example.findmeabar.findmeabar.SaladsAdapter;
import com.telerik.everlive.sdk.core.EverliveApp;
import com.telerik.everlive.sdk.core.EverliveAppSettings;
import com.telerik.everlive.sdk.core.result.RequestResult;
import com.telerik.everlive.sdk.core.result.RequestResultCallbackAction;

import java.util.ArrayList;
import java.util.List;

public class SaladsFragment extends Fragment {

    ListView listView;
    List<Salad> salads;
    EverliveApp myApp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu_salads, container, false);

        listView = (ListView) rootView.findViewById(R.id.lv_salads);

        initializeSdk();
        salads = new ArrayList<Salad>();
        getAllEntries();

        SaladsAdapter adapter = new SaladsAdapter(getContext(), R.layout.layout_single_menu_item, salads);

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
        myApp.workWith().data(Salad.class).getAll().executeAsync(new RequestResultCallbackAction<ArrayList<Salad>>() {

            @Override
            public void invoke(RequestResult<ArrayList<Salad>> requestResult) {
                if (requestResult.getSuccess()) {
                    for (Salad s : requestResult.getValue()) {
                        salads.add(s);
                    }
                } else {
                    System.out.println("*****Error*****: " + requestResult.getError().toString());
                }
            }
        });
    }
}
