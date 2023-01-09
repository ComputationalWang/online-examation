package com.example.onlineexamination

import com.example.onlineexamination.data.model.Exam
import com.example.onlineexamination.data.model.ExamQuestion
import java.util.Date
import java.util.*

object TestUtil {
    fun createExam() = Exam(
        title = "Test",
        createdAt = Calendar.getInstance().time as Date,
        author = "Herman",
        uid = "1",
        lastModifiedAt = Calendar.getInstance().time as Date,
        examQuestions = listOf(ExamQuestion(1, "ye", "ok"), (ExamQuestion(2, "ne", "no")))
    )
}