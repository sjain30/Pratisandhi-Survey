package com.pratisandhi.survey.viewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.pratisandhi.survey.database.SurveyDatabase
import com.pratisandhi.survey.database.entity.SurveyEntity
import kotlinx.coroutines.launch

class SectionOneViewModel(application: Application) : AndroidViewModel(application) {

    fun addSurvey(name: String) {
        viewModelScope.launch {
            val survey = SurveyEntity(name,"","","","","","","","","","",
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