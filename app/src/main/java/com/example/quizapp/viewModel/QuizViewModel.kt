package com.example.quizapp.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapp.data.Repository
import com.example.quizapp.model.Question
import com.example.quizapp.model.QuestionWithAnswers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class QuizViewModel(context: Context) : ViewModel() {
    private val repository = Repository(context)

     fun getAllQuestionsWithAnswers(): List<QuestionWithAnswers>? {
         var questionsData: List<QuestionWithAnswers>?
         runBlocking {
             questionsData = repository.getAllQuestionsWithAnswers()
         }
        return questionsData
    }
    fun addQuestionWithAnswers(question: Question) {
        viewModelScope.launch {
            try {
                repository.addQuestionWithAnswers(question)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}