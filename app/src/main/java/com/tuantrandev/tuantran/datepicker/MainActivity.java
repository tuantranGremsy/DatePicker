package com.tuantrandev.tuantran.datepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    Button btnShow;
    TextView tvDate;
    int day, month, year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Mapping views
        btnShow = (Button)findViewById(R.id.btnShow);
        tvDate = (TextView)findViewById(R.id.tvDate);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(111);
            }
        });
        displayDay();
    }

    private void displayDay(){
        Calendar rightnow = Calendar.getInstance(TimeZone.getTimeZone("UTC+7"));
        day = rightnow.get(Calendar.DAY_OF_MONTH);
        month = rightnow.get(Calendar.MONTH);
        year = rightnow.get(Calendar.YEAR);
        tvDate.setText("Date: "+ day + "/" + month +"/"+ year);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 111) {
            return new DatePickerDialog(this, dateLPickerListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener dateLPickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int y, int m, int d) {
//            displayDay(d, m+1, y);
        }
    };
}
