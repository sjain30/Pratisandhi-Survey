package com.pratisandhi.survey.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pratisandhi.survey.database.dao.QuestionDao
import com.pratisandhi.survey.database.entity.SurveyEntity

@Database(
    entities = [SurveyEntity::class],
    version = 1
)
abstract class SurveyDatabase :RoomDatabase(){
    abstract fun getSurveyDao(): QuestionDao

    companion object {

        @Volatile
        private var instance: SurveyDatabase? = null

        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            SurveyDatabase::class.java,
            "SurveyDatabase"
        ).build()

    }
}
