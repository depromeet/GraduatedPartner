package com.dmp.graduatedpartner.presentation.start

import com.dmp.graduatedpartner.presentation.base.BaseViewModel
import com.dmp.graduatedpartner.usecase.GetUser

class StartViewModel(
    private val getUser: GetUser
) : BaseViewModel() {
    var existedUser = false

    init {
        updateUserExist()
    }

    private fun updateUserExist() = getUser("user")
        .subscribeIgnoreError {
            it.name?.let {
                existedUser = true
            }
        }.bind()
}