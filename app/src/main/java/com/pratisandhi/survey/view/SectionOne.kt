package com.pratisandhi.survey.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pratisandhi.survey.R
import com.pratisandhi.survey.databinding.FragmentSectionOneBinding
import com.pratisandhi.survey.viewModel.SectionOneViewModel
import com.sample.viewbinding.fragment.viewBinding
import com.pratisandhi.survey.activities.Survey

class SectionOne : Fragment(R.layout.fragment_section_one) {

    private val binding: FragmentSectionOneBinding by viewBinding()
    private lateinit var viewModel: SectionOneViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_section_one, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SectionOneViewModel::class.java)

        binding.next1.setOnClickListener {
            (activity as Survey).binding.viewPager.currentItem += 1
            viewModel.addSurvey(binding.editText1.editText?.text.toString())
        }
    }
}