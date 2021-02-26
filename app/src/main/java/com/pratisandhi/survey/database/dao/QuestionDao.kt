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
    suspend fun getAnswers():List<SurveyEntity>

    @Query("update SurveyEntity set ques10 =:value, ques11 =:value1 where id =:uid")
    suspend fun updateTwo(value: String,value1: String,uid:Int)
}