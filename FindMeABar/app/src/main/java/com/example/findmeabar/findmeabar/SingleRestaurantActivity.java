package com.example.findmeabar.findmeabar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SingleRestaurantActivity extends AppCompatActivity {

    private static Button alert_btn;

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
                Toast.makeText(this, "MENU button clicked!", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(this, MenuActivity.class);
                startActivity(in);
                break;
            case R.id.btn_reserve:
                Toast.makeText(this, "RESERVE button clicked!", Toast.LENGTH_SHORT).show();
                onReserveClick();
                break;
            default:
                Toast.makeText(this, "OTHER BUTTON CLICKED!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onReserveClick() {
        alert_btn = (Button) findViewById(R.id.btn_reserve);
        alert_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(SingleRestaurantActivity.this, AlertDialog.THEME_HOLO_DARK);
                        a_builder.setMessage("Резервирате маса?");
                        a_builder.setCancelable(false);
                        a_builder
                                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(SingleRestaurantActivity.this, "Резервацията е приета", Toast.LENGTH_LONG).show();
                                        dialog.cancel();
                                    }
                                })
                                .setNegativeButton("Не", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(SingleRestaurantActivity.this, "Резервацията е отказана", Toast.LENGTH_LONG).show();
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Резервация на маса:");
                        alert.show();
                    }
                }
        );
    }
}
