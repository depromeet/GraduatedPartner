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
    val etcGrade = MutableLiveData<Grade>()

    init {
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
                majorGrade.postValue(grade)
            }.bind()

            getGradeUsecase(CULTURE_GRADE_KEY).subscribeIgnoreError { grade ->
                cultureGrade.postValue(grade)
            }.bind()

            getGradeUsecase(ETC_GRADE_KEY).subscribeIgnoreError { grade ->
                etcGrade.postValue(grade)
            }.bind()
        }.bind()
}