package com.pratisandhi.survey.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.pratisandhi.survey.database.SurveyDatabase
import kotlinx.coroutines.launch

class SectionSevenViewModel(application: Application) : AndroidViewModel(application) {


    fun update(
        ques39: String,
        ques40: String,
        ques41: String,
        ques42: String,
        ques43: String,
        ques44: String,
        ques45: String,
        ques46: String,
        ques47: String,
        ques48: String,
        ques49: String,
        ques50: String,
        ques51: String,
        ques52: String,
        ques53: String,
        ques54: String
    ) {
        viewModelScope.launch {
            val list = SurveyDatabase(getApplication()).getSurveyDao().getAnswers()
            val id = list[list.size - 1].id
            SurveyDatabase(getApplication()).getSurveyDao().updateSeven(
                ques39, ques40, ques41, ques42, ques43, ques44, ques45, ques46, ques47,
                ques48, ques49, ques50, ques51, ques52, ques53, ques54, id
            )
        }
    }
}