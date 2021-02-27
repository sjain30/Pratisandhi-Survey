package com.pratisandhi.survey.view

import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pratisandhi.survey.R
import com.pratisandhi.survey.activities.Survey
import com.pratisandhi.survey.databinding.FragmentSectionOneBinding
import com.pratisandhi.survey.utils.toast
import com.pratisandhi.survey.viewModel.SectionOneViewModel
import com.sample.viewbinding.fragment.viewBinding

class SectionOne : Fragment(R.layout.fragment_section_one) {

    private val binding: FragmentSectionOneBinding by viewBinding()
    private lateinit var viewModel: SectionOneViewModel
    private lateinit var radio1: RadioButton
    private lateinit var radio2: RadioButton
    private lateinit var radio3: RadioButton

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(SectionOneViewModel::class.java)

        binding.editText1.editText?.doAfterTextChanged { binding.editText1.error = null }
        binding.editText2.editText?.doAfterTextChanged { binding.editText2.error = null }
        binding.editText3.editText?.doAfterTextChanged { binding.editText3.error = null }
        binding.editText4.editText?.doAfterTextChanged { binding.editText4.error = null }
        binding.editText5.editText?.doAfterTextChanged { binding.editText5.error = null }

        // This overrides the radiogroup onCheckListener
        binding.radioGroup2.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            // This will get the radiobutton that has changed in its check state
            if (checkedId == R.id.radioButton14){
                binding.editTextOther.isEnabled = true
                binding.editTextOther.requestFocus()
            }
            else {
                binding.editTextOther.isEnabled = false
                binding.editTextOther.setText("")
            }
        })

        binding.next1.setOnClickListener {

            if (binding.editText1.editText?.text.isNullOrEmpty()) {
                binding.editText1.error = getString(R.string.blank)
                binding.editText1.requestFocus()
                return@setOnClickListener
            }
            if (binding.editText2.editText?.text.isNullOrEmpty()) {
                binding.editText2.error = getString(R.string.blank)
                binding.editText2.requestFocus()
                return@setOnClickListener
            }
            if (!isEmailValid(binding.editText2.editText?.text.toString())) {
                binding.editText2.error = "Invalid Email"
                binding.editText2.requestFocus()
                return@setOnClickListener
            }

            if (binding.editText3.editText?.text.isNullOrEmpty()) {
                binding.editText3.error = getString(R.string.blank)
                binding.editText3.requestFocus()
                return@setOnClickListener
            }

            if (binding.editText3.editText?.text?.length != 10) {
                binding.editText3.error = "Number should be of 10 digits"
                binding.editText3.requestFocus()
                return@setOnClickListener
            }

            if (binding.editText4.editText?.text.isNullOrEmpty()) {
                binding.editText4.error = getString(R.string.blank)
                binding.editText4.requestFocus()
                return@setOnClickListener
            }
            if (binding.editText5.editText?.text.isNullOrEmpty()) {
                binding.editText5.error = getString(R.string.blank)
                binding.editText5.requestFocus()
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

            val otherGender = if (binding.radioGroup2.checkedRadioButtonId == R.id.radioButton14)
                binding.editTextOther.text.toString()
            else
                radio2.text.toString()
//            context?.let { it1 ->
//                viewModel.getSurvey().observe(viewLifecycleOwner,{
//                    Log.i("TAG", "onActivityCreated: ${it.ques10}")
//                    if (it.ques10.isNotEmpty()) {
//                        viewModel.updateSurvey(
//                            binding.editText1.editText?.text.toString(),
//                            binding.editText2.editText?.text.toString(),
//                            binding.editText3.editText?.text.toString(),
//                            binding.editText4.editText?.text.toString(),
//                            binding.editText5.editText?.text.toString(),
//                            radio1.text.toString(),
//                            radio2.text.toString(),
//                            radio3.text.toString(),
//                            binding.spinner1.selectedItem.toString()
//                        )
//                    } else {
//                        viewModel.addSurvey(
//                            binding.editText1.editText?.text.toString(),
//                            binding.editText2.editText?.text.toString(),
//                            binding.editText3.editText?.text.toString(),
//                            binding.editText4.editText?.text.toString(),
//                            binding.editText5.editText?.text.toString(),
//                            radio1.text.toString(),
//                            radio2.text.toString(),
//                            radio3.text.toString(),
//                            binding.spinner1.selectedItem.toString())
//                    }
//                })
//            }

            viewModel.addSurvey(
                binding.editText1.editText?.text.toString(),
                binding.editText2.editText?.text.toString(),
                binding.editText3.editText?.text.toString(),
                binding.editText4.editText?.text.toString(),
                binding.editText5.editText?.text.toString(),
                radio1.text.toString(),
                otherGender,
                radio3.text.toString(),
                binding.spinner1.selectedItem.toString()
            )

            (activity as Survey).binding.viewPager.currentItem += 1
        }

    }

    private fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches()
    }
}