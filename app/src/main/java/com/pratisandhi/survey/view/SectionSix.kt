package com.pratisandhi.survey.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pratisandhi.survey.R
import com.pratisandhi.survey.viewModel.SectionSixViewModel

class SectionSix : Fragment() {

    companion object {
        fun newInstance() = SectionSix()
    }

    private lateinit var viewModel: SectionSixViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_section_six, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SectionSixViewModel::class.java)
        // TODO: Use the ViewModel
    }

}