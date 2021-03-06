package com.example.s_shah.instaclone;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

public class LogIn extends AppCompatActivity implements View.OnClickListener{


    private EditText loginEmail;
    private EditText loginPassWord;
    private Button lLogin;
    private Button lSignUp;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setTitle("Login");

        loginEmail = findViewById(R.id.loginEmail);
        loginPassWord = findViewById(R.id.loginPassWord);
        lLogin = findViewById(R.id.lLogin);
        lSignUp = findViewById(R.id.lSignUp);

        loginPassWord.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN){
                    onClick(lLogin);
                }
                return false;
            }
        });

        lLogin.setOnClickListener(this);
        lSignUp.setOnClickListener(this);

        if (ParseUser.getCurrentUser() != null){
            ParseUser.getCurrentUser().logOut();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lSignUp:
                Intent intent = new Intent(LogIn.this, SignUp.class);
                startActivity(intent);
                break;


            case R.id.lLogin:
                final ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setMessage("Logging in");
                progressDialog.show();
                ParseUser.logInInBackground(loginEmail.getText().toString(), loginPassWord.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if(user != null && e == null){
                            FancyToast.makeText(LogIn.this,
                                    user.getUsername()+ " is Logged in.",
                                    Toast.LENGTH_SHORT,FancyToast.SUCCESS,
                                    true).show();
                        }else{
                            FancyToast.makeText(LogIn.this, e.getMessage(), Toast.LENGTH_LONG, FancyToast.ERROR, true).show();
                        }
                        progressDialog.dismiss();

                    }
                });
                break;
        }

    }
    public void rootLayoutTapped(View view){
        try{
            InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
