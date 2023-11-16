package com.example.quizapp.model

import androidx.room.Embedded
import androidx.room.Relation

data class QuestionWithAnswers(
    @Embedded val question: Question,
    @Relation(
        parentColumn = "question_id",
        entityColumn = "answer_id"
    )
    val answers: List<Answer>
)