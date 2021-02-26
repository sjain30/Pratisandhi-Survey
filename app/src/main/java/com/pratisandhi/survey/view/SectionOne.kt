package com.pratisandhi.survey.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pratisandhi.survey.R
import com.pratisandhi.survey.activities.Survey
import com.pratisandhi.survey.databinding.FragmentSectionOneBinding
import com.pratisandhi.survey.viewModel.SectionOneViewModel
import com.sample.viewbinding.fragment.viewBinding

class SectionOne : Fragment(R.layout.fragment_section_one) {

    private val binding: FragmentSectionOneBinding by viewBinding()
    private lateinit var viewModel: SectionOneViewModel
    private lateinit var radio1: RadioButton
    private lateinit var radio2: RadioButton
    private lateinit var radio3: RadioButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_section_one, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SectionOneViewModel::class.java)
        binding.next1.setOnClickListener {
            radio1 = view?.findViewById(binding.radioGroup1.checkedRadioButtonId)!!
            radio2 = view?.findViewById(binding.radioGroup2.checkedRadioButtonId)!!
            radio3 = view?.findViewById(binding.radioGroup3.checkedRadioButtonId)!!
            (activity as Survey).binding.viewPager.currentItem += 1
            viewModel.addSurvey(binding.editText1.editText?.text.toString(),binding.editText2.editText?.text.toString(),binding.editText3.editText?.text.toString(),binding.editText4.editText?.text.toString()
                ,binding.editText5.editText?.text.toString(), radio1.text.toString(), radio2.text.toString(), radio3.text.toString(),binding.spinner1.selectedItem.toString())
        }
    }
}