package com.example.vkrishan.roommies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.Toolbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private TabLayout tablayout;
    private ViewPager viewPager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter vpa = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(vpa);

        tablayout = (TabLayout) findViewById(R.id.tabs);
        tablayout.setupWithViewPager(viewPager);

    }
}
