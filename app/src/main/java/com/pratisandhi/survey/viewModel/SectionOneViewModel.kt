package com.pratisandhi.survey.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.pratisandhi.survey.activities.Survey
import com.pratisandhi.survey.database.SurveyDatabase
import com.pratisandhi.survey.database.entity.SurveyEntity
import kotlinx.coroutines.launch

class SectionOneViewModel(application: Application) : AndroidViewModel(application) {

    fun addSurvey(name: String, email:String, contact:String, age:String, city:String, sex:String, gender:String,
    rural:String, status:String) {
        viewModelScope.launch {
            val survey = SurveyEntity(name,email,contact,age,city,sex,gender,rural,status,"","",
            "","","","","",
            "","","","",
            "","","",
            "","","","",
            "","","","",
            "","","","","",
            "","","",
            "","","","",
            "","","",""
                ,"","",""
                ,"","","","")
            SurveyDatabase(getApplication()).getSurveyDao().add(survey)
//            Toast.makeText(getApplication(), "Survey submitted", Toast.LENGTH_SHORT).show()
        }
    }

    fun getSurvey() : SurveyEntity? {
        var survey : SurveyEntity? = null
        viewModelScope.launch {
            val list = SurveyDatabase(getApplication()).getSurveyDao().getAnswers()
            val id = list[list.size - 1].id
            survey = SurveyDatabase(getApplication()).getSurveyDao().getSurvey(id)
        }
        return survey
    }

}