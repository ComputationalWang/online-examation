package com.example.onlineexamination.data.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ExamDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(question: ExamQuestion)

    @Delete
    suspend fun delete(question: ExamQuestion)

    @Query("SELECT * FROM exam_questions")
    fun getAllExamQuestions(): LiveData<List<ExamQuestion>>
}