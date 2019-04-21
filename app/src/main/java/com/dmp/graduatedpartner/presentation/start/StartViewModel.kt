package com.dmp.graduatedpartner.presentation.start

import com.dmp.graduatedpartner.const.USER_KEY
import com.dmp.graduatedpartner.presentation.base.BaseViewModel
import com.dmp.graduatedpartner.usecase.GetUserUsecase

class StartViewModel(
    private val getUserUsecase: GetUserUsecase
) : BaseViewModel() {
    var existedUser = false

    init {
        updateUserExist()
    }

    private fun updateUserExist() =
        getUserUsecase(USER_KEY)
            .subscribeIgnoreError {
                it.name?.let {
                    existedUser = true
                }
            }.bind()
}