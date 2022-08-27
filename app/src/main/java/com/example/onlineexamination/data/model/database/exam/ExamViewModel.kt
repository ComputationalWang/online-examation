package com.example.onlineexamination.data.model.database.exam

import androidx.lifecycle.ViewModel
import com.example.onlineexamination.data.model.Exam
import com.example.onlineexamination.data.model.ExamQuestion
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ExamViewModel(private val repository: ExamRepository) : ViewModel() {

    fun insert(exam: Exam) = GlobalScope.launch {
        repository.insert(exam)
    }

    fun delete(exam: Exam) = GlobalScope.launch {
        repository.delete(exam)
    }

    fun getAllQuestions() = repository.getAllExams()
}