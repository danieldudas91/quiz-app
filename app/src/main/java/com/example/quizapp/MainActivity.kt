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
import com.example.quizapp.model.Game
import com.example.quizapp.viewModel.QuizViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = QuizViewModel(applicationContext)
        val questions = viewModel.getAllQuestionsWithAnswers()
        val game = questions?.let { Game(it) }
        setContent {
            Column {
                val context = applicationContext
                val currentQuestionState = remember { mutableStateOf(game?.getFirstQuestion()) }
                val currentQuestionValue = currentQuestionState.value
                Text(currentQuestionValue!!.question.questionString)
                currentQuestionValue.answers.forEach { answer ->
                    ClickableText(text = AnnotatedString(answer.answerString),
                        onClick = {
                            if (answer.isTrueAnswer) {
                                currentQuestionState.value = game!!.getNextQuestion()
                            } else {
                                Toast.makeText(context, "Not true", Toast.LENGTH_LONG).show()
                            }
                        })
                }
            }
        }
    }
}