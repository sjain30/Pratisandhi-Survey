package com.pratisandhi.survey.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pratisandhi.survey.R
import com.pratisandhi.survey.databinding.ActivityMainBinding
import com.pratisandhi.survey.databinding.ActivitySurveyBinding
import com.pratisandhi.survey.utils.SectionsPagerAdapter
import com.sample.viewbinding.activity.viewBinding

class Survey : AppCompatActivity() {

    private val binding: ActivitySurveyBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)


        //Setup viewpager and tablayout
        val sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager, this)
        binding.viewPager.adapter = sectionsPagerAdapter

    }
}