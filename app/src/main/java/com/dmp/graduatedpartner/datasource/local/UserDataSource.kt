package com.dmp.graduatedpartner.datasource.local

import android.content.Context
import com.dmp.graduatedpartner.Application
import com.dmp.graduatedpartner.model.User
import com.google.gson.Gson
import io.reactivex.Maybe
import io.reactivex.Single

class UserDataSource {
    private val sharedPreference = Application.appContext?.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    private val editor by lazy { sharedPreference?.edit() }
    private val gson = Gson()

    fun put(key: String, content: User) =
        gson.toJson(content)?.let {
            editor?.putString(key, it)
            editor?.apply()
        }

    fun get(key: String): Single<User> =
        Maybe.create<User> {
            sharedPreference?.getString(key, null)?.let { gson.fromJson(it, User::class.java) }
        }.switchIfEmpty(Single.create<User> { User(null) })

    companion object {
        const val FILE_NAME = "gp_user"
    }
}