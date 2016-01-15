package com.example.findmeabar.findmeabar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.findmeabar.findmeabar.MenuFragments.DrinksFragment;
import com.example.findmeabar.findmeabar.MenuFragments.FoodsFragment;
import com.example.findmeabar.findmeabar.MenuFragments.SaladsFragment;
import com.telerik.everlive.sdk.core.EverliveApp;
import com.telerik.everlive.sdk.core.EverliveAppSettings;

public class MenuActivity extends AppCompatActivity {
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu);

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
