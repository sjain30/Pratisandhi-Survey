package com.pratisandhi.survey.view

import android.os.Bundle
import android.widget.RadioButton
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pratisandhi.survey.R
import com.pratisandhi.survey.activities.Survey
import com.pratisandhi.survey.databinding.FragmentSectionSevenBinding
import com.pratisandhi.survey.utils.toast
import com.pratisandhi.survey.viewModel.SectionSevenViewModel
import com.sample.viewbinding.fragment.viewBinding

class SectionSeven : Fragment(R.layout.fragment_section_seven) {


    private val binding: FragmentSectionSevenBinding by viewBinding()
    private lateinit var viewModel: SectionSevenViewModel
    private lateinit var radio1: RadioButton
    private lateinit var radio2: RadioButton
    private lateinit var radio4: RadioButton
    private lateinit var radio6: RadioButton
    private lateinit var radio7: RadioButton
    private lateinit var radio8: RadioButton
    private lateinit var radio9: RadioButton
    private lateinit var radio10: RadioButton
    private lateinit var radio11: RadioButton
    private lateinit var radio12: RadioButton
    private lateinit var radio14: RadioButton
    private lateinit var radio15: RadioButton
    private lateinit var radio16: RadioButton

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SectionSevenViewModel::class.java)

        binding.sevenAns5.editText?.doAfterTextChanged { binding.sevenAns5.error = null }

        binding.nextSeven.setOnClickListener {

            if (binding.sevenAns5.editText?.text.isNullOrEmpty()) {
                binding.sevenAns5.error = getString(R.string.blank)
                binding.sevenAns5.requestFocus()
                return@setOnClickListener
            }
            if(!binding.checkAcknowledge.isChecked){
                binding.checkAcknowledge.error = "Please accept this acknowledgment"
                binding.checkAcknowledge.requestFocus()
                return@setOnClickListener
            }
            radio1 = view?.findViewById(binding.sevenAns1.checkedRadioButtonId)!!
            radio2 = view?.findViewById(binding.sevenAns2.checkedRadioButtonId)!!
            radio4 = view?.findViewById(binding.sevenAns4.checkedRadioButtonId)!!
            radio6 = view?.findViewById(binding.sevenAns6.checkedRadioButtonId)!!
            radio7 = view?.findViewById(binding.sevenAns7.checkedRadioButtonId)!!
            radio8 = view?.findViewById(binding.sevenAns8.checkedRadioButtonId)!!
            radio9 = view?.findViewById(binding.sevenAns9.checkedRadioButtonId)!!
            radio10 = view?.findViewById(binding.sevenAns10.checkedRadioButtonId)!!
            radio11 = view?.findViewById(binding.sevenAns11.checkedRadioButtonId)!!
            radio12 = view?.findViewById(binding.sevenAns12.checkedRadioButtonId)!!
            radio14 = view?.findViewById(binding.sevenAns14.checkedRadioButtonId)!!
            radio15 = view?.findViewById(binding.sevenAns15.checkedRadioButtonId)!!
            radio16 = view?.findViewById(binding.sevenAns16.checkedRadioButtonId)!!

            var ans = ""
            if (binding.sevenAns3check1.isChecked)
                ans += "${binding.sevenAns3check1.text}|"
            if (binding.sevenAns3check2.isChecked)
                ans += "${binding.sevenAns3check2.text}|"
            if (binding.sevenAns3check3.isChecked)
                ans += "${binding.sevenAns3check3.text}|"
            if (binding.sevenAns3check4.isChecked)
                ans += "${binding.sevenAns3check4.text}|"
            if (binding.sevenAns3check5.isChecked)
                ans += "${binding.sevenAns3check5.text}|"
            if (binding.sevenAns3check6.isChecked)
                ans += "${binding.sevenAns3check6.text}|"

            var ans1 = ""
            if (binding.sevenAns13check1.isChecked)
                ans1 += "${binding.sevenAns13check1.text}|"
            if (binding.sevenAns13check2.isChecked)
                ans1 += "${binding.sevenAns13check2.text}|"
            if (binding.sevenAns13check3.isChecked)
                ans1 += "${binding.sevenAns13check3.text}|"
            if (binding.sevenAns13check4.isChecked)
                ans1 += "${binding.sevenAns13check4.text}|"
            if (binding.sevenAns13check5.isChecked)
                ans1 += "${binding.sevenAns13check5.text}|"
            if (binding.sevenAns13check6.isChecked)
                ans1 += "${binding.sevenAns13check6.text}|"

            if (binding.sevenAns1.checkedRadioButtonId == -1 ||
                binding.sevenAns2.checkedRadioButtonId == -1 ||
                binding.sevenAns4.checkedRadioButtonId == -1 ||
                binding.sevenAns6.checkedRadioButtonId == -1 ||
                binding.sevenAns7.checkedRadioButtonId == -1 ||
                binding.sevenAns8.checkedRadioButtonId == -1 ||
                binding.sevenAns9.checkedRadioButtonId == -1 ||
                binding.sevenAns10.checkedRadioButtonId == -1 ||
                binding.sevenAns11.checkedRadioButtonId == -1 ||
                binding.sevenAns12.checkedRadioButtonId == -1 ||
                binding.sevenAns14.checkedRadioButtonId == -1 ||
                binding.sevenAns15.checkedRadioButtonId == -1 ||
                binding.sevenAns16.checkedRadioButtonId == -1 ||
                ans.isEmpty() ||
                ans1.isEmpty()
            ) {
                context?.toast(getString(R.string.unanswered))
                return@setOnClickListener
            }

            viewModel.update(
                radio1.text.toString(),
                radio2.text.toString(),
                ans,
                radio4.text.toString(),
                binding.sevenAns5.editText?.text.toString(),
                radio6.text.toString(),
                radio7.text.toString(),
                radio8.text.toString(),
                radio9.text.toString(),
                radio10.text.toString(),
                radio11.text.toString(),
                radio12.text.toString(),
                ans1,
                radio14.text.toString(),
                radio15.text.toString(),
                radio16.text.toString(),
            )

            context?.toast("Survey Submitted. Thank you!")
            (activity as Survey).finish()
        }

        binding.backSeven.setOnClickListener {
            (activity as Survey).binding.viewPager.currentItem -= 1
        }
    }

}