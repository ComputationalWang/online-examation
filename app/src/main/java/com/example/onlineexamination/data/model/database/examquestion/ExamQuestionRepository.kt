package com.example.onlineexamination.data.model.database.examquestion

import com.example.onlineexamination.data.model.ExamQuestion
import com.example.onlineexamination.data.model.database.ExamDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExamQuestionRepository @Inject constructor(private val examQuestionDao: ExamQuestionDao) {

    suspend fun createExamQuestion(question: ExamQuestion) {
        examQuestionDao.insert(question)
    }
    suspend fun removeExamQuestion(question: ExamQuestion) {
        examQuestionDao.delete(question)
    }

    fun getAllQuestions() = examQuestionDao.getAllExamQuestions()

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: ExamQuestionRepository? = null

        fun getInstance(examQuestionDao: ExamQuestionDao) =
            instance ?: synchronized(this) {
                instance ?: ExamQuestionRepository(examQuestionDao).also { instance = it }
            }
    }
}