package com.example.findmeabar.findmeabar;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.findmeabar.findmeabar.MenuFragments.DrinksFragment;
import com.example.findmeabar.findmeabar.MenuFragments.FoodsFragment;
import com.example.findmeabar.findmeabar.MenuFragments.SaladsFragment;
import com.telerik.everlive.sdk.core.EverliveApp;
import com.telerik.everlive.sdk.core.EverliveAppSettings;
import com.telerik.everlive.sdk.core.result.RequestResult;
import com.telerik.everlive.sdk.core.result.RequestResultCallbackAction;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EverliveApp myApp;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent in = new Intent(this, SingleRestaurantActivity.class);
        //startActivity(in);

    }




//    private void getAllEntries() {
//        myApp.workWith().data(Food.class).getAll().executeAsync(new RequestResultCallbackAction<ArrayList<Food>>() {
//            @Override
//            public void invoke(RequestResult<ArrayList<Food>> requestResult) {
//                if (requestResult.getSuccess()) {
//                    for (Food f : requestResult.getValue()) {
//                        if (f.getName().equals("Pishi")) {
//                            System.out.println("Ima go Peshoooo");
//                            return;
//                        }
//                        System.out.println("Blaaaaaa: " + f.getName() + " *** " + f.getPrice());
//
//                    }
//                } else {
//                    System.out.println("EEEEError: " + requestResult.getError().toString());
//                }
//            }
//        });
//    }

    public void onBtnClick(View view) {
        Button b;
        switch (view.getId()) {
            case R.id.btn_all:
                Toast.makeText(this, "All button clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_top:
                Toast.makeText(this, "Top button clicked", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(this, SingleRestaurantActivity.class);
                startActivity(in);
                break;
            case R.id.btn_nearest:
                Toast.makeText(this, "Nearest button clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_popular:
                Toast.makeText(this, "Popular button clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_login:
                Toast.makeText(this, "Login button clicked", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "OTHER BUTTON CLICKED!", Toast.LENGTH_SHORT).show();
        }
    }

}
