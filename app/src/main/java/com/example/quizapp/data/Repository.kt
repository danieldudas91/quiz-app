package com.example.quizapp.data

import android.content.Context
import com.example.quizapp.model.Question
import com.example.quizapp.model.QuestionWithAnswers

class Repository (private val context: Context){
    private val quizDao = QuizDatabaseBuilder
        .getINSTANCE(context)
        .quizDao()

     suspend fun getAllQuestionsWithAnswers(): List<QuestionWithAnswers> {
        return quizDao.getAllQuestionsWithAnswers()
    }

    fun addQuestionWithAnswers(question: Question){
        quizDao.addQuestionWithAnswers(question)
    }
}