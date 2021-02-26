package com.pratisandhi.survey.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.pratisandhi.survey.database.SurveyDatabase
import kotlinx.coroutines.launch

class SectionFiveViewModel(application: Application) : AndroidViewModel(application) {

    fun update(ques32: String, ques33: String, ques34: String) {
        viewModelScope.launch {
            val list = SurveyDatabase(getApplication()).getSurveyDao().getAnswers()
            val id = list[list.size - 1].id
            SurveyDatabase(getApplication()).getSurveyDao().updateFive(ques32, ques33, ques34, id)
        }
    }
}