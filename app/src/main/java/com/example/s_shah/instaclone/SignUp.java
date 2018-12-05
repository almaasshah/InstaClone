package com.example.s_shah.instaclone;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUp extends AppCompatActivity implements View.OnClickListener{
//Ui Components
    private EditText emailAddress;
    private EditText userName;
    private EditText passWord;
    private Button sSignUp;
    private Button sLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle("Sign Up");

        emailAddress = findViewById(R.id.emailAddress);
        userName = findViewById(R.id.userName);
        passWord = findViewById(R.id.passWord);
        sSignUp = findViewById(R.id.sSignUp);
        sLogIn = findViewById(R.id.sLogIn);

        sLogIn.setOnClickListener(this);
        sSignUp.setOnClickListener(this);

        if (ParseUser.getCurrentUser() != null) {
            ParseUser.getCurrentUser().logOut();
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sLogIn:
                Intent intent = new Intent(SignUp.this, LogIn.class);
                startActivity(intent);
                break;

            case R.id.sSignUp:
                final ParseUser appUser = new ParseUser();
                appUser.setEmail(emailAddress.getText().toString());
                appUser.setUsername(userName.getText().toString());
                appUser.setPassword(passWord.getText().toString());

                final ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setMessage("Signing Up "+ userName.getText().toString());
                progressDialog.show()
                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e==null){
                            FancyToast.makeText(SignUp.this,
                                    appUser.getUsername() + " is Signed Up",
                                    Toast.LENGTH_SHORT, FancyToast.SUCCESS,
                                    true).show();
                        }else{
                            FancyToast.makeText(SignUp.this,
                                    "There was an error: "+ e.getMessage(),
                                    Toast.LENGTH_LONG, FancyToast.ERROR,
                                    true).show();
                        }
                        progressDialog.dismiss();
                        
                    }
                });
                break;
        }
    }
}
