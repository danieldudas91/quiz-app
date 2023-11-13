package com.example.quizapp.model

class Game (private val questions: List<Question>) {
    private val _questions: MutableList<Question> = getMutableQuestions()
    private lateinit var  currentQuestion: Question


    private fun getMutableQuestions(): MutableList<Question> {
        return questions.filter { it.isProperQuestion }.shuffled().toMutableList()
    }
}