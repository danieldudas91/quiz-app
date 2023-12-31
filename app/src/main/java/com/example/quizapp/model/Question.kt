package com.example.quizapp.model

class Question (val questionString: String, val answers: List<Answer>){
    companion object{
        const val MAX_NUMBER_OF_ANSWERS = 4
    }

    var isProperQuestion: Boolean = determineIsProperQuestion()

    private fun determineIsProperQuestion(): Boolean{
        return hasFourAnswers() && hasOnlyOneCorrectAnswer()
    }

    private fun hasFourAnswers(): Boolean{
        return answers.size == MAX_NUMBER_OF_ANSWERS
    }

    private fun hasOnlyOneCorrectAnswer(): Boolean{
        return answers.filter{it.isTrueAnswer}.size == 1
    }
}