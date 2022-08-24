package com.example.onlineexamination.data.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ExamQuestion::class], version = 1)
abstract class ExamDatabase : RoomDatabase() {
    //TODO FIll class
}