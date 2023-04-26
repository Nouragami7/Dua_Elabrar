package com.example.my;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sign_in extends AppCompatActivity {
    EditText Email,pass;
    Button singInButton;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Email = findViewById(R.id.semail);
        pass = findViewById(R.id.spass);
        singInButton = findViewById(R.id.signIn);
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        singInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String savedEmail = sharedPreferences.getString("email", "");
                String savedPassword = sharedPreferences.getString("password", "");
                String inputEmail = Email.getText().toString();
                String inputPassword = pass.getText().toString();
                if (savedEmail.equals(inputEmail) && savedPassword.equals(inputPassword)) {
                    Intent intent = new Intent(sign_in.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(sign_in.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }

        });



    }
}