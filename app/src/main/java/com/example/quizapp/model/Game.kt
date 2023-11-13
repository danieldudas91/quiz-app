package com.example.quizapp.model

class Game (private val questions: List<Question>) {
    private val _questions: MutableList<Question> = getMutableQuestions()
    private lateinit var  currentQuestion: Question

    private fun getMutableQuestions(): MutableList<Question> {
        return questions.filter { it.isProperQuestion }.shuffled().toMutableList()
    }

    fun getFirstQuestion(): Question{
        val firstQuestion = try{
            _questions.first()
        }
        catch (e: NoSuchElementException){
            e.printStackTrace()
        }
        currentQuestion = firstQuestion as Question
        return firstQuestion
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