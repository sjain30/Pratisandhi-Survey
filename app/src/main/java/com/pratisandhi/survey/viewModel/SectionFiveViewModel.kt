package com.pratisandhi.survey.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.pratisandhi.survey.database.SurveyDatabase
import com.pratisandhi.survey.database.entity.SurveyEntity
import kotlinx.coroutines.launch

class SectionFiveViewModel(application: Application) : AndroidViewModel(application) {

    fun add(surveyEntity: SurveyEntity){
        viewModelScope.launch {
            SurveyDatabase(getApplication()).getSurveyDao().add(surveyEntity)
        }
    }

    fun update(surveyEntity: SurveyEntity){
        viewModelScope.launch {
            SurveyDatabase(getApplication()).getSurveyDao().update(surveyEntity)
        }
    }
}