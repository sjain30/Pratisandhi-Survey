package com.pratisandhi.survey.viewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.pratisandhi.survey.database.SurveyDatabase
import kotlinx.coroutines.launch

class SectionTwoViewModel(application: Application) : AndroidViewModel(application) {

//    private val id : LiveData<Int>

    fun updateSurvey(age: String, age1: String) {
        viewModelScope.launch {
            val list = SurveyDatabase(getApplication()).getSurveyDao().getAnswers()
            val id = list[list.size - 1].id
            SurveyDatabase(getApplication()).getSurveyDao().updateTwo(age, age1, id)
            Toast.makeText(getApplication(), "Survey updated", Toast.LENGTH_SHORT).show()
        }
    }

//    private fun getId(): Int {
//        var id = 0
//        viewModelScope.launch {
//
//        }
//        return id
//    }

}