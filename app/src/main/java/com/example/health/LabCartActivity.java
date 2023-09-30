package com.example.health;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.health.data.MYhandler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class LabCartActivity extends AppCompatActivity {
    DatePickerDialog dp;
    SimpleAdapter sa;
    TimePickerDialog tp;
    TextView td,tt,texttotal;
    Button btnback;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_cart);

        td=findViewById(R.id.LC_selectdate);
        tt=findViewById(R.id.LC_seleecttime);

        btnback=findViewById(R.id.LTcart_back);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        getcart();
        pkdtpls();
        pktmpls();
        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tp.show();
            }
        });
        td.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dp.show();
            }
        });
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
    private void getcart(){
        lv=findViewById(R.id.list_cart);
        ArrayList list;
        MYhandler db =new MYhandler(getApplicationContext());
        list=db.getcartdetail("Gaurav");
        sa=new SimpleAdapter(this,list,R.layout.custom_lay,new String[]{"name","product","price","","type"},
        new int[]{R.id.line1,R.id.line2,R.id.line3,R.id.line4,R.id.line5});
        lv.setAdapter(sa);
        int sum=0;
        for(int i=0;i<list.size();i++){
            HashMap h=(HashMap) list.get(i);
            sum=sum+Integer.parseInt(h.get("price").toString());
        }
        texttotal=findViewById(R.id.textRegistration3);
        texttotal.setText("Total cost : "+(char) 8377+sum+"/-");
    }
}