package com.pratisandhi.survey.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.pratisandhi.survey.R
import com.pratisandhi.survey.activities.Survey
import com.pratisandhi.survey.databinding.FragmentSectionThreeBinding
import com.sample.viewbinding.fragment.viewBinding

class SectionThree : Fragment(R.layout.fragment_section_three) {

    private val binding: FragmentSectionThreeBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextThree.setOnClickListener {
            (activity as Survey).binding.viewPager.currentItem += 1
        }

        binding.backThree.setOnClickListener {
            (activity as Survey).binding.viewPager.currentItem -= 1
        }
    }
}