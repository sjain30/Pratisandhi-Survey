package com.pratisandhi.survey.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pratisandhi.survey.R
import com.pratisandhi.survey.viewModel.SectionFiveViewModel

class SectionFive : Fragment() {

    companion object {
        fun newInstance() = SectionFive()
    }

    private lateinit var viewModel: SectionFiveViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_section_five, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SectionFiveViewModel::class.java)
        // TODO: Use the ViewModel
    }

}