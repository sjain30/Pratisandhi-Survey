package com.pratisandhi.survey.utils;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.pratisandhi.survey.view.SectionOne;
import com.pratisandhi.survey.view.SectionThree;
import com.pratisandhi.survey.view.SectionTwo;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private final Context mContext;

    public SectionsPagerAdapter(@NonNull FragmentManager fm, Context mContext) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.mContext = mContext;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position){
            case 0 :return new SectionOne();
            case 1 :return new SectionTwo();
            case 2 :return new SectionThree();
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0 : return "Section One";
            case 1 : return "Section Two";
            case 2 : return "Section Three";
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}