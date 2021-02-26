package com.pratisandhi.survey.viewModel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.pratisandhi.survey.database.SurveyDatabase
import kotlinx.coroutines.launch

class SectionThreeViewModel(application: Application) : AndroidViewModel(application) {

//    private val id : LiveData<Int>

    fun updateSurvey3(ques19: String, ques20: String, ques21:String, ques22:String, ques23:String, ques24:String, ques25:String,
                      ques26:String, ques27:String, ques28:String, ques29:String, ques30:String, ques31:String) {
        viewModelScope.launch {
            val list = SurveyDatabase(getApplication()).getSurveyDao().getAnswers()
            val id = list[list.size - 1].id
            Log.i("TAG", "updateSurvey3: $id")
            SurveyDatabase(getApplication()).getSurveyDao().updateThree(ques19, ques20, ques21, ques22, ques23, ques24, ques25, ques26,
                ques27, ques28, ques29, ques30, ques31, id)
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