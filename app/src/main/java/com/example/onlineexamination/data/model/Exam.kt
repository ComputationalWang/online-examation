package com.example.onlineexamination.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "exam")
class Exam(

    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name="author")
    var author : String? = null,

    @ColumnInfo(name="uid")
    var uid : String? = null,

    @ColumnInfo(name = "created_at")
    var createdAt: Date? = null,

    @ColumnInfo(name = "last_modified_at")
    var lastModifiedAt: Date? = null,

    @ColumnInfo(name = "questions")
    var examQuestions: List<ExamQuestion>? = null

    ) {
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null

    override fun toString(): String {
        return "Exam: '$title'\nCreated at: $createdAt"
    }
}