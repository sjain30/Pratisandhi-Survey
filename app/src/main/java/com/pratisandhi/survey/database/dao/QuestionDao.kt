package com.pratisandhi.survey.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pratisandhi.survey.database.entity.SurveyEntity


@Dao
interface QuestionDao {
    @Insert
    suspend fun add(surveyEntity: SurveyEntity)

    @Query("select * from SurveyEntity")
    suspend fun getAnswers(): List<SurveyEntity>

    @Query("select * from SurveyEntity where id =:uid")
    suspend fun getSurvey(uid:Int): SurveyEntity

    @Query("update SurveyEntity set ques1 =:value, ques2 =:value1, ques3 =:value2, ques4 =:value3, ques5 =:value4, ques6 =:value5, ques7 =:value6, ques8 =:value7, ques9 =:value8 where id =:uid")
    suspend fun updateOne(
        value: String,
        value1: String,
        value2: String,
        value3: String,
        value4: String,
        value5: String,
        value6: String,
        value7: String,
        value8: String,
        uid: Int
    )

    @Query("update SurveyEntity set ques10 =:value, ques11 =:value1, ques12 =:value2, ques13 =:value3, ques14 =:value4, ques15 =:value5, ques16 =:value6, ques17 =:value7, ques18 =:value8 where id =:uid")
    suspend fun updateTwo(
        value: String,
        value1: String,
        value2: String,
        value3: String,
        value4: String,
        value5: String,
        value6: String,
        value7: String,
        value8: String,
        uid: Int
    )

    @Query("update SurveyEntity set ques19 =:value, ques20 =:value1, ques21 =:value2, ques22 =:value3, ques23 =:value4, ques24 =:value5, ques25 =:value6, ques26 =:value7, ques27 =:value8, ques28 =:value9, ques29 =:value10, ques30 =:value11, ques31 =:value12 where id =:uid")
    suspend fun updateThree(
        value: String,
        value1: String,
        value2: String,
        value3: String,
        value4: String,
        value5: String,
        value6: String,
        value7: String,
        value8: String,
        value9: String,
        value10: String,
        value11: String,
        value12: String,
        uid: Int
    )

    @Query("update SurveyEntity set ques32 =:value, ques33 =:value1, ques34 =:value2 where id =:uid")
    suspend fun updateFive(value: String, value1: String, value2: String, uid: Int)

    @Query("update SurveyEntity set ques35 =:value, ques36 =:value1, ques37 =:value2, ques38 =:value3 where id =:uid")
    suspend fun updateSix(value: String, value1: String, value2: String, value3: String, uid: Int)

    @Query("update SurveyEntity set ques39 =:value, ques40 =:value1, ques41 =:value2, ques42 =:value3, ques43 =:value4, ques44 =:value5, ques45 =:value6, ques46 =:value7, ques47 =:value8, ques48 =:value9, ques49 =:value10, ques50 =:value11, ques51 =:value12, ques52 =:value13, ques53 =:value14, ques54 =:value15 where id =:uid")
    suspend fun updateSeven(
        value: String,
        value1: String,
        value2: String,
        value3: String,
        value4: String,
        value5: String,
        value6: String,
        value7: String,
        value8: String,
        value9: String,
        value10: String,
        value11: String,
        value12: String,
        value13: String,
        value14: String,
        value15: String,
        uid: Int
    )
}