package com.example.android.bankqueue;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.TimePicker;
import android.app.TimePickerDialog.OnTimeSetListener;

import java.util.Calendar;


public class GoalPicker extends AppCompatActivity {

    Calendar calendar = Calendar.getInstance();

    int DIALOG_DATE = 1;
    int myYear = calendar.get(Calendar.YEAR);
    int myMonth = calendar.get(Calendar.MONTH);
    int myDay = calendar.get(Calendar.DAY_OF_MONTH);
    TextView tvDate;

    int DIALOG_TIME = 2;
    int myHour = calendar.get(Calendar.HOUR);
    int myMinute =calendar.get(Calendar.MINUTE);
    TextView tvTime;

    public String otdStreet="otdStreet";

    public String gDateId="gDateId";
    public String gDate;
    public String gTimeId="gTimeId";
    public String gTime;
    public String gStreetId="gStreetId";
    public String gStreet;
    public String gGoalId="gGoalId";
    public String gGoal;

    public Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goal_picker_activity);
        setTitle("Выбор назначения");

        String street = "";
        TextView otdTextView = (TextView) findViewById(
                R.id.otd);
        Intent intent = getIntent();
        street = intent.getStringExtra(otdStreet);
        otdTextView.setText(street);
        gStreet=street;

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.goal_array, R.layout.my_spinner);
        spinner.setAdapter(adapter);


        tvDate = (TextView) findViewById(R.id.datepicker);
        tvDate.setText(myDay + "/" + myMonth + "/" + myYear);
        gDate= myDay + "/" + myMonth + "/" + myYear;

        tvTime = (TextView) findViewById(R.id.timepicker);
        tvTime.setText(myHour + " : " + myMinute);
        gTime=myHour + " : " + myMinute;
    }


        public void onclickDate(View view) {
                showDialog(DIALOG_DATE);
            }

        public void onclickTime(View view) {
        showDialog(DIALOG_TIME);
            }

        protected Dialog onCreateDialog(int id) {
            if (id == DIALOG_DATE) {
                DatePickerDialog dpd = new DatePickerDialog(this, myCallBackDate, myYear, myMonth, myDay);
                return dpd;
            }
                else if (id == DIALOG_TIME) {
                    TimePickerDialog tpd = new TimePickerDialog(this, myCallBackTime, myHour, myMinute, true);
                    return tpd;
                }
            return super.onCreateDialog(id);
        }

        OnDateSetListener myCallBackDate = new OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myYear = year;
                myMonth = monthOfYear;
                myDay = dayOfMonth;
                tvDate.setText(myDay + "/" + myMonth + "/" + myYear);
                gDate= myDay + "/" + myMonth + "/" + myYear;
            }
        };

        OnTimeSetListener myCallBackTime = new OnTimeSetListener() {
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            myHour = hourOfDay;
            myMinute = minute;
            tvTime.setText(myHour + " : " + myMinute);
            gTime=myHour + " : " + myMinute;

            }
    };

    public void ok(View view){
        gGoal=spinner.getSelectedItem().toString();

        Intent fin=new Intent(this, finish.class);
        fin.putExtra(gStreetId,gStreet);
        fin.putExtra(gDateId,gDate);
        fin.putExtra(gTimeId,gTime);
        fin.putExtra(gGoalId,gGoal);

        startActivity(fin);
    }

}
