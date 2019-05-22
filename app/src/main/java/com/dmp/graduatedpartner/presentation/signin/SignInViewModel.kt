package com.dmp.graduatedpartner.presentation.signin

import com.dmp.graduatedpartner.model.GradRequ
import com.dmp.graduatedpartner.model.GraduateList
import com.dmp.graduatedpartner.presentation.base.BaseViewModel
import com.dmp.graduatedpartner.usecase.SignInUsecase

class SignInViewModel(private val signInUsecase: SignInUsecase) : BaseViewModel() {
    fun setData(userName: String, totalSemester: Int, currentSemester: Int, totalGrade: Int, currentGrade: Int, graduateList: GraduateList) {
        signInUsecase(userName, currentSemester, totalSemester, currentGrade, totalGrade, graduateList)
    }
}