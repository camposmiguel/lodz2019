package com.miguelcr.a01_linearlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etEmail, etPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.editTextEmail);
        etPass = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.buttonLogin);

        // Click event for the button login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 1. Get the email wrote by the user
                String email = etEmail.getText().toString();

                // 2. Get the password
                String password = etPass.getText().toString();

                if(email.isEmpty()) {
                    etEmail.setError("Email is required");
                } else if (password.isEmpty()) {
                    etPass.setError("Password is required");
                }

                Toast.makeText(
                        MainActivity.this,
                        "Login clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
