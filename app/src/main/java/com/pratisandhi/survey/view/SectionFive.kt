package com.pratisandhi.survey.view

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pratisandhi.survey.R
import com.pratisandhi.survey.activities.Survey
import com.pratisandhi.survey.databinding.FragmentSectionFiveBinding
import com.pratisandhi.survey.utils.toast
import com.pratisandhi.survey.viewModel.SectionFiveViewModel
import com.sample.viewbinding.fragment.viewBinding

class SectionFive : Fragment(R.layout.fragment_section_five) {

    private val binding: FragmentSectionFiveBinding by viewBinding()
    private lateinit var viewModel: SectionFiveViewModel
    private lateinit var radio1: RadioButton
    private lateinit var radio2: RadioButton


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backFive.setOnClickListener {
            (activity as Survey).binding.viewPager.currentItem -= 1
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SectionFiveViewModel::class.java)

        binding.nextFive.setOnClickListener {

            var ans2 = ""
            if (binding.fiveAns3check1.isChecked)
                ans2 += "${binding.fiveAns3check1.text}|"
            if (binding.fiveAns3check2.isChecked)
                ans2 += "${binding.fiveAns3check2.text}|"
            if (binding.fiveAns3check3.isChecked)
                ans2 += "${binding.fiveAns3check3.text}|"
            if (binding.fiveAns3check4.isChecked)
                ans2 += "${binding.fiveAns3check4.text}|"
            if (binding.fiveAns3check5.isChecked)
                ans2 += "${binding.fiveAns3check5.text}|"
            if (binding.fiveAns3check6.isChecked)
                ans2 += "${binding.fiveAns3check6.text}|"
            if (binding.fiveAns3check7.isChecked)
                ans2 += "${binding.fiveAns3check7.text}|"
            if (binding.fiveAns3check8.isChecked)
                ans2 += "${binding.fiveAns3check8.text}|"
            if (binding.fiveAns3check9.isChecked)
                ans2 += "${binding.fiveAns3check9.text}"

            if (binding.fiveAns1.checkedRadioButtonId == -1 || binding.fiveAns2.checkedRadioButtonId == -1 || ans2.isEmpty()) {
                context?.toast(getString(R.string.unanswered))
                return@setOnClickListener
            }

            radio1 = view?.findViewById(binding.fiveAns1.checkedRadioButtonId)!!
            radio2 = view?.findViewById(binding.fiveAns2.checkedRadioButtonId)!!

            viewModel.update(radio1.text.toString(), radio2.text.toString(), ans2)

            (activity as Survey).binding.viewPager.currentItem += 1
        }


    }

}