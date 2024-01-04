package com.example.quizapp

import android.graphics.drawable.shapes.RoundRectShape
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.quizapp.model.Game
import com.example.quizapp.viewModel.QuizViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = QuizViewModel(applicationContext)
        val questions = viewModel.getAllQuestionsWithAnswers()
        val game = questions?.let { Game(it) }
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val context = applicationContext
                val currentQuestionState = remember { mutableStateOf(game?.getFirstQuestion()) }
                val currentQuestionValue = currentQuestionState.value
                Text(
                    text = currentQuestionValue!!.question.questionString,
                    modifier = Modifier
                        .width(300.dp)
                        .padding(all = 10.dp)
                        .border(width = 1.dp, color = Color.Black, shape = CircleShape),
                    textAlign = TextAlign.Center,

                )
                currentQuestionValue.answers.forEach { answer ->
                    Box(
                        modifier = Modifier
                            .width(100.dp)
                            .padding(all = 5.dp)
                            .border(width = 1.dp, color = Color.Black, shape = CircleShape)
                    ) {
                        ClickableText(
                            text = AnnotatedString(answer.answerString),
                            onClick = {
                                if (answer.isTrueAnswer) {
                                    currentQuestionState.value = game!!.getNextQuestion()
                                } else {
                                    Toast.makeText(context, "Not true", Toast.LENGTH_LONG).show()
                                }
                            },
                            modifier = Modifier
                                .align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}