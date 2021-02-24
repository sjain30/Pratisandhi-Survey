package com.pratisandhi.survey.utils

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.pratisandhi.survey.view.*

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(fm: FragmentManager, private val mContext: Context) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return when (position) {
            0 -> SectionOne()
            1 -> SectionTwo()
            2 -> SectionThree()
            4 -> SectionFive()
            5 -> SectionSix()
            6 -> SectionSeven()
            else -> SectionOne()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> return "Section One"
            1 -> return "Section Two"
            2 -> return "Section Three"
            3 -> return "Section Four"
            4 -> return "Section Five"
            5 -> return "Section Six"
            6 -> return "Section Seven"
            else -> null
        }
    }

    override fun getCount(): Int {
        return 7
    }
}