package com.example.quizapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions")
data class Question(
    @ColumnInfo(name = "question_string")
    val questionString: String,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "question_id")
    var questionId: Int? = null

    companion object {
        const val MAX_NUMBER_OF_ANSWERS = 4
    }


    @ColumnInfo(name = "is_proper_question")
    var isProperQuestion: Boolean = true
}