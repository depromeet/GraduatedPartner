package com.dmp.graduatedpartner.presentation.base

import androidx.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {
    val disposables = CompositeDisposable()

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }

    fun <T> Single<T>.subscribeIgnoreError(success: (T) -> Unit) = subscribe(success, { })

    fun Disposable.bind() = apply {
        disposables.add(this)
    }
}