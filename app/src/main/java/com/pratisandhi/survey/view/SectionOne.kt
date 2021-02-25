package com.pratisandhi.survey.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.pratisandhi.survey.R
import com.pratisandhi.survey.activities.Survey
import com.pratisandhi.survey.databinding.FragmentSectionOneBinding
import com.sample.viewbinding.fragment.viewBinding

class SectionOne : Fragment(R.layout.fragment_section_one) {

    val binding: FragmentSectionOneBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextOne.setOnClickListener {
            (activity as Survey).binding.viewPager.currentItem += 1
        }

    }
}