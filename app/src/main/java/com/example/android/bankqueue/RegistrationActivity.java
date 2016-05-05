package com.example.android.bankqueue;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setTitle("Регистрация");
    }
    public void ok(View view)
    {
        EditText f = (EditText) findViewById(
                R.id.editText);
        EditText n = (EditText) findViewById(
                R.id.editText2);
        EditText pn = (EditText) findViewById(
                R.id.editText3);
        EditText ps = (EditText) findViewById(
                R.id.editText4);
        if((f.getText().length()>0)&&(n.getText().length()>0)&&(pn.getText().length()>0)&&(ps.getText().length()>0)) {
            finish();
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

}
