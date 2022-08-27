package com.example.onlineexamination.data.model.database.exam

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.onlineexamination.data.model.Exam
import com.example.onlineexamination.data.model.ExamQuestion

@Dao
interface ExamDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(question: Exam)

    @Delete
    fun delete(question: Exam)

    @Query("SELECT * FROM exam")
    fun getAllExams(): List<Exam>
}