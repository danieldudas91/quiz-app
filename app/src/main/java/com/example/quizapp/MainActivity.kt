package com.example.quizapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.AnnotatedString
import com.example.quizapp.model.Answer
import com.example.quizapp.model.Game
import com.example.quizapp.model.Question

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val firstQuestionAnswers = listOf(
            Answer("Sydney", false),
            Answer("Perth", false),
            Answer("Canberra", true),
            Answer("Melbourne", false)
        )
        val secondQuestionAnswers = listOf(
            Answer("Io", false),
            Answer("Phobos", true),
            Answer("Europa", false),
            Answer("Titan", false)
        )
        val questions = listOf(
            Question("What is the capital of Australia?", firstQuestionAnswers),
            Question("Which one of the following is one of Mars' moons?", secondQuestionAnswers)
        )
        setContent {
            Column {
                val game = Game(questions)
                val context = applicationContext
                val currentQuestion = remember { mutableStateOf(game.getFirstQuestion()) }
                Text(currentQuestion.value.questionString)
                currentQuestion.value.answers.forEach { answer ->
                    ClickableText(text = AnnotatedString(answer.answerString),
                        onClick = {
                            if (answer.isTrueAnswer) {
                                currentQuestion.value = game.getNextQuestion()
                            } else {
                                Toast.makeText(context, "Not true", Toast.LENGTH_LONG).show()
                            }
                        })
                }
            }
        }
    }
}