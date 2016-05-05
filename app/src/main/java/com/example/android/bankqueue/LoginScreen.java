package com.example.android.bankqueue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;


public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        setTitle("Memorandum");
    }

    public void login(View view)
    {
        EditText pn = (EditText) findViewById(
                R.id.pnumber);
        EditText ps = (EditText) findViewById(
                R.id.password);
        if((pn.getText().length()>0)&&(ps.getText().length()>0)){
        Intent bankPickerScreen = new Intent(this, BankPicker.class);
        startActivity(bankPickerScreen);
    }
        else
        {
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Не все поля заполнены");
            dlgAlert.setTitle("Ошибка");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
        }

    }
    public void Registration(View view)
    {
       Intent regScreen =new Intent(this, RegistrationActivity.class);
       startActivity(regScreen);
    }
}
