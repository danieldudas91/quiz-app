package com.example.quizapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "answers")
class Answer (val answerString: String,
              val isTrueAnswer:Boolean){
    @PrimaryKey(autoGenerate = true) val id: Int? = null
}
