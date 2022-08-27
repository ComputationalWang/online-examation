package com.example.onlineexamination.data.model.database.examquestion

import androidx.lifecycle.ViewModel
import com.example.onlineexamination.data.model.ExamQuestion
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ExamQuestionViewModel(private val repository: ExamQuestionRepository) : ViewModel() {

    fun insert(question: ExamQuestion) = GlobalScope.launch {
        repository.insert(question)
    }

    fun delete(question: ExamQuestion) = GlobalScope.launch {
        repository.delete(question)
    }

    fun getAllQuestions() = repository.getAllQuestions()
}