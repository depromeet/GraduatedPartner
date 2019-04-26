package com.dmp.graduatedpartner.datasource.local

import android.content.Context
import com.dmp.graduatedpartner.Application
import com.dmp.graduatedpartner.model.UserGrade
import com.google.gson.Gson
import io.reactivex.Single

class UserGradeDataSource {
    private val sharedPreference = Application.appContext?.getSharedPreferences(
        FILE_NAME,
        Context.MODE_PRIVATE
    )
    private val editor by lazy { sharedPreference?.edit() }
    private val gson = Gson()

    fun put(key: String, content: UserGrade) =
        gson.toJson(content)?.let {
            editor?.putString(key, it)
            editor?.apply()
        }

    fun get(key: String) : Single<UserGrade> =
            Single.create<UserGrade> { emitter ->
                emitter.onSuccess(sharedPreference?.getString(key, null)?.let
                { gson.fromJson(it, UserGrade::class.java)} ?: UserGrade(null, null, null, null))
            }

    companion object {
        const val FILE_NAME = "gp_usergrade"
    }
}