package com.example.onlineexamination.data.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.onlineexamination.data.model.Exam
import com.example.onlineexamination.data.model.ExamQuestion
import com.example.onlineexamination.data.model.database.converter.Converters
import com.example.onlineexamination.data.model.database.exam.ExamDao
import com.example.onlineexamination.data.model.database.examquestion.ExamQuestionDao

@Database(entities = [Exam::class, ExamQuestion::class], version = 1)
@TypeConverters(Converters::class)
abstract class ExamDatabase : RoomDatabase() {

    abstract fun getExamQuestionDao() : ExamQuestionDao
    abstract fun getExamDao() : ExamDao


    companion object {
        @Volatile
        private var instance : ExamDatabase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ExamDatabase::class.java,
                "Exam.db"
            ).build()
    }
}