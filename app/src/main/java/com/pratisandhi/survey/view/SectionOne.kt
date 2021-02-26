package com.pratisandhi.survey.view

import android.os.Bundle
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pratisandhi.survey.R
import com.pratisandhi.survey.activities.Survey
import com.pratisandhi.survey.databinding.FragmentSectionOneBinding
import com.pratisandhi.survey.utils.toast
import com.pratisandhi.survey.viewModel.SectionOneViewModel
import com.sample.viewbinding.fragment.viewBinding
import java.util.regex.Matcher
import java.util.regex.Pattern

class SectionOne : Fragment(R.layout.fragment_section_one) {

    private val binding: FragmentSectionOneBinding by viewBinding()
    private lateinit var viewModel: SectionOneViewModel
    private lateinit var radio1: RadioButton
    private lateinit var radio2: RadioButton
    private lateinit var radio3: RadioButton


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SectionOneViewModel::class.java)

        binding.next1.setOnClickListener {

            if (binding.editText1.editText?.text.isNullOrEmpty()) {
                binding.editText1.error = getString(R.string.blank)
                return@setOnClickListener
            }
            if (binding.editText2.editText?.text.isNullOrEmpty()) {
                binding.editText2.error = getString(R.string.blank)
                return@setOnClickListener
            }
            if (isEmailValid(binding.editText2.editText?.text.toString())) {
                binding.editText2.error = "Invalid Email"
                return@setOnClickListener
            }

            if (binding.editText3.editText?.text.isNullOrEmpty()) {
                binding.editText3.error = getString(R.string.blank)
                return@setOnClickListener
            }
            if (binding.editText4.editText?.text.isNullOrEmpty()) {
                binding.editText4.error = getString(R.string.blank)
                return@setOnClickListener
            }
            if (binding.editText5.editText?.text.isNullOrEmpty()) {
                binding.editText5.error = getString(R.string.blank)
                return@setOnClickListener
            }

            if (binding.radioGroup1.checkedRadioButtonId == -1 ||
                binding.radioGroup2.checkedRadioButtonId == -1 ||
                binding.radioGroup3.checkedRadioButtonId == -1
            ) {
                context?.toast(getString(R.string.unanswered))
                return@setOnClickListener
            }
            radio1 = view?.findViewById(binding.radioGroup1.checkedRadioButtonId)!!
            radio2 = view?.findViewById(binding.radioGroup2.checkedRadioButtonId)!!
            radio3 = view?.findViewById(binding.radioGroup3.checkedRadioButtonId)!!


            viewModel.addSurvey(
                binding.editText1.editText?.text.toString(),
                binding.editText2.editText?.text.toString(),
                binding.editText3.editText?.text.toString(),
                binding.editText4.editText?.text.toString(),
                binding.editText5.editText?.text.toString(),
                radio1.text.toString(),
                radio2.text.toString(),
                radio3.text.toString(),
                binding.spinner1.selectedItem.toString()
            )
        }

        (activity as Survey).binding.viewPager.currentItem += 1
    }

    fun isEmailValid(email: String?): Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern: Pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher: Matcher = pattern.matcher(email)
        return matcher.matches()
    }
}