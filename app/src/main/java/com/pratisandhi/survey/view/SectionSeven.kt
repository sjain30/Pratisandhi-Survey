package com.pratisandhi.survey.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pratisandhi.survey.R
import com.pratisandhi.survey.activities.Survey
import com.pratisandhi.survey.databinding.FragmentSectionSevenBinding
import com.pratisandhi.survey.viewModel.SectionSevenViewModel
import com.sample.viewbinding.fragment.viewBinding

class SectionSeven : Fragment(R.layout.fragment_section_seven) {


    private val binding: FragmentSectionSevenBinding by viewBinding()
    private lateinit var viewModel: SectionSevenViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextSeven.setOnClickListener {

        }

        binding.backSeven.setOnClickListener {
            (activity as Survey).binding.viewPager.currentItem -= 1
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SectionSevenViewModel::class.java)
        // TODO: Use the ViewModel
    }

}