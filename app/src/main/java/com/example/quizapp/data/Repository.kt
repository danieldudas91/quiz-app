package com.example.quizapp.data

import android.content.Context
import com.example.quizapp.model.Question

class Repository (private val context: Context){
    private val quizDao = QuizDatabaseBuilder
        .getINSTANCE(context)
        .quizDao()

    fun getAllQuestions(): List<Question>{
        return quizDao.getAllQuestions()
    }

    fun addQuestion(question: Question){
        quizDao.addQuestion(question)
    }
}