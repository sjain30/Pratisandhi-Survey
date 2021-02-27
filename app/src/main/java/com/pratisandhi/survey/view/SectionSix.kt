package com.pratisandhi.survey.view

import android.os.Bundle
import android.widget.RadioButton
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pratisandhi.survey.R
import com.pratisandhi.survey.activities.Survey
import com.pratisandhi.survey.databinding.FragmentSectionSixBinding
import com.pratisandhi.survey.utils.toast
import com.pratisandhi.survey.viewModel.SectionSixViewModel
import com.sample.viewbinding.fragment.viewBinding

class SectionSix : Fragment(R.layout.fragment_section_six) {

    private val binding: FragmentSectionSixBinding by viewBinding()
    private lateinit var viewModel: SectionSixViewModel
    private lateinit var radio1: RadioButton
    private lateinit var radio2: RadioButton
    private lateinit var radio3: RadioButton


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SectionSixViewModel::class.java)

        binding.sixAns4.editText?.doAfterTextChanged { binding.sixAns4.error = null }

        binding.nextSix.setOnClickListener {
            if (binding.sixAns1.checkedRadioButtonId == -1 ||
                binding.sixAns2.checkedRadioButtonId == -1 ||
                binding.sixAns3.checkedRadioButtonId == -1
            ) {
                context?.toast(getString(R.string.unanswered))
                return@setOnClickListener
            }

            if(binding.sixAns4.editText?.text.isNullOrEmpty()){
                binding.sixAns4.error = getString(R.string.blank)
                binding.sixAns4.requestFocus()
                return@setOnClickListener
            }
            radio1 = view?.findViewById(binding.sixAns1.checkedRadioButtonId)!!
            radio2 = view?.findViewById(binding.sixAns2.checkedRadioButtonId)!!
            radio3 = view?.findViewById(binding.sixAns3.checkedRadioButtonId)!!

            viewModel.update(radio1.text.toString(),radio2.text.toString(),radio3.text.toString(),binding.sixAns4.editText?.text.toString())

            (activity as Survey).binding.viewPager.currentItem += 1
        }

        binding.backSix.setOnClickListener {
            (activity as Survey).binding.viewPager.currentItem -= 1
        }
    }

}