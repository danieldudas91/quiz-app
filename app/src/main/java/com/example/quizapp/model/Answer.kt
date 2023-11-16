package com.example.quizapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "answers")
class Answer (@ColumnInfo(name = "answer_string")
              val answerString: String,
              @ColumnInfo(name = "is_true_answer")
              val isTrueAnswer:Boolean,
              @ColumnInfo(name = "question_id")
              var questionId: Int? = null
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "answer_id")
    var answerId: Int? = null
}
