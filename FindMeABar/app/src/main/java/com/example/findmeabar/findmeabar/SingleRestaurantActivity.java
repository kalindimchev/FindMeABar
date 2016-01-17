package com.example.findmeabar.findmeabar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SingleRestaurantActivity extends AppCompatActivity {
    Intent in;

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
//                in = new Intent(Intent.ACTION_CALL);
//                in.setData(Uri.parse("tel:00000"));
//                startActivity(in);
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
                //Toast.makeText(this, "RESERVE button clicked!", Toast.LENGTH_SHORT).show();
                ReserveTableAlert();
                break;
            default:
                Toast.makeText(this, "OTHER BUTTON CLICKED!", Toast.LENGTH_SHORT).show();
        }
    }

    private void ReserveTableAlert(){
        AlertDialog.Builder a_builder = new AlertDialog.Builder(SingleRestaurantActivity.this, AlertDialog.THEME_HOLO_DARK);
        a_builder.setMessage(R.string.alert_reserve_table_message);
        a_builder.setCancelable(false);
        a_builder
                .setPositiveButton(R.string.label_positive_btn, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(SingleRestaurantActivity.this, R.string.alert_reservation_confirmed, Toast.LENGTH_LONG).show();
                        dialog.cancel();
                    }
                })
                .setNegativeButton(R.string.label_negative_btn, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(SingleRestaurantActivity.this, R.string.alert_reservation_declined, Toast.LENGTH_LONG).show();
                        dialog.cancel();
                    }
                });

        AlertDialog alert = a_builder.create();
        alert.setTitle(getString(R.string.alert_reserve_table_title));
        alert.show();
    }
}
