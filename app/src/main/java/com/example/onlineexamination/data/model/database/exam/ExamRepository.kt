package com.example.onlineexamination.data.model.database.exam

import android.content.Context
import com.example.onlineexamination.data.model.Exam
import com.example.onlineexamination.data.model.SavedPreference
import com.example.onlineexamination.data.model.database.response.ExamResponse
import com.example.onlineexamination.data.model.database.response.FirebaseCallback
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

//class ExamRepository(private val db: ExamDatabase) {
class ExamRepository(
    private val rootRef: FirebaseFirestore = FirebaseFirestore.getInstance(),
    private val examRef: CollectionReference = rootRef.collection("exams")
) {
//    suspend fun insert(exam: Exam) = db.getExamDao().insert(exam)
//    suspend fun delete(exam: Exam) = db.getExamDao().delete(exam)
//
//    fun getAllExams() = db.getExamDao().getAllExams()
    suspend fun getResponseFromFirestoreUsingCoroutines(uid: String, examId: String? = null): ExamResponse {
        val response = ExamResponse()
        try {
            if (examId != null) {
                response.exams = examRef.whereEqualTo("uid", uid).whereEqualTo("id", examId).get().await().documents.mapNotNull { snapShot ->
                    snapShot.toObject(Exam::class.java)
                }
            } else {
                response.exams = examRef.whereEqualTo("uid", uid).get().await().documents.mapNotNull { snapShot ->
                    snapShot.toObject(Exam::class.java)
                }
            }
        } catch (exception: Exception) {
            response.exception = exception
        }
        return response
    }
}