package com.pratisandhi.survey.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pratisandhi.survey.R
import com.pratisandhi.survey.activities.Survey
import com.pratisandhi.survey.databinding.FragmentSectionSixBinding
import com.pratisandhi.survey.viewModel.SectionSixViewModel
import com.sample.viewbinding.fragment.viewBinding

class SectionSix : Fragment(R.layout.fragment_section_six) {

    private val binding: FragmentSectionSixBinding by viewBinding()
    private lateinit var viewModel: SectionSixViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextSix.setOnClickListener {
            (activity as Survey).binding.viewPager.currentItem += 1
        }

        binding.backSix.setOnClickListener {
            (activity as Survey).binding.viewPager.currentItem -= 1
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SectionSixViewModel::class.java)
        // TODO: Use the ViewModel
    }

}