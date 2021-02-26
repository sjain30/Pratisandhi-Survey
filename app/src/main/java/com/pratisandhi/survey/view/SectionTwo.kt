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
import com.pratisandhi.survey.databinding.FragmentSectionTwoBinding
import com.pratisandhi.survey.viewModel.SectionTwoViewModel
import com.sample.viewbinding.fragment.viewBinding

class SectionTwo : Fragment(R.layout.fragment_section_two) {

    private val binding: FragmentSectionTwoBinding by viewBinding()
    private lateinit var viewModel: SectionTwoViewModel
    private lateinit var radio1: RadioButton
    private lateinit var radio2: RadioButton
    private lateinit var radio3: RadioButton
    private lateinit var radio4: RadioButton
    private lateinit var radio5: RadioButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_section_two, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SectionTwoViewModel::class.java)

        binding.nextTwo.setOnClickListener {
            radio1 = view?.findViewById(binding.radioGroup4.checkedRadioButtonId)!!
            radio2 = view?.findViewById(binding.radioGroup5.checkedRadioButtonId)!!
            radio3 = view?.findViewById(binding.radioGroup6.checkedRadioButtonId)!!
            radio4 = view?.findViewById(binding.radioGroup7.checkedRadioButtonId)!!
            radio5 = view?.findViewById(binding.radioGroup8.checkedRadioButtonId)!!

            var q14 = ""
            if (binding.check1.isChecked)
                    q14+= binding.check1.text.toString() + " | "
            if (binding.check2.isChecked)
                q14+= binding.check2.text.toString() + " | "
            if (binding.check3.isChecked)
                q14+= binding.check3.text.toString() + " | "
            if (binding.check4.isChecked)
                q14+= binding.check4.text.toString() + " | "
            if (binding.check5.isChecked)
                q14+= binding.check5.text.toString() + " | "
            if (binding.check6.isChecked)
                q14+= binding.check6.text.toString() + " | "
            if (binding.check7.isChecked)
                q14+= binding.check7.text.toString() + " | "
            if (binding.check8.isChecked)
                q14+= binding.check8.text.toString() + " | "
            if (binding.check9.isChecked)
                q14+= binding.check9.text.toString() + " | "
            if (binding.check10.isChecked)
                q14+= binding.check10.text.toString()

            var q17 = ""
            if (binding.check11.isChecked)
                q17+= binding.check11.text.toString() + " | "
            if (binding.check12.isChecked)
                q17+= binding.check12.text.toString() + " | "
            if (binding.check13.isChecked)
                q17+= binding.check13.text.toString() + " | "
            if (binding.check14.isChecked)
                q17+= binding.check14.text.toString()

            (activity as Survey).binding.viewPager.currentItem += 1
            viewModel.updateSurvey(binding.editText10.editText?.text.toString(), binding.editText11.editText?.text.toString(), radio1.text.toString(),
                radio2.text.toString(),q14,radio3.text.toString(),radio4.text.toString(),q17,radio5.text.toString())
        }

        binding.backTwo.setOnClickListener {
            (activity as Survey).binding.viewPager.currentItem -= 1
        }
    }
}