package com.example.onlineexamination.data.model.database.exam

import com.example.onlineexamination.data.model.Exam
import com.example.onlineexamination.data.model.database.ExamDatabase

class ExamRepository(private val db: ExamDatabase) {

    suspend fun insert(exam: Exam) = db.getExamDao().insert(exam)
    suspend fun delete(exam: Exam) = db.getExamDao().delete(exam)

    fun getAllExams() = db.getExamDao().getAllExams()
}