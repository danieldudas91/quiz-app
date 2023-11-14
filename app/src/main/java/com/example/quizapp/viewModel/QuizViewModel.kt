package com.example.quizapp.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapp.data.Repository
import com.example.quizapp.model.Question
import kotlinx.coroutines.launch

class QuizViewModel(context: Context) : ViewModel() {
    private val repository = Repository(context)
    val questions = getAllQuestions()

    private fun getAllQuestions(): List<Question>{
        var questions = listOf<Question>()
        viewModelScope.launch {
            try{
                questions = repository.getAllQuestions()
            }
            catch(e: Exception){
                e.printStackTrace()
            }
        }
        return questions
    }

    fun addQuestion(question: Question){
        viewModelScope.launch {
            try{
                repository.addQuestion(question)
            }
            catch(e: Exception){
                e.printStackTrace()
            }
        }
    }
}