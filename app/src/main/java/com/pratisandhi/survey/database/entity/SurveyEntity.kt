package com.pratisandhi.survey.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class SurveyEntity(
    val ques1: String,
    val ques2: String,
    val ques3: String,
    val ques4: String,
    val ques5: String,
    val ques6: String,
    val ques7: String,
    val ques9: String,
    val ques10: String,
    val ques11: String,
    val ques12: String,
    val ques13: String,
    val ques14: String,
    val ques15: String,
    val ques16: String,
    val ques17: String,
    val ques18: String,
    val ques19: String,
    val ques20: String,
    val ques21: String,
    val ques22: String,
    val ques23: String,
    val ques24: String,
    val ques25: String,
    val ques26: String,
    val ques27: String,
    val ques28: String,
    val ques29: String,
    val ques30: String,
    val ques31: String,
    val ques32: String,
    val ques33: String,
    val ques34: String,
    val ques35: String,
    val ques36: String,
    val ques37: String,
    val ques38: String,
    val ques39: String,
    val ques40: String,
    val ques41: String,
    val ques42: String,
    val ques43: String,
    val ques44: String,
    val ques45: String,
    val ques46: String,
    val ques47: String,
    val ques48: String,
    val ques49: String,
    val ques50: String,
    val ques51: String,
    val ques52: String,
    val ques53: String,
    val ques54: String,

    ) {
    @PrimaryKey( autoGenerate = true )
    var id:Int = 0
}