package com.example.onlineexamination.data.model.database.examquestion

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.onlineexamination.data.model.ExamQuestion

@Dao
interface ExamQuestionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(question: ExamQuestion)

    @Delete
    fun delete(question: ExamQuestion)

    @Query("SELECT * FROM exam_question")
    fun getAllExamQuestions(): List<ExamQuestion>

    @Query("SELECT * FROM exam_question WHERE id=:id")
    fun getExamQuestion(id: Int): ExamQuestion
}