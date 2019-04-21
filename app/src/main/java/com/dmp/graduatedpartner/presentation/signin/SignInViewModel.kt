package com.dmp.graduatedpartner.presentation.signin

import com.dmp.graduatedpartner.const.USER_KEY
import com.dmp.graduatedpartner.model.User
import com.dmp.graduatedpartner.presentation.base.BaseViewModel
import com.dmp.graduatedpartner.usecase.PutUser

class SignInViewModel(private val putUser: PutUser) : BaseViewModel() {
    fun setData(userName: String, totalSemester: Int, currentSemester: Int, totalGrade: Int, currentGrade: Int) {
        putUser(
            USER_KEY,
            User(
                name = userName,
                totalSemester = totalSemester,
                currentSemester = currentSemester,
                totalGrade = totalGrade,
                currentGrade = currentGrade
            )
        )
    }
}