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

    @Query("update SurveyEntity set ques10 =:value, ques11 =:value1, ques12 =:value2, ques13 =:value3, ques14 =:value4, ques15 =:value5, ques16 =:value6, ques17 =:value7, ques18 =:value8 where id =:uid")
    suspend fun updateTwo(value: String,value1: String, value2: String, value3: String, value4: String, value5: String, value6: String,
                          value7: String, value8: String, uid:Int)

    @Query("update SurveyEntity set ques19 =:value, ques20 =:value1, ques21 =:value2, ques22 =:value3, ques23 =:value4, ques24 =:value5, ques25 =:value6, ques26 =:value7, ques27 =:value8, ques28 =:value9, ques29 =:value10, ques30 =:value11, ques31 =:value12 where id =:uid")
    suspend fun updateThree(value: String,value1: String, value2: String, value3: String, value4: String, value5: String, value6: String,
                          value7: String, value8: String, value9: String, value10: String, value11: String, value12: String, uid:Int)
}