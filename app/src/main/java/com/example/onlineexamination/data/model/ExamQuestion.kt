package com.example.onlineexamination.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exam_question")
data class ExamQuestion(

    @ColumnInfo(name = "exam_id")
    var examId: Int?,

    @ColumnInfo(name = "question_name")
    var questionName: String,

    @ColumnInfo(name = "answer")
    var questionAnswer: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
}
