package com.dmp.graduatedpartner.datasource.local

import android.content.Context
import com.dmp.graduatedpartner.Application
import com.dmp.graduatedpartner.model.Course
import com.google.gson.Gson
import io.reactivex.Single

class CourseDataSource {
    private val sharedPreference = Application.appContext?.getSharedPreferences(
        FILE_NAME,
        Context.MODE_PRIVATE
    )
    private val editor by lazy { sharedPreference?.edit() }
    private val gson = Gson()

    fun put(key: String, content: Course) =
        gson.toJson(content)?.let {
            editor?.putString(key, it)
            editor?.apply()
        }

    fun get(key: String) : Single<Course> =
            Single.create<Course> { emitter ->
                emitter.onSuccess(sharedPreference?.getString(key, null)?.let
                { gson.fromJson(it, Course::class.java)} ?: Course(null, null, null, null))
            }

    companion object {
        const val FILE_NAME = "gp_usergrade"
    }
}