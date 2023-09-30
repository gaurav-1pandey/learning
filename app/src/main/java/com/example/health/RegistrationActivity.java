package com.example.health;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.health.data.MYhandler;

public class RegistrationActivity extends AppCompatActivity
{

    public static boolean isValid(String password)
    {
        if (!((password.length() >= 8) && (password.length() <= 15)))
        {
            return false;
        }
        if (password.contains(" "))
        {
            return false;
        }
        if (true)
        {
            int count = 0;
            for (int i = 0; i <= 9; i++)
            {
                String str1 = Integer.toString(i);
                if (password.contains(str1))
                {
                    count = 1;
                }
            }
            if (count == 0)
            {
                return false;
            }
        }
        if (!(password.contains("@") || password.contains("#")
                || password.contains("!") || password.contains("~")
                || password.contains("$") || password.contains("%")
                || password.contains("^") || password.contains("&")
                || password.contains("*") || password.contains("(")
                || password.contains(")") || password.contains("-")
                || password.contains("+") || password.contains("/")
                || password.contains(":") || password.contains(".")
                || password.contains(", ") || password.contains("<")
                || password.contains(">") || password.contains("?")
                || password.contains("|")))
        {
            return false;
        }
        if (true)
        {
            int count = 0;
            for (int i = 65; i <= 90; i++)
            {
                char c = (char)i;
                String str1 = Character.toString(c);
                if (password.contains(str1))
                {
                    count = 1;
                }
            }
            if (count == 0)
            {
                return false;
            }
        }
        if (true)
        {
            int count = 0;
            for (int i = 97; i <= 122; i++)
            {
                char c = (char)i;
                String str1 = Character.toString(c);
                if (password.contains(str1))
                {
                    count = 1;
                }
            }
            if (count == 0)
            {
                return false;
            }
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        EditText edusername,edemail,edpass,edconfirmpass;
        Button register;
        TextView tv = findViewById(R.id.textExistingUser);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        register = findViewById(R.id.buttonRegister);
        edusername=findViewById(R.id.editTextRegUsername);
        edemail=findViewById(R.id.editTextRegEmail);
        edpass=findViewById(R.id.editTextRegPassword);
        edconfirmpass=findViewById(R.id.editTextRegConfirmPassword);


        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String username =edusername.getText().toString();
                String email =edemail.getText().toString();
                String pass =edpass.getText().toString();
                String confirmpass =edconfirmpass.getText().toString();
                MYhandler db = new MYhandler(getApplicationContext());
                if (username.length()==0 || email.length()==0 || pass.length()==0 || confirmpass.length()==0)
                {
                    Toast.makeText(RegistrationActivity.this,"please fill all details",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(!(pass.equals(confirmpass)))
                    {
                        Toast.makeText(RegistrationActivity.this,"password and confirm password not same",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if (isValid(pass))

                        {

                            db.register(username,email,pass);
                            Toast.makeText(RegistrationActivity.this,"Registration Successfull",Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else
                        {
                            Toast.makeText(RegistrationActivity.this,"Create a Strong password",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}