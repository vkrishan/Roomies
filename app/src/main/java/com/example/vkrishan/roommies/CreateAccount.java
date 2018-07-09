package com.example.vkrishan.roommies;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateAccount extends AppCompatActivity {

    private EditText mUsername;
    private EditText mEmail;
    private EditText mPassword;
    private Button mSignIn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        // Firebase
        mAuth = FirebaseAuth.getInstance();

        mUsername = (EditText) findViewById(R.id.edt_CreateAccount_userName);
        mEmail = (EditText) findViewById(R.id.edt_CreateAccount_email);
        mPassword = (EditText) findViewById(R.id.edt_CreateAccount_password);
        mSignIn = (Button) findViewById(R.id.btn_CreateAccount_signup);


        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mUsername_str = mUsername.getText().toString();
                String mEmail_str = mEmail.getText().toString();
                String mPassword_str = mPassword.getText().toString();

//                Log.d("Create Account >>>", "username> "+mUsername_str);
//                Log.d("Create Account >>>", "password> "+mPassword_str);
//                Log.d("Create Account >>>", "email> "+mEmail_str);

                // Store in Firebase DB
                registerAccount(mUsername_str, mEmail_str, mPassword_str);

            }
        });





    }
    // Firebase default...
    private void registerAccount(String user, String email, String pass) {

        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Intent mainIntent = new Intent(CreateAccount.this, MainActivity.class);
                            startActivity(mainIntent);
                            finish();

                        } else {

                            Toast.makeText(CreateAccount.this, "Error in registering user", Toast.LENGTH_LONG).show();

                        }

                        // ...
                    }
                });


    }
}
