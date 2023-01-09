package com.example.onlineexamination.data.model.database.exam

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class ExamViewModelFactory(private var uid: String, private var examId: String? = null) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ExamViewModel::class.java)) {
            return ExamViewModel(uid = uid, examId = examId) as T
        }
        throw IllegalArgumentException("ViewModel class not found")
    }
}