package com.example.quizapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.quizapp.model.Answer
import com.example.quizapp.model.Question

@Database(entities = [Question::class, Answer::class], version = 2)
abstract class QuizDatabase: RoomDatabase() {
    abstract fun quizDao(): QuizDao
}