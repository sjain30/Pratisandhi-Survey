package com.pratisandhi.survey.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.pratisandhi.survey.database.SurveyDatabase
import kotlinx.coroutines.launch

class SectionSixViewModel(application: Application) : AndroidViewModel(application) {

    fun update(ques35: String, ques36: String, ques37: String, ques38: String) {
        viewModelScope.launch {
            val list = SurveyDatabase(getApplication()).getSurveyDao().getAnswers()
            val id = list[list.size - 1].id
            SurveyDatabase(getApplication()).getSurveyDao()
                .updateSix(ques35, ques36, ques37, ques38, id)
        }
    }
}