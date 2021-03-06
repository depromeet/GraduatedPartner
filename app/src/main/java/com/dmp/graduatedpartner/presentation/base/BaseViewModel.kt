package com.dmp.graduatedpartner.presentation.base

import androidx.lifecycle.ViewModel
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class BaseViewModel : ViewModel() {
    private val disposables = CompositeDisposable()

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }

    fun <T> Single<T>.subscribeIgnoreError(success: (T) -> Unit) =
        observeOn(Schedulers.io()).subscribe(success, {})

    fun Disposable.bind() = apply {
        disposables.add(this)
    }
}