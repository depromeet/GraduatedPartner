package com.dmp.graduatedpartner.repository

import com.dmp.graduatedpartner.datasource.local.UserDataSource
import com.dmp.graduatedpartner.model.User

class UserRepository(private val userDataSource: UserDataSource) {
    fun get(key: String) = userDataSource.get(key)
    fun put(key: String, content: User) = userDataSource.put(key, content)
}