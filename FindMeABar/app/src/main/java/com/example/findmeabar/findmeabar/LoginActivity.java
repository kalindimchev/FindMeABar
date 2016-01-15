package com.example.findmeabar.findmeabar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
    }

    public void onButtonClick(View v) {
        if (v.getId() == R.id.b_login_btn){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }

        if(v.getId() == R.id.b_signin_btn){
            Intent i = new Intent(this, Signup.class);
            startActivity(i);
        }
    }
}
