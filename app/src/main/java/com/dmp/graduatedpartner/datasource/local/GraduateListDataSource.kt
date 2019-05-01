package com.dmp.graduatedpartner.datasource.local

import android.content.Context
import com.dmp.graduatedpartner.Application
import com.dmp.graduatedpartner.model.Graduate
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Single

class GraduateListDataSource {
    private val sharedPreference = Application.appContext?.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    private val editor by lazy { sharedPreference?.edit() }
    private val gson = Gson()

    fun put(key: String, content: List<Graduate>) =
        gson.toJson(content)?.let {
            editor?.putString(key, it)
            editor?.apply()
        }

    fun get(key: String): Single<List<Graduate>> =
        Single.create<List<Graduate>> { emitter ->
            emitter.onSuccess(sharedPreference?.getString(key, null)?.let {
                gson.fromJson<List<Graduate>>(it, (object : TypeToken<List<Graduate>>() {}).type
                )
            } ?: listOf())
        }

    companion object {
        const val FILE_NAME = "gp_graduate_list"
    }
}