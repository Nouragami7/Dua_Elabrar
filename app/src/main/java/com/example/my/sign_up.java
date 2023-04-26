package com.example.my;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class sign_up extends AppCompatActivity {
    EditText Name,Email,pass,confirmPass;
    Button signUpButton;
    TextView login;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Name = findViewById(R.id.name);
        Email =findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        confirmPass = findViewById(R.id.confirmpass);
        signUpButton = findViewById(R.id.signUp);
        login = findViewById(R.id.logIn);
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = Name.getText().toString();
                String email = Email.getText().toString();
                String password = pass.getText().toString();
                String confirmPassword = confirmPass.getText().toString();
                if (password.equals(confirmPassword)) {
                    editor.putString("name", name);
                    editor.putString("email", email);
                    editor.putString("password", password);
                    editor.apply();
                    Intent intent = new Intent(sign_up.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(sign_up.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                }

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sign_up.this, sign_in.class);
                startActivity(intent);
            }
        });

    }
}