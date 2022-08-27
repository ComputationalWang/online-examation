package com.example.onlineexamination.data.model.database.examquestion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ExamQuestionViewModelFactory(private val repository: ExamQuestionRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ExamQuestionViewModel(repository) as T
    }
}