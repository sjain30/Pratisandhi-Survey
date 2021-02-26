package com.pratisandhi.survey.viewModel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.pratisandhi.survey.database.SurveyDatabase
import com.pratisandhi.survey.database.entity.SurveyEntity
import kotlinx.coroutines.launch

class SectionTwoViewModel(application: Application) : AndroidViewModel(application) {

//    private val id : LiveData<Int>

    fun updateSurvey(age: String, age1: String) {
        val id = 1
        viewModelScope.launch {
//            id = SurveyDatabase(getApplication()).getSurveyDao().getAnswers().let {
//                it[it.size-1].id
//                Log.i("TAG", "getId: $id")
//            }
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