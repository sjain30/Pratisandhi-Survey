package com.pratisandhi.survey.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.pratisandhi.survey.R
import com.pratisandhi.survey.activities.Survey
import com.pratisandhi.survey.databinding.FragmentSectionTwoBinding
import com.sample.viewbinding.fragment.viewBinding

class SectionTwo : Fragment(R.layout.fragment_section_two) {

    private val binding: FragmentSectionTwoBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextTwo.setOnClickListener {
            (activity as Survey).binding.viewPager.currentItem += 1
        }

        binding.backTwo.setOnClickListener {
            (activity as Survey).binding.viewPager.currentItem -= 1
        }
    }
}