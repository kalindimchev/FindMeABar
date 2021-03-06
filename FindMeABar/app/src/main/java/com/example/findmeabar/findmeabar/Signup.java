package com.example.findmeabar.findmeabar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.telerik.everlive.sdk.core.EverliveApp;
import com.telerik.everlive.sdk.core.EverliveAppSettings;
import com.telerik.everlive.sdk.core.result.RequestResult;
import com.telerik.everlive.sdk.core.result.RequestResultCallbackAction;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup extends AppCompatActivity {
    EverliveApp myApp;
    List<User> users;
//    List<User> users;
    private boolean userIsRegistered;
    private boolean registerInfoIsOk;
    private String nameStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_signup);

        initializeSdk();
        users = new ArrayList<User>();
//        users = new ArrayList<User>();
    }

    private void initializeSdk() {
        String appId = "ce9fho1ly52u25nl";
        EverliveAppSettings appSettings = new EverliveAppSettings();
        appSettings.setAppId(appId);

        myApp = new EverliveApp(appSettings);
    }

    public void onSignupClick(View v) {

        if (v.getId() == R.id.b_reg_signup_btn) {

            userIsRegistered = false;
            registerInfoIsOk = true;

            EditText name = (EditText) findViewById(R.id.et_reg_name);
            EditText email = (EditText) findViewById(R.id.et_reg_email);
            EditText username = (EditText) findViewById(R.id.et_reg_username);
            EditText pass = (EditText) findViewById(R.id.et_reg_password);
            EditText passRepeat = (EditText) findViewById(R.id.et_reg_confirm_password);

            nameStr = name.getText().toString();
            String emailStr = email.getText().toString();
            String usernameStr = username.getText().toString();
            String passStr = pass.getText().toString();
            String passRepeatStr = passRepeat.getText().toString();

            if (!validateName(nameStr)) {
                name.setError(getString(R.string.warning_invalid_name));
                registerInfoIsOk = false;
            } else if (!validateEmail(emailStr)) {
                email.setError(getString(R.string.warning_invalid_email));
                registerInfoIsOk = false;
            } else if (!validateName(usernameStr)) {
                username.setError(getString(R.string.warning_invalid_username));
                registerInfoIsOk = false;
            } else if (!validatePassword(passStr)) {
                pass.setError(getString(R.string.warning_length_password));
                registerInfoIsOk = false;
            } else if (!validatePassword(passRepeatStr)) {
                pass.setError(getString(R.string.warning_length_password));
                registerInfoIsOk = false;
            } else if (!passStr.equals(passRepeatStr)) {
                pass.setError(getString(R.string.warning_password_not_match));
                passRepeat.setError(getString(R.string.warning_password_not_match));
                registerInfoIsOk = false;
            }

            if (registerInfoIsOk) {
                getAllEntries();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                CheckIfUserExists(userIsRegistered);
            }
        }

    }

    private void getAllEntries() {
        myApp.workWith().data(User.class).getAll().executeAsync(new RequestResultCallbackAction<ArrayList<User>>() {

            @Override
            public void invoke(RequestResult<ArrayList<User>> requestResult) {
                if (requestResult.getSuccess()) {
                    for (User u : requestResult.getValue()) {
                        users.add(u);
                        if (u.getUserName() == nameStr) {
                            userIsRegistered = true;
                            return;
                        }
                    }
                } else {
                    System.out.println("*****Error*****: " + requestResult.getError().toString());
                }
            }
        });
    }

    private void CheckIfUserExists(boolean userIsRegistered) {

        AlertDialog.Builder a_builder = new AlertDialog.Builder(Signup.this, AlertDialog.THEME_HOLO_DARK);
        if (!userIsRegistered) {
            a_builder.setMessage(R.string.success_registration_msg);
        } else {
            a_builder.setMessage(R.string.user_exsists_msg);
        }
        a_builder.setCancelable(false);
        a_builder
                .setPositiveButton(R.string.label_positive_btn, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = a_builder.create();
        alert.setTitle(getString(R.string.alert_title_regidtration));
        alert.show();
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
