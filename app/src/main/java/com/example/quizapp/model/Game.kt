package com.example.quizapp.model

class Game (private val questions: List<QuestionWithAnswers>) {
    private val _questions: MutableList<QuestionWithAnswers> = getMutableQuestions()
    private lateinit var currentQuestion: QuestionWithAnswers
    private var answeredQuestions = 1

    private fun getMutableQuestions(): MutableList<QuestionWithAnswers> {
        return questions.filter { it.question.isProperQuestion }.shuffled().toMutableList()
    }

    fun getFirstQuestion(): QuestionWithAnswers{
        var firstQuestion = QuestionWithAnswers(Question(""), listOf())
        try{
            firstQuestion = _questions.first()
        }
        catch (e: NoSuchElementException){
            e.printStackTrace()
        }
        currentQuestion = firstQuestion
        return firstQuestion
    }

    fun getNextQuestion(): QuestionWithAnswers{
        _questions.remove(currentQuestion)
        var nextQuestion = QuestionWithAnswers(Question(""), listOf())
        try{
            nextQuestion = _questions.first()
        }
        catch(e: NoSuchElementException){
            e.printStackTrace()
        }
        currentQuestion = nextQuestion
        answeredQuestions++
        return nextQuestion
    }

}