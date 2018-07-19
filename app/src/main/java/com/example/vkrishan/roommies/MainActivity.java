package com.example.vkrishan.roommies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;




public class MainActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar mtoolbar;
    private TabLayout tablayout;
    private ViewPager viewPager;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        mtoolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setTitle("Roomiesss");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter vpa = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(vpa);

        tablayout = (TabLayout) findViewById(R.id.main_tabs);
        tablayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser==null){
            sendToLoginPage();
        }
    }

    private void sendToLoginPage(){
        Intent startIntent = new Intent(MainActivity.this, Welcome.class);
        startActivity(startIntent);
        finish(); // so user doesn't come back here on pressing BACK button.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
         getMenuInflater().inflate(R.menu.main_menu, menu);

         return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         super.onOptionsItemSelected(item);

        if(item.getItemId()== R.id.btn_profile_setting){
            Intent i = new Intent(MainActivity.this, ProfileSetting.class);
            startActivity(i);

        }

         if(item.getItemId()== R.id.btn_logout){
             FirebaseAuth.getInstance().signOut();
             sendToLoginPage();
         }

         return true;
    }
}
