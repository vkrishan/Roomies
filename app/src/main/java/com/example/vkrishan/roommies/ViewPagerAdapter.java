package com.example.vkrishan.roommies;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    // Constructor
    public ViewPagerAdapter(FragmentManager manager){
        super(manager);
    }

    @Override
    public Fragment getItem(int position){          // returns each fragment
        switch (position){

            case 0:
                DashboardFragment dashboardFragment = new DashboardFragment();
                return dashboardFragment;

            case 1:
                ChatFragment chatFragment = new ChatFragment();
                return chatFragment;

            case 2:
                NotesFragment notedFragment = new NotesFragment();
                return notedFragment;

            case 3:
                ReminderFragment reminderFragment = new ReminderFragment();
                return reminderFragment;
            default:
                return null;

        }

    }

    @Override
    public int getCount(){                          // number of tabs
        return 4;
    }


    @Override
    public CharSequence getPageTitle(int position) {    // each Tab title

        switch (position){

            case 0:
                return "Dashboard";

            case 1:
                return "Chats";

            case 2:
                return "Notes";

            case 3:
                return "Reminder";
            default:
                return null;

        }


    }

}
