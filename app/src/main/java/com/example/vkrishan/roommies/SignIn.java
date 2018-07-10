package com.example.vkrishan.roommies;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;


public class SignIn extends AppCompatActivity {

    private EditText signin_email;
    private EditText signin_password;
    private Button signIn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        // Firebase
        mAuth = FirebaseAuth.getInstance();

        signin_email = (EditText) findViewById(R.id.edt_signin_email);
        signin_password = (EditText) findViewById(R.id.edt_signin_password);
        signIn = (Button) findViewById(R.id.btn_signin_signin);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str_email = signin_email.getText().toString();
                String str_password = signin_password.getText().toString();


                signInAccount(str_email, str_password);

            }
        });

    }

    private void signInAccount(String email, String password){

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            Intent mainIntent = new Intent(SignIn.this, MainActivity.class);
                            startActivity(mainIntent);
                            finish();


                        } else {

                            Toast.makeText(SignIn.this, "Error in registering user", Toast.LENGTH_LONG).show();

                        }

                        // ...
                    }
                });

    }
}
