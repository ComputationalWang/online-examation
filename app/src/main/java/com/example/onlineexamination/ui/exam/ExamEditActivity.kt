package com.example.onlineexamination.ui.exam

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.onlineexamination.data.model.Exam
import com.example.onlineexamination.data.model.SavedPreference
import com.example.onlineexamination.data.model.database.examquestion.ExamQuestionRepository
import com.google.firebase.firestore.FirebaseFirestore

class ExamEditActivity : AppCompatActivity() {

    var id: Int = 0
    private var db: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    private fun getData() {
        //      asynchronously retrieve all documents
        id = intent.getIntExtra("id", -1)
        val colRef = db.collection("exams").whereEqualTo("id", id).whereEqualTo("uid", SavedPreference.getId(this)).get()
//      future.get() blocks on response
        colRef.addOnSuccessListener { collection ->
            for (document in collection.documents) {
                Log.d(ContentValues.TAG, "${document.id} => ${document.data}")
                val ex = document.toObject(Exam::class.java)
            }
        }.addOnFailureListener {
            Log.d(ContentValues.TAG, "Error getting documents", it)
        }
    }
}