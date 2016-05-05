package com.example.android.bankqueue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class finish extends AppCompatActivity {


    public String gDateId="gDateId";
    public String gTimeId="gTimeId";
    public String gStreetId="gStreetId";
    public String gGoalId="gGoalId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        setTitle("Успех!");

        String street = "";
        TextView otdTextView = (TextView) findViewById(
                R.id.otd);
        Intent intent = getIntent();
        street = intent.getStringExtra(gStreetId);
        otdTextView.setText(street);

        String goal = "";
        TextView goalTextView = (TextView) findViewById(
                R.id.goalText);
        goal = intent.getStringExtra(gGoalId);
        goalTextView.setText(goal);

        String date = "";
        TextView dateTextView = (TextView) findViewById(
                R.id.datepicker);
        date = intent.getStringExtra(gDateId);
        dateTextView.setText(date);

        String time = "";
        TextView timeTextView = (TextView) findViewById(
                R.id.timepicker);
        time = intent.getStringExtra(gTimeId);
        timeTextView.setText(time);
    }

}
