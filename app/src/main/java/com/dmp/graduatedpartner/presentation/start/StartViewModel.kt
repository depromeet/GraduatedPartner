package com.dmp.graduatedpartner.presentation.start

import com.dmp.graduatedpartner.presentation.base.BaseViewModel
import com.dmp.graduatedpartner.usecase.GetUser
import io.reactivex.schedulers.Schedulers

class StartViewModel(
    private val getUser: GetUser
) : BaseViewModel() {
    var existedUser = false

    init {
        updateUserExist()
    }

    private fun updateUserExist() =
        getUser("user")
            .observeOn(Schedulers.io())
            .subscribeIgnoreError {
                it.name?.let {
                    existedUser = true
                }
            }.bind()
}