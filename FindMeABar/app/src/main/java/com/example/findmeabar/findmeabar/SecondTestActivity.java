package com.example.findmeabar.findmeabar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondTestActivity extends AppCompatActivity {
    TextView tvName;
    TextView tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_test);

        Intent in = getIntent();

        Restaurant res = (Restaurant) getIntent().getSerializableExtra("restaurantRes");

        tvName = (TextView) findViewById(R.id.res1);
        tvName.setText(res.getName().toString());

        tvDesc = (TextView) findViewById(R.id.res2);
        tvDesc.setText(res.getDescription().toString());

    }
}
