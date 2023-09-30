package com.example.health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FindDoctor extends AppCompatActivity {
    ImageView i1,i2,i3,i4,i5,i6;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        i1=findViewById(R.id.imageView8);
        i2=findViewById(R.id.imageView9);
        i3=findViewById(R.id.imageView10);
        i4=findViewById(R.id.imageView11);
        i5=findViewById(R.id.imageView12);
        i6=findViewById(R.id.imageView13);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),DoctorDetail.class);
                it.putExtra("title","Physician");
                startActivity(it);
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),DoctorDetail.class);
                it.putExtra("title","Dietician");
                startActivity(it);
            }
        });

        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),DoctorDetail.class);
                it.putExtra("title","Dentist");
                startActivity(it);
            }
        });

        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),DoctorDetail.class);
                it.putExtra("title","Surgeon");
                startActivity(it);
            }
        });

        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),DoctorDetail.class);
                it.putExtra("title","Cardiologist");
                startActivity(it);
            }
        });

        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}