package com.dmp.graduatedpartner.presentation.score

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import com.dmp.graduatedpartner.const.*
import com.dmp.graduatedpartner.model.Grade
import com.dmp.graduatedpartner.presentation.base.BaseViewModel
import com.dmp.graduatedpartner.usecase.GetGradeUsecase
import com.dmp.graduatedpartner.usecase.GetUserUsecase

class ScoreViewModel(private val getUserUsecase: GetUserUsecase, private val getGradeUsecase: GetGradeUsecase) :
    BaseViewModel() {
    val userName = MutableLiveData<String>()

    val totalGrade = MutableLiveData<Grade>()
    val totalPercent = MutableLiveData<Int>()

    val majorGrade = MutableLiveData<Grade>()
    val majorPercent = MutableLiveData<Int>()

    val cultureGrade = MutableLiveData<Grade>()
    val culturePercent = MutableLiveData<Int>()

    val etcGrade = MutableLiveData<Grade>()
    val etcPercent = MutableLiveData<Int>()

    fun getUserInfoTwice() {
        getUserInfo()
        Handler().postDelayed(
            {
                getUserInfo()
            },
            500
        )
    }

    private fun getUserInfo() =
        getUserUsecase(USER_KEY).subscribeIgnoreError { user ->
            userName.postValue(user.name)

            getGradeUsecase(TOTAL_GRADE_KEY).subscribeIgnoreError { grade ->
                if (grade.total != null && grade.current != null) {
                    totalGrade.postValue(grade)
                    totalPercent.postValue(
                        if (grade.total == 0) {
                            100
                        } else {
                            grade.current * 100 / grade.total
                        }
                    )
                }
            }.bind()

            getGradeUsecase(MAJOR_GRADE_KEY).subscribeIgnoreError { grade ->
                if (grade.total != null && grade.current != null) {
                    majorGrade.postValue(grade)
                    majorPercent.postValue(
                        if (grade.total == 0) {
                            100
                        } else {
                            grade.current * 100 / grade.total
                        }
                    )
                }
            }.bind()

            getGradeUsecase(CULTURE_GRADE_KEY).subscribeIgnoreError { grade ->
                if (grade.total != null && grade.current != null) {
                    cultureGrade.postValue(grade)
                    culturePercent.postValue(
                        if (grade.total == 0) {
                            100
                        } else {
                            grade.current * 100 / grade.total
                        }
                    )
                }
            }.bind()

            getGradeUsecase(ETC_GRADE_KEY).subscribeIgnoreError { grade ->
                if (grade.total != null && grade.current != null) {
                    etcGrade.postValue(grade)
                    etcPercent.postValue(
                        if (grade.total == 0) {
                            100
                        } else {
                            grade.current * 100 / grade.total
                        }
                    )
                }
            }.bind()
        }.bind()
}