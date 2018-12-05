package com.example.s_shah.instaclone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    private EditText emailAddress;
    private EditText userName;
    private EditText passWord;
    private Button sSignUp;
    private Button sLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        emailAddress = findViewById(R.id.emailAddress);
        userName = findViewById(R.id.userName);
        passWord = findViewById(R.id.passWord);
        sSignUp = findViewById(R.id.sSignUp);
        sLogIn = findViewById(R.id.sLogIn);


        sLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, LogIn.class);
                startActivity(intent);
            }
        });
    }



}
