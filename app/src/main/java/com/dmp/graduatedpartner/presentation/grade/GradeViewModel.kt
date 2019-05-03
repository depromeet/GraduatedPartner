package com.dmp.graduatedpartner.presentation.grade

import androidx.lifecycle.MutableLiveData
import com.dmp.graduatedpartner.const.CULTURE_GRADE_KEY
import com.dmp.graduatedpartner.const.ETC_GRADE_KEY
import com.dmp.graduatedpartner.const.MAJOR_GRADE_KEY
import com.dmp.graduatedpartner.model.Grade
import com.dmp.graduatedpartner.presentation.base.BaseViewModel
import com.dmp.graduatedpartner.usecase.GetGrade
import com.dmp.graduatedpartner.usecase.UpdateGrade

class GradeViewModel(
    private val getGradeusecase: GetGrade, private val updateGradeUsecase: UpdateGrade
) : BaseViewModel() {

    val majorGrade = MutableLiveData<Grade>()
    val cultureGrade = MutableLiveData<Grade>()
    val etcGrade = MutableLiveData<Grade>()

    init {
        getGrade()
    }

    private fun getGrade() {
        getGradeusecase(MAJOR_GRADE_KEY).subscribeIgnoreError {
            majorGrade.postValue(it)
        }.bind()

        getGradeusecase(CULTURE_GRADE_KEY).subscribeIgnoreError {
            cultureGrade.postValue(it)
        }.bind()

        getGradeusecase(ETC_GRADE_KEY).subscribeIgnoreError {
            etcGrade.postValue(it)
        }.bind()
    }

    fun saveGrade(
        majorCurrent: Int, majorTotal: Int, cultureCurrent: Int,
        cultureTotal: Int, etcCurrent: Int, etcTotal: Int
    ) {
        updateGradeUsecase(majorCurrent, majorTotal, cultureCurrent, cultureTotal, etcCurrent, etcTotal)
    }
}