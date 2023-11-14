package com.example.quizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

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
        }
    }
}
