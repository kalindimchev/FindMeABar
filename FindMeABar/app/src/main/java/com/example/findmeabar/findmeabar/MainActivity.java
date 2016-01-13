package com.example.findmeabar.findmeabar;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.findmeabar.findmeabar.MenuFragments.DrinksFragment;
import com.example.findmeabar.findmeabar.MenuFragments.FoodsFragment;
import com.example.findmeabar.findmeabar.MenuFragments.SaladsFragment;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu );

//        actionBar = getActionBar();
//        actionBar.setNavigationMode(actionBar.NAVIGATION_MODE_TABS);
//
//        ActionBar.Tab saladsTab = actionBar.newTab();
//        saladsTab.setText(R.string.salads);
//        saladsTab.setTabListener((ActionBar.TabListener) this);
//
//        ActionBar.Tab foodsTab = actionBar.newTab();
//        foodsTab.setText(R.string.foods);
//        foodsTab.setTabListener((ActionBar.TabListener) this);
//
//        ActionBar.Tab drinksTab = actionBar.newTab();
//        drinksTab.setText(R.string.drinks);
//        drinksTab.setTabListener((ActionBar.TabListener) this);
//
//        actionBar.addTab(saladsTab);
//        actionBar.addTab(foodsTab);
//        actionBar.addTab(drinksTab);


        viewPager = (ViewPager) findViewById(R.id.vp_menu);
        CustomViewPagerAdapter adapter = new CustomViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }


    public static class CustomViewPagerAdapter extends FragmentPagerAdapter {

        public CustomViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new SaladsFragment();
                case 1:
                    return new FoodsFragment();
                case 2:
                    return new DrinksFragment();
                default:
                    return null;
            }
        }


    }
}
