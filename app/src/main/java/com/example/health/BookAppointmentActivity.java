package com.example.health;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity {
    EditText e1, e2, e3, e4;
    Button btnback;
    DatePickerDialog dp;
    TimePickerDialog tp;
    Calendar c;
    TextView td,tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        e1 = findViewById(R.id.app_a1);
        e2 = findViewById(R.id.app_a2);
        e3 = findViewById(R.id.app_a3);
        e4 = findViewById(R.id.app_a4);
        btnback = findViewById(R.id.app_back);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        e1.setKeyListener(null);
        e2.setKeyListener(null);
        e3.setKeyListener(null);
        e4.setKeyListener(null);

        td=findViewById(R.id.app_selectdate);
        pkdtpls();
        td.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dp.show();
            }
        });

        tt=findViewById(R.id.app_seleecttime);
        pktmpls();
        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tp.show();
            }
        });



        Intent i = getIntent();
        String name = i.getStringExtra("docname");
        String add = i.getStringExtra("docadress");
        String nmbr = i.getStringExtra("docnmbr");
        String fees = i.getStringExtra("docfees");
        e1.setText(name);
        e2.setText(add);
        e3.setText(nmbr);
        e4.setText(fees);


    }

    private void pkdtpls(){
        DatePickerDialog.OnDateSetListener odsl = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1 + 1;

                td.setText(i2+"/"+i1+"/"+i);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH);
        int style = AlertDialog.THEME_DEVICE_DEFAULT_DARK;
        dp = new DatePickerDialog(this, style, odsl, year, month, day);
        dp.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000);

    }
    private void pktmpls(){
        TimePickerDialog.OnTimeSetListener otsl= new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {

                tt.setText(i+":"+i1);


            }
        };
        Calendar cal = Calendar.getInstance();
        int min=cal.get(Calendar.MINUTE);
        int hrs=cal.get(Calendar.HOUR);

        int style=AlertDialog.THEME_DEVICE_DEFAULT_DARK;
        tp=new TimePickerDialog(this,style,otsl,min,hrs,true);
    }


}
