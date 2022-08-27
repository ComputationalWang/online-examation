package com.example.onlineexamination.data.model.database.examquestion

import com.example.onlineexamination.data.model.ExamQuestion
import com.example.onlineexamination.data.model.database.ExamDatabase

class ExamQuestionRepository(private val db: ExamDatabase) {

    suspend fun insert(question: ExamQuestion) = db.getExamQuestionDao().insert(question)
    suspend fun delete(question: ExamQuestion) = db.getExamQuestionDao().delete(question)

    fun getAllQuestions() = db.getExamQuestionDao().getAllExamQuestions()
}