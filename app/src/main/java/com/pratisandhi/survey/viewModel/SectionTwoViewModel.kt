package com.pratisandhi.survey.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.pratisandhi.survey.database.SurveyDatabase
import kotlinx.coroutines.launch

class SectionTwoViewModel(application: Application) : AndroidViewModel(application) {

    fun updateSurvey(age: String, age1: String, ques12:String, ques13:String, ques14:String, ques15:String, ques16:String, ques17:String, ques18:String) {
        viewModelScope.launch {
            val list = SurveyDatabase(getApplication()).getSurveyDao().getAnswers()
            val id = list[list.size - 1].id
            SurveyDatabase(getApplication()).getSurveyDao().updateTwo(age, age1,ques12,ques13,ques14,ques15,ques16,ques17,ques18, id)
//            Toast.makeText(getApplication(), "Survey updated", Toast.LENGTH_SHORT).show()
        }
    }

}