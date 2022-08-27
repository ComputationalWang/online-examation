package com.example.onlineexamination.data.model.database.exam;

import androidx.room.Embedded
import androidx.room.Relation
import com.example.onlineexamination.data.model.Exam
import com.example.onlineexamination.data.model.ExamQuestion


data class ExamWithQuestions (
        @Embedded val exam: Exam,
        @Relation(
            parentColumn = "id",
            entityColumn = "exam_id"
        )
        val questions: List<ExamQuestion>
)