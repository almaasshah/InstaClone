package com.example.s_shah.instaclone;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogIn extends AppCompatActivity {
    private EditText loginEmail;
    private EditText loginPassWord;
    private Button lLogin;
    private Button lSignUp;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        loginEmail = findViewById(R.id.loginEmail);
        loginPassWord = findViewById(R.id.loginPassWord);
        lLogin = findViewById(R.id.lLogin);
        lSignUp = findViewById(R.id.lSignUp);

        lSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this, SignUp.class);
                startActivity(intent);
            }
        });

    }
}
