package com.pratisandhi.survey.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.pratisandhi.survey.activities.Survey
import com.pratisandhi.survey.database.SurveyDatabase
import com.pratisandhi.survey.database.entity.SurveyEntity
import kotlinx.coroutines.launch

class SectionOneViewModel(application: Application) : AndroidViewModel(application) {

    private val survey = MutableLiveData<SurveyEntity>()

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

    fun updateSurvey(age: String, age1: String, ques12:String, ques13:String, ques14:String, ques15:String, ques16:String, ques17:String, ques18:String) {
        viewModelScope.launch {
            val list = SurveyDatabase(getApplication()).getSurveyDao().getAnswers()
            val id = list[list.size - 1].id
            SurveyDatabase(getApplication()).getSurveyDao().updateOne(age, age1,ques12,ques13,ques14,ques15,ques16,ques17,ques18, id)
//            Toast.makeText(getApplication(), "Survey updated", Toast.LENGTH_SHORT).show()
        }
    }

    fun getSurvey() : MutableLiveData<SurveyEntity> {
        viewModelScope.launch {
            val list = SurveyDatabase(getApplication()).getSurveyDao().getAnswers()
            val id = list[list.size - 1].id
            survey.postValue(SurveyDatabase(getApplication()).getSurveyDao().getSurvey(id))
        }
        return survey
    }

}