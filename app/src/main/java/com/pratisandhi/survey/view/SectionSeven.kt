package com.pratisandhi.survey.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pratisandhi.survey.R
import com.pratisandhi.survey.viewModel.SectionSevenViewModel

class SectionSeven : Fragment() {

    companion object {
        fun newInstance() = SectionSeven()
    }

    private lateinit var viewModel: SectionSevenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_section_seven, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SectionSevenViewModel::class.java)
        // TODO: Use the ViewModel
    }

}