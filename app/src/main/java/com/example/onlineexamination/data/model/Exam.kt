package com.example.onlineexamination.data.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "exam")
class Exam(
    @ColumnInfo(name = "title")
    var title: String,


    @ColumnInfo(name = "created_at")
    var createdAt: Date,

    @ColumnInfo(name = "last_modified_at")
    var lastModifiedAt: Date,

    ) {
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
}