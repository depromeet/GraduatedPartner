package com.dmp.graduatedpartner.datasource.local

import android.content.Context
import com.dmp.graduatedpartner.Application
import com.dmp.graduatedpartner.model.GradRequ
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Single
import io.reactivex.Single.create
import java.util.*


class GradRequDataSource {
    private val sharedPreference = Application.appContext?.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    private val editor by lazy { sharedPreference?.edit() }
    private val gson = Gson()

    fun put(key: String, content: Objects) =
            gson.toJson(content)?.let {
                editor?.putString(key, it)
                editor?.apply()
            }

    fun get(key: String): Single<List<GradRequ>> {
        val listType = object : TypeToken<List<GradRequ>>() {}.type
        return create<List<GradRequ>> { emitter ->
            emitter.onSuccess(sharedPreference?.getString(key, null)?.let { gson.fromJson(it, object : TypeToken<List<GradRequ>>() {}.type) as List<GradRequ> }
                    ?: arrayListOf(GradRequ(null, null, false)))
        }
    }

    companion object {
        const val FILE_NAME = "gp_grade"
    }
}