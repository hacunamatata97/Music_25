package com.framgia.music_25.screen.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.framgia.music_25.screen.home.HomeFragment;

public class FragmentChangeAdapter extends FragmentPagerAdapter {

    private static final int FRAGMENT_COUNT = 7;

    FragmentChangeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            default:
                return HomeFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }
}
