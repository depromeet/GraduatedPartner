package com.dmp.graduatedpartner.datasource.local

import android.content.Context.MODE_PRIVATE
import com.dmp.graduatedpartner.Application.Companion.appContext
import com.dmp.graduatedpartner.model.Graduate
import com.google.gson.Gson
import io.reactivex.Maybe
import io.reactivex.Single

class GraduateDataSource {
    private val sharedPreference = appContext?.getSharedPreferences(FILE_NAME, MODE_PRIVATE)
    private val editor by lazy { sharedPreference?.edit() }
    private val gson = Gson()

    fun put(key: String, content: Graduate) =
        gson.toJson(content)?.let {
            editor?.putString(key, it)
            editor?.apply()
        }

    fun get(key: String): Single<Graduate> =
        Maybe.create<Graduate> {
            sharedPreference?.getString(key, null)?.let { gson.fromJson(it, Graduate::class.java) }
        }.switchIfEmpty(Single.create<Graduate> { Graduate(null) })

    companion object {
        const val FILE_NAME = "gp_graduate"
    }
}