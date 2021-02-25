package com.pratisandhi.survey.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pratisandhi.survey.R
import com.pratisandhi.survey.activities.Survey
import com.pratisandhi.survey.databinding.FragmentSectionFiveBinding
import com.pratisandhi.survey.viewModel.SectionFiveViewModel
import com.sample.viewbinding.fragment.viewBinding

class SectionFive : Fragment(R.layout.fragment_section_five) {

    private val binding: FragmentSectionFiveBinding by viewBinding()
    private lateinit var viewModel: SectionFiveViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextFive.setOnClickListener {
            (activity as Survey).binding.viewPager.currentItem += 1
        }

        binding.backFive.setOnClickListener {
            (activity as Survey).binding.viewPager.currentItem -= 1
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SectionFiveViewModel::class.java)
        // TODO: Use the ViewModel
    }

}