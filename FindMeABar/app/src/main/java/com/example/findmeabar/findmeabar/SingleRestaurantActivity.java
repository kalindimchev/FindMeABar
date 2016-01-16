package com.example.findmeabar.findmeabar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SingleRestaurantActivity extends AppCompatActivity {
    Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_single_restaurant);
    }

    public void onBtnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_call:
                Toast.makeText(this, "CALL button clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_address:
                Toast.makeText(this, "ADDRESS button clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_menu:
                //Toast.makeText(this, "MENU button clicked!", Toast.LENGTH_SHORT).show();
                in = new Intent(this, MenuActivity.class);
                startActivity(in);
                break;
            case R.id.btn_reserve:
                Toast.makeText(this, "RESERVE button clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "OTHER BUTTON CLICKED!", Toast.LENGTH_SHORT).show();
        }
    }
}
