package com.example.onlineexamination.data.model.database.exam

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.onlineexamination.data.model.Exam
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ExamViewModel(private val repository: ExamRepository = ExamRepository(), uid: String, examId: String? = null) : ViewModel() {

    fun insert(exam: Exam) = GlobalScope.launch {
//        repository.insert(exam)
    }

    fun delete(exam: Exam) = GlobalScope.launch {
//        repository.delete(exam)
    }


    val responseLiveData = liveData(Dispatchers.IO) {
            emit(repository.getResponseFromFirestoreUsingCoroutines(uid, examId))
    }

//    fun getAllQuestions() = repository.getAllExams()
}