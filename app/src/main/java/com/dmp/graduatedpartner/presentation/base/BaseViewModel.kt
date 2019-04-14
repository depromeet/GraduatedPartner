package com.dmp.graduatedpartner.presentation.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    override fun onCleared() {
        super.onCleared()
    }
}