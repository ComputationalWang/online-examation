package com.example.onlineexamination.data.model.database.exam

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ExamViewModelFactory(private val repository: ExamRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ExamViewModel(repository) as T
    }
}