package com.pratisandhi.survey.viewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
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
            Toast.makeText(getApplication(), "Survey submitted", Toast.LENGTH_SHORT).show()
        }
    }

}