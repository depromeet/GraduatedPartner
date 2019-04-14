package com.dmp.graduatedpartner.datasource.local

import com.dmp.graduatedpartner.model.User

class UserDataSource {
    //fixme: Just TestCode
    private val user = User(null, null)

    fun getUserSigned() = user.signed
}