package com.example.onlineexamination

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.onlineexamination.data.model.Exam
import com.example.onlineexamination.data.model.database.ExamDatabase
import com.example.onlineexamination.data.model.database.exam.ExamDao
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class DatabaseTest {
    private lateinit var examDao: ExamDao
    private lateinit var db: ExamDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, ExamDatabase::class.java).build()
        examDao = db.getExamDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeExamAndReadInList() {
        val exam: Exam = TestUtil.createExam()
        examDao.insert(exam)
        val getAll: List<Exam> = (examDao.getAllExams())
        assert(getAll[0].title == "Test")
    }
}