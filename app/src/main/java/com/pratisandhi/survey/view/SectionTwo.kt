package com.pratisandhi.survey.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pratisandhi.survey.R
import com.pratisandhi.survey.activities.Survey
import com.pratisandhi.survey.databinding.FragmentSectionTwoBinding
import com.pratisandhi.survey.viewModel.SectionTwoViewModel
import com.sample.viewbinding.fragment.viewBinding

class SectionTwo : Fragment(R.layout.fragment_section_two) {

    private val binding: FragmentSectionTwoBinding by viewBinding()
    private lateinit var viewModel: SectionTwoViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SectionTwoViewModel::class.java)

        binding.nextTwo.setOnClickListener {
            (activity as Survey).binding.viewPager.currentItem += 1
            viewModel.updateSurvey(binding.editText10.editText?.text.toString(), binding.editText11.editText?.text.toString())
        }

        binding.backTwo.setOnClickListener {
            (activity as Survey).binding.viewPager.currentItem -= 1
        }
    }
}