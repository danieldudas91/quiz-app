package com.example.quizapp

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.model.Answer
import com.example.quizapp.model.Game
import com.example.quizapp.model.QuestionWithAnswers
import com.example.quizapp.viewModel.QuizViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = QuizViewModel(applicationContext)
        val questions = viewModel.getAllQuestionsWithAnswers()
        val game = questions?.let { Game(it) }
        setContent {
            if (game != null) {
                QuizComponent(game = game)
            }
        }
    }

    @Composable
    fun QuizComponent(game: Game){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val currentQuestionState = remember { mutableStateOf(game.getFirstQuestion()) }
            val currentQuestionValue = currentQuestionState.value
            Text(
                text = currentQuestionValue.question.questionString,
                fontSize = 24.sp,
                modifier = Modifier
                    .width(350.dp)
                    .padding(all = 10.dp)
                    .border(width = 1.dp, color = Color.Black, shape = CircleShape),
                textAlign = TextAlign.Center,
                )
            currentQuestionValue.answers.forEach { answer ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .width(200.dp)
                        .padding(all = 5.dp)
                        .border(width = 1.dp, color = Color.Black, shape = CircleShape),
                ) {
                    AnswerText(answer, currentQuestionState, game, applicationContext)
                }
            }
        }
    }

    @Composable
    fun AnswerText(answer: Answer,
                   currentQuestionState: MutableState<QuestionWithAnswers>,
                   game: Game,
                   context: Context
                   ){
        ClickableText(
            text = AnnotatedString(answer.answerString),
            style = TextStyle(fontSize = 24.sp),
            onClick = {
            if (answer.isTrueAnswer) {
                if (game.isAllAnswered()){
                    Toast.makeText(context, "You're winner", Toast.LENGTH_LONG).show()
                }
                else{
                    currentQuestionState.value = game.getNextQuestion()
                }
            } else {
                Toast.makeText(context, "Not true", Toast.LENGTH_LONG).show()
            }
        },
        )
    }
}