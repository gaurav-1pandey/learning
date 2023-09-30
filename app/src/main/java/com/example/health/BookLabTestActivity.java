package com.example.health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.health.data.MYhandler;

public class BookLabTestActivity extends AppCompatActivity {
    Button btnbook,btnback,cart,delItem;
    TextView detail,pack,cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_lab_test);


        detail=findViewById(R.id.textView12);
        cost=findViewById(R.id.textView13);
        pack=findViewById(R.id.textRegistration2);
        btnbook=findViewById(R.id.buttonRegister);
        delItem=findViewById(R.id.buttonRegister2);
        btnback=findViewById(R.id.LTbackBook);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent i =getIntent();
        String d=i.getStringExtra("detail");
        String p=i.getStringExtra("packname");
        String c=i.getStringExtra("cost");
        pack.setText(p);
        detail.setText(d);
        cost.setText("Test Charges : "+c+"/-");

        cart=findViewById(R.id.BkLTCart);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LabCartActivity.class));
            }
        });

        MYhandler db=new MYhandler(getApplicationContext());

        btnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (db.checkcart("Gaurav",p)==1){
                    Toast.makeText(getApplicationContext(),"Item already added",Toast.LENGTH_SHORT).show();
                }else{
                db.addtocart("Gaurav",p,c,"Lab Test");
                Toast.makeText(getApplicationContext(),"Item added to cart",Toast.LENGTH_SHORT).show();
                }
            }
        });



        delItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (db.checkcart("Gaurav",p)==1){
                    db.deletefrmcart("Gaurav",p);
                    Toast.makeText(getApplicationContext(),"item removed from cart",Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(getApplicationContext(),"item is not present",Toast.LENGTH_SHORT).show();

                }

//                finish();
            }
        });


    }
}