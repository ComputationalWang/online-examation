package com.example.onlineexamination

import com.example.onlineexamination.data.model.Exam
import java.util.Date
import java.util.*

object TestUtil {
    fun createExam() = Exam(
        title = "Test",
        createdAt = Calendar.getInstance().time as Date,
        lastModifiedAt = Calendar.getInstance().time as Date
    )
}