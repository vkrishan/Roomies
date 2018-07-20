package com.example.vkrishan.roommies;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileSetting extends AppCompatActivity {

    private DatabaseReference mUserDatabase;
    private FirebaseUser mCurrentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();

        String curr_uid = mCurrentUser.getUid(); // Gets UID of the user which is our KEY

        mUserDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(curr_uid); // Database record of 1 user

        mUserDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

     //             Toast.makeText(getApplicationContext(), "------>>"+dataSnapshot.toString(), Toast.LENGTH_SHORT).show();
                String u_name = dataSnapshot.child("name").getValue().toString();
                String u_img = dataSnapshot.child("image").getValue().toString();
                String u_status = dataSnapshot.child("status").getValue().toString();
                String u_thumb_image = dataSnapshot.child("thumb_image").getValue().toString();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {



            }
        });





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
