package com.pratisandhi.survey.view

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pratisandhi.survey.R
import com.pratisandhi.survey.activities.Survey
import com.pratisandhi.survey.databinding.FragmentSectionThreeBinding
import com.pratisandhi.survey.utils.toast
import com.pratisandhi.survey.viewModel.SectionThreeViewModel
import com.sample.viewbinding.fragment.viewBinding

class SectionThree : Fragment(R.layout.fragment_section_three) {

    private val binding: FragmentSectionThreeBinding by viewBinding()
    private lateinit var viewModel: SectionThreeViewModel
    private lateinit var radio1: RadioButton
    private lateinit var radio2: RadioButton
    private lateinit var radio3: RadioButton
    private lateinit var radio4: RadioButton
    private lateinit var radio5: RadioButton
    private lateinit var radio6: RadioButton
    private lateinit var radio7: RadioButton
    private lateinit var radio8: RadioButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(SectionThreeViewModel::class.java)

        binding.editText8.editText?.doAfterTextChanged { binding.editText8.error = null }

        binding.nextThree.setOnClickListener {


            if (binding.editText8.editText?.text.isNullOrEmpty()) {
                binding.editText8.error = getString(R.string.blank)
                return@setOnClickListener
            }

            radio1 = view.findViewById(binding.radioGroup9.checkedRadioButtonId)!!
            radio2 = view.findViewById(binding.radioGroup10.checkedRadioButtonId)!!
            radio3 = view.findViewById(binding.radioGroup11.checkedRadioButtonId)!!
            radio4 = view.findViewById(binding.radioGroup12.checkedRadioButtonId)!!
            radio5 = view.findViewById(binding.radioGroup13.checkedRadioButtonId)!!
            radio6 = view.findViewById(binding.radioGroup14.checkedRadioButtonId)!!
            radio7 = view.findViewById(binding.radioGroup15.checkedRadioButtonId)!!
            radio8 = view.findViewById(binding.radioGroup16.checkedRadioButtonId)!!

            var q20 = ""
            if (binding.check16.isChecked)
                q20 += binding.check16.text.toString() + " | "
            if (binding.check17.isChecked)
                q20 += binding.check17.text.toString() + " | "
            if (binding.check18.isChecked)
                q20 += binding.check18.text.toString() + " | "
            if (binding.check19.isChecked)
                q20 += binding.check19.text.toString() + " | "
            if (binding.check20.isChecked)
                q20 += binding.check20.text.toString()

            var q21 = ""
            if (binding.check21.isChecked)
                q21 += binding.check21.text.toString() + " | "
            if (binding.check22.isChecked)
                q21 += binding.check22.text.toString() + " | "
            if (binding.check23.isChecked)
                q21 += binding.check23.text.toString() + " | "
            if (binding.check24.isChecked)
                q21 += binding.check24.text.toString() + " | "
            if (binding.check25.isChecked)
                q21 += binding.check25.text.toString()

            var q24 = ""
            if (binding.check26.isChecked)
                q24 += binding.check26.text.toString() + " | "
            if (binding.check27.isChecked)
                q24 += binding.check27.text.toString() + " | "
            if (binding.check28.isChecked)
                q24 += binding.check28.text.toString() + " | "
            if (binding.check29.isChecked)
                q24 += binding.check29.text.toString() + " | "
            if (binding.check30.isChecked)
                q24 += binding.check30.text.toString()
            if (binding.check31.isChecked)
                q24 += binding.check31.text.toString() + " | "
            if (binding.check32.isChecked)
                q24 += binding.check32.text.toString() + " | "
            if (binding.check33.isChecked)
                q24 += binding.check33.text.toString() + " | "
            if (binding.check34.isChecked)
                q24 += binding.check34.text.toString() + " | "
            if (binding.check35.isChecked)
                q24 += binding.check35.text.toString()

            var q26 = ""
            if (binding.check36.isChecked)
                q26 += binding.check36.text.toString() + " | "
            if (binding.check37.isChecked)
                q26 += binding.check37.text.toString() + " | "
            if (binding.check38.isChecked)
                q26 += binding.check38.text.toString() + " | "
            if (binding.check39.isChecked)
                q26 += binding.check39.text.toString() + " | "
            if (binding.check40.isChecked)
                q26 += binding.check40.text.toString()
            if (binding.check41.isChecked)
                q26 += binding.check41.text.toString() + " | "
            if (binding.check42.isChecked)
                q26 += binding.check42.text.toString() + " | "
            if (binding.check43.isChecked)
                q26 += binding.check43.text.toString() + " | "
            if (binding.check44.isChecked)
                q26 += binding.check44.text.toString()

            if (binding.radioGroup9.checkedRadioButtonId == -1 ||
                binding.radioGroup10.checkedRadioButtonId == -1 ||
                binding.radioGroup11.checkedRadioButtonId == -1 ||
                binding.radioGroup12.checkedRadioButtonId == -1 ||
                binding.radioGroup13.checkedRadioButtonId == -1 ||
                binding.radioGroup14.checkedRadioButtonId == -1 ||
                binding.radioGroup15.checkedRadioButtonId == -1 ||
                binding.radioGroup16.checkedRadioButtonId == -1 ||
                q20.isEmpty() ||
                q21.isEmpty() ||
                q24.isEmpty() ||
                q26.isEmpty()
                    ) {
                context?.toast(getString(R.string.unanswered))
                return@setOnClickListener
            }


            viewModel.updateSurvey3(
                radio1.text.toString(),
                q20,
                q21,
                radio2.text.toString(),
                radio3.text.toString(),
                q24,
                radio4.text.toString(),
                q26,
                radio5.text.toString(),
                binding.editText8.editText?.text.toString(),
                radio6.text.toString(),
                radio7.text.toString(),
                radio8.text.toString()
            )

            (activity as Survey).binding.viewPager.currentItem += 1
        }

        binding.backThree.setOnClickListener {
            (activity as Survey).binding.viewPager.currentItem -= 1
        }
    }
}