package com.example.onlineexamination.data.model.database.examquestion

import androidx.lifecycle.ViewModel
import com.example.onlineexamination.data.model.ExamQuestion
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ExamQuestionViewModel(private val repository: ExamQuestionRepository) : ViewModel() {

    @OptIn(DelicateCoroutinesApi::class)
    fun insert(question: ExamQuestion) = GlobalScope.launch {
        repository.createExamQuestion(question)
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun delete(question: ExamQuestion) = GlobalScope.launch {
        repository.removeExamQuestion(question)
    }

    fun getAllQuestions() = repository.getAllQuestions()
}