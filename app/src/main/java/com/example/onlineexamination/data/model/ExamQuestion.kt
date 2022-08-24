package com.example.onlineexamination.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exam_questions")
data class ExamQuestion(

    @ColumnInfo(name = "questionName")
    var questionName: String,

    @ColumnInfo(name = "answer")
    var questionAnswer: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
}
