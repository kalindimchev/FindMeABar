package com.example.findmeabar.findmeabar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_signup);
    }

    public void onSignupClick (View v)  {

        if(v.getId() == R.id.b_reg_signup_btn){

            EditText name = (EditText)findViewById(R.id.et_reg_name);
            EditText email = (EditText)findViewById(R.id.et_reg_email);
            EditText username = (EditText)findViewById(R.id.et_reg_username);
            EditText pass = (EditText)findViewById(R.id.et_reg_password);
            EditText passRepeat = (EditText)findViewById(R.id.et_reg_confirm_password);

            String nameStr = name.getText().toString();
            String emailStr = email.getText().toString();
            String usernameStr = username.getText().toString();
            String passStr = pass.getText().toString();
            String passRepeatStr = passRepeat.getText().toString();

            if (!passStr.equals(passRepeatStr)){
                Toast.makeText(Signup.this, "Passwords don't match", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(Signup.this, "Registered", Toast.LENGTH_LONG).show();
            }
        }
    }
}
