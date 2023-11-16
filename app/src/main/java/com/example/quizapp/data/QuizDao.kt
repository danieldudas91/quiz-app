package com.example.quizapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.quizapp.model.Question
import com.example.quizapp.model.QuestionWithAnswers

@Dao
interface QuizDao {
    @Query("SELECT * FROM questions")
    fun getAllQuestions(): List<Question>

    @Transaction
    @Query("SELECT * FROM questions")
    suspend fun getAllQuestionsWithAnswers(): List<QuestionWithAnswers>

    @Transaction
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addQuestionWithAnswers(question: Question)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addQuestion(question: Question)
}