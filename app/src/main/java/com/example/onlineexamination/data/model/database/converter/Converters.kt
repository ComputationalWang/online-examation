package com.example.onlineexamination.data.model.database.converter

import androidx.room.TypeConverter
import com.example.onlineexamination.data.model.ExamQuestion
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import org.json.JSONObject
import java.util.Date

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun fromExamQuestion(examQuestion: ExamQuestion): String {
        return Gson().toJson(examQuestion)
    }

    @TypeConverter
    fun toExamQuestion(json: String): ExamQuestion {
        val gson = Gson()
        return gson.fromJson(json, ExamQuestion::class.java)
    }

    @TypeConverter
    fun fromExamQuestions(examQuestions: List<ExamQuestion>): String {
        return Gson().toJson(examQuestions)
    }

    @TypeConverter
    fun toExamQuestions(json: String): List<ExamQuestion> {
        val itemsType = object : TypeToken<List<ExamQuestion>>() {}.type
        val gson = Gson()
        return gson.fromJson<List<ExamQuestion>?>(json, itemsType)
    }

}