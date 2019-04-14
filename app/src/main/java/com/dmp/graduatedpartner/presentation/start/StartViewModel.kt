package com.dmp.graduatedpartner.presentation.start

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dmp.graduatedpartner.presentation.base.BaseViewModel
import com.dmp.graduatedpartner.usecase.GetSignIn

class StartViewModel(private val getSignIn: GetSignIn) : BaseViewModel() {
    val isSignIn = MutableLiveData<Boolean>()
}