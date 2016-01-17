package com.example.findmeabar.findmeabar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_signup);
    }

    public void onSignupClick(View v) {

        if (v.getId() == R.id.b_reg_signup_btn) {

            EditText name = (EditText) findViewById(R.id.et_reg_name);
            EditText email = (EditText) findViewById(R.id.et_reg_email);
            EditText username = (EditText) findViewById(R.id.et_reg_username);
            EditText pass = (EditText) findViewById(R.id.et_reg_password);
            EditText passRepeat = (EditText) findViewById(R.id.et_reg_confirm_password);

            String nameStr = name.getText().toString();
            String emailStr = email.getText().toString();
            String usernameStr = username.getText().toString();
            String passStr = pass.getText().toString();
            String passRepeatStr = passRepeat.getText().toString();

            if (!validateName(nameStr)) {
                name.setError("Invalid name");
            } else if (!validateEmail(emailStr)) {
                email.setError("Invalid Email");
            } else if (!validateName(usernameStr)) {
                username.setError("Invalid username");
            } else if (!validatePassword(passStr)) {
                pass.setError("Password 3-9 symbols required");
            } else if (!validatePassword(passRepeatStr)) {
                pass.setError("Password 3-9 symbols required");
            } else if (!passStr.equals(passRepeatStr)) {
                pass.setError("Passwords don't match");
                passRepeat.setError("Passwords don't match");
            } else {
                Toast.makeText(Signup.this, "Registered", Toast.LENGTH_LONG).show();
            }
        }

    }

    protected boolean validateEmail(String email) {
        if (email == null) {
            return false;
        }
        String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    protected boolean validatePassword(String password) {
        if (password == null || password.length() < 3 || password.length() > 9) {
            return false;
        } else {
            return true;
        }
    }

    protected boolean validateName(String name) {
        if (name == null || name.length() < 2) {
            return false;
        } else {
            return true;
        }
    }

    public void onHomeClick(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
