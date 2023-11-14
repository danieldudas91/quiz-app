package com.example.quizapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.quizapp.model.Question

@Dao
interface QuizDao {
    @Query("SELECT * FROM questions")
    fun getAllQuestions(): List<Question>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addQuestion(question: Question)
}