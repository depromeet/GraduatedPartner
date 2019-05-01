package com.dmp.graduatedpartner.presentation

import com.dmp.graduatedpartner.presentation.updategrade.UpdateGradeViewModel
import com.dmp.graduatedpartner.presentation.score.ScoreViewModel
import com.dmp.graduatedpartner.presentation.signin.SignInViewModel
import com.dmp.graduatedpartner.presentation.start.StartViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { StartViewModel(get()) }
    viewModel { SignInViewModel(get()) }
    viewModel { ScoreViewModel(get(), get(), get()) }
    viewModel { UpdateGradeViewModel(get(), get()) }
}