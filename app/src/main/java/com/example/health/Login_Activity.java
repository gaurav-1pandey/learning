package com.example.health;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.health.data.MYhandler;

public class Login_Activity extends AppCompatActivity {
    EditText username ,password ;
    TextView tv,tvreg;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.editTextLoginUsername);
        password= findViewById(R.id.editTextLoginPassword);
        btn=findViewById(R.id.ButtonLogin);
        tv=findViewById(R.id.textNewReg);
        MYhandler db = new MYhandler(getApplicationContext());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                        Toast.makeText(getApplicationContext(),"Welcome Gaurav",Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));}

                if (username.length()==0 || password.length()==0){
                    Toast.makeText(getApplicationContext(),"please fill all details",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (db.login(username.getText().toString(),password.getText().toString())==1){
                        Toast.makeText(getApplicationContext(),"Login Sucess",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));}
                    else {
                        Toast.makeText(getApplicationContext(),"no records found register",Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RegistrationActivity.class));
            }
        });

    }

}
