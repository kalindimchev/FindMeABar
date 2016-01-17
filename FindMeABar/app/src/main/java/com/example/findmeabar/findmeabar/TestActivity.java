package com.example.findmeabar.findmeabar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TestActivity extends AppCompatActivity {
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        b = (Button) findViewById(R.id.btn_test);
    }


//    @Override
//    public void onClick(View v) {
//
//    }

    public void BtnClick(View view) {
        Intent intent = new Intent(this, SecondTestActivity.class);
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Pri Bai Hui");
        restaurant.setDescription("Golema kruchma, Golemo neshto");
        intent.putExtra("restaurantRes", restaurant);

        startActivity(intent);
    }
}
