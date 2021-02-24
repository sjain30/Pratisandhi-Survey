package com.pratisandhi.survey.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.pratisandhi.survey.database.entity.SurveyEntity


@Dao
interface QuestionDao {
    @Insert
    suspend fun add(surveyEntity: SurveyEntity)

    @Update
    suspend fun update(surveyEntity: SurveyEntity)

    @Query("select * from SurveyEntity")
    fun getAnswers():List<SurveyEntity>

}