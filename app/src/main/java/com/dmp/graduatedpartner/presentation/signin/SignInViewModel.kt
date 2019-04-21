package com.dmp.graduatedpartner.presentation.signin

import com.dmp.graduatedpartner.const.USER_KEY
import com.dmp.graduatedpartner.model.User
import com.dmp.graduatedpartner.presentation.base.BaseViewModel
import com.dmp.graduatedpartner.usecase.SignInUsecase

class SignInViewModel(private val signInUsecase: SignInUsecase) : BaseViewModel() {
    fun setData(userName: String, totalSemester: Int, currentSemester: Int, totalGrade: Int, currentGrade: Int) {
        signInUsecase(userName, currentSemester, totalSemester, currentGrade, totalGrade)
    }
}