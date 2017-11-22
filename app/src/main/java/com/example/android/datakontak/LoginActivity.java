package com.example.android.datakontak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin, btnRegister;
    private String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        setView();
    }

    private void setView() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();

                if (username.isEmpty() && password.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Isi username dan password!", Toast.LENGTH_SHORT).show();
                } else {
                    if (username.equals("ifan") && password.equals("1234")){
                        Intent toHome = new Intent(LoginActivity.this, HomeActivity.class);
                        toHome.putExtra("username", username);
                        startActivity(toHome);
                    } else {
                        Toast.makeText(LoginActivity.this, "Username dan password tidak ditemukan", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void initView() {
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister  = findViewById(R.id.btn_register);
    }
}
