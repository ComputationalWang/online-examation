package com.example.onlineexamination.data.model.database.response

import com.example.onlineexamination.data.model.Exam

data class ExamResponse(var exams: List<Exam>? = null,
                        var exception: Exception? = null) {

}