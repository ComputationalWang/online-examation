package com.example.onlineexamination.data.model.database.exam

import androidx.room.ColumnInfo
import java.util.*

class ExamPost (
    var title: String,
    var author : String,
    var uid : String,
    var createdAt: Date,
    var lastModifiedAt: Date
) {

}