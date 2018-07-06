package com.example.vkrishan.roommies;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    // Tab names
    private String[] title = {"Dashboard","Chats","Notes","Reminder"};

    // Constructor
    public ViewPagerAdapter(FragmentManager manager){
        super(manager);
    }

    @Override
    public Fragment getItem(int position){          // returns each fragment
        return TabFragment.getFragmentInstance(position);
    }

    @Override
    public int getCount(){                          // number of tabs
        return title.length;
    }


    @Override
    public CharSequence getPageTitle(int position) {    // each Tab title
        return title[position];
    }

}
