package com.dmp.graduatedpartner.datasource.local

import android.content.Context.MODE_PRIVATE
import com.dmp.graduatedpartner.Application.Companion.appContext
import com.dmp.graduatedpartner.model.Grade
import com.google.gson.Gson

class GradeDataSource {
    private val sharedPreference = appContext?.getSharedPreferences(FILE_NAME, MODE_PRIVATE)
    private val editor by lazy { sharedPreference?.edit() }
    private val gson = Gson()

    fun put(key: String, content: Grade) =
        gson.toJson(content)?.let {
            editor?.putString(key, it)
            editor?.apply()
        }

    fun get(key: String): Grade? = sharedPreference?.getString(key, null)?.let { gson.fromJson(it, Grade::class.java) }

    companion object{
        const val FILE_NAME = "gp_grade"
    }
}