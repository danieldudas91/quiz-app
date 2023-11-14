package com.example.quizapp.data

import android.content.Context
import androidx.room.Room

object QuizDatabaseBuilder {
    private var INSTANCE: QuizDatabase? = null
    fun getINSTANCE(context: Context): QuizDatabase{
        if (INSTANCE == null){
            synchronized(QuizDatabase::class){
                INSTANCE = buildDatabase(context)
            }
        }
        return INSTANCE!!
    }
    private fun buildDatabase(context: Context): QuizDatabase{
        return Room.databaseBuilder(
            context.applicationContext,
            QuizDatabase::class.java,
            "quiz-database"
            )
            .build()
    }
}