package com.pratisandhi.survey.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pratisandhi.survey.databinding.ActivitySurveyBinding
import com.pratisandhi.survey.utils.SectionsPagerAdapter
import com.sample.viewbinding.activity.viewBinding

class Survey : AppCompatActivity() {

    val binding: ActivitySurveyBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Setup viewpager
        val sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager, this)
        binding.viewPager.offscreenPageLimit = 6
        binding.viewPager.adapter = sectionsPagerAdapter

    }
}