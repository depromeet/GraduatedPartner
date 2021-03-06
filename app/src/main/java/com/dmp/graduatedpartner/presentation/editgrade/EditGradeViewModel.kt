package com.dmp.graduatedpartner.presentation.editgrade

import androidx.lifecycle.MutableLiveData
import com.dmp.graduatedpartner.const.CULTURE_GRADE_KEY
import com.dmp.graduatedpartner.const.ETC_GRADE_KEY
import com.dmp.graduatedpartner.const.MAJOR_GRADE_KEY
import com.dmp.graduatedpartner.model.Grade
import com.dmp.graduatedpartner.presentation.base.BaseViewModel
import com.dmp.graduatedpartner.usecase.GetGradeUsecase
import com.dmp.graduatedpartner.usecase.EditGradeUsecase

class EditGradeViewModel(
    private val getGradeusecase: GetGradeUsecase, private val editGradeUsecase: EditGradeUsecase
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
        editGradeUsecase(majorCurrent, majorTotal, cultureCurrent, cultureTotal, etcCurrent, etcTotal)
    }
}