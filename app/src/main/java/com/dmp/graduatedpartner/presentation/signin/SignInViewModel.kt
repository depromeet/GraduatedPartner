package com.dmp.graduatedpartner.presentation.signin

import com.dmp.graduatedpartner.model.Graduate
import com.dmp.graduatedpartner.presentation.base.BaseViewModel
import com.dmp.graduatedpartner.usecase.SignIn

class SignInViewModel(private val signIn: SignIn) : BaseViewModel() {
    fun setData(userName: String, totalSemester: Int, currentSemester: Int, totalGrade: Int, currentGrade: Int, graduateList: List<Graduate>) {
        signIn(userName, currentSemester, totalSemester, currentGrade, totalGrade, graduateList)
    }
}