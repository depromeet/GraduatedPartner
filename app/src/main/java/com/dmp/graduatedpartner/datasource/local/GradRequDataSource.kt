package com.dmp.graduatedpartner.datasource.local

import android.content.Context
import com.dmp.graduatedpartner.Application
import com.dmp.graduatedpartner.model.GradRequ
import com.google.gson.Gson
import io.reactivex.Single

class GradRequDataSource {
    private val sharedPreference = Application.appContext?.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    private val editor by lazy { sharedPreference?.edit() }
    private val gson = Gson()

    fun put(key: String, content: GradRequ) =
        gson.toJson(content)?.let {
            editor?.putString(key, it)
            editor?.apply()
        }

    fun get(key: String): Single<GradRequ> =
        Single.create<GradRequ> { emitter ->
            emitter.onSuccess(sharedPreference?.getString(key, null)?.let { gson.fromJson(it, GradRequ::class.java) }
                ?: GradRequ(null, null, false))
        }

    companion object {
        const val FILE_NAME = "gp_grade"
    }
}