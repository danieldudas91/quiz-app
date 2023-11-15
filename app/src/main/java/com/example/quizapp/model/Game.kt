package com.example.quizapp.model

class Game (private val questions: List<Question>) {
    private val _questions: MutableList<Question> = getMutableQuestions()
    private lateinit var  currentQuestion: Question

    private fun getMutableQuestions(): MutableList<Question> {
        return questions.filter { it.isProperQuestion }.shuffled().toMutableList()
    }

    fun getFirstQuestion(): Question{
        var currentQuestion = Question("", listOf())
        try{
            currentQuestion = _questions.first()
        }
        catch (e: NoSuchElementException){
            e.printStackTrace()
        }
        return currentQuestion
    }

    fun getNextQuestion(): Question{
        _questions.remove(currentQuestion)
        var nextQuestion = Question("", listOf())
        try{
            nextQuestion = _questions.first()
        }
        catch(e: NoSuchElementException){
            e.printStackTrace()
        }
        currentQuestion = nextQuestion
        return  nextQuestion
    }

}