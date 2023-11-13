package com.example.quizapp.model

class Question (val questionString: String, val answers: List<Answer>){
    companion object{
        const val MAX_NUMBER_OF_ANSWERS = 4
    }
}