package com.example.health;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
public class LabTestActivity extends AppCompatActivity {

    Button btnback,btncart;
    HashMap<String,String> hm;
    SimpleAdapter sa;
    ArrayList l;
    ListView lt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);
        String[][] ds= {{"Package 1 : Full Body Checkup","","                                        ","                                        ", "999"},
                        {"Package 2: Blood Glucose Fasting","","                                        ","                                        ", "299"},
                        {"Package 3: COVID-19 Antibody - IgG","","","                                                                                ","899"},
                        {"Package 4: Thyroid Check","","","                                                                                ", "499"},
                        {"Package 5: Immunity Check","","","                                                                                ","699"}};


        String[] package_details = {"Blood Glucose Fasting\n"
                + "Complete Hemogram\n"+
                "HbA1c\n" + "Iron Studies\n"
                + "Kidney Function Test\n"
                + "LDH Lactate Dehydrogenase, Serum\n"
                + "Lipid Profile\n"
                + "Liver Function Test",
                "Blood Glucose Fasting",
                "COVID-19 Antibody - IgG",
                "Thyroid Profile-Total (T3, T4 & TSH Ultra-sensitive)",
                "Complete Hemogram\n" + "CRP (C Reactive Protein) Quantitative, Serum\n" +"Iron Studies\n" + "Kidney Function Test\n"
                 + "Vitamin D Total-25 Hydroxy\n"
                 + "Liver Function Test\n"
                 + "Lipid Profile"};
        l=new ArrayList();
        for (String[] s : ds)
        {
            hm=new HashMap<>();
            hm.put("line1",s[0]);
            hm.put("line2",s[1]);
            hm.put("line3",s[2]);
            hm.put("line4",s[3]);
            hm.put("line5","Test Charges : "+s[4]);
            l.add(hm);
        }
        sa = new SimpleAdapter(this,l,R.layout.custom_lay,
                new String[]{"line1","line2","line3","line4","line5",},
                new int[]{R.id.line1,R.id.line2,R.id.line3,R.id.line4,R.id.line5});
        lt = findViewById(R.id.listLT);
        lt.setAdapter(sa);
        lt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent im = new Intent(getApplicationContext(),BookLabTestActivity.class);
                im.putExtra("packname",ds[i][0]);
                im.putExtra("cost",ds[i][4]);
                im.putExtra("detail",package_details[i]);
                startActivity(im);
            }
        });
        btncart=findViewById(R.id.buttonLTcart);
        btncart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LabCartActivity.class));
            }
        });
        btnback=findViewById(R.id.buttonLTback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}