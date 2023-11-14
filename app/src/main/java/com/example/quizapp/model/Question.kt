package com.example.quizapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions")
data class Question (
                     val questionString: String,

                     val answers: List<Answer>)
{
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
    companion object{
        const val MAX_NUMBER_OF_ANSWERS = 4
    }


    @ColumnInfo(name = "is_proper_question")
    var isProperQuestion: Boolean = determineIsProperQuestion()

    private fun determineIsProperQuestion(): Boolean{
        return hasFourAnswers() && hasOnlyOneCorrectAnswer()
    }

    private fun hasFourAnswers(): Boolean{
        return answers.size == MAX_NUMBER_OF_ANSWERS
    }

    private fun hasOnlyOneCorrectAnswer(): Boolean{
        return answers.filter{it.isTrueAnswer}.size == 1
    }
}