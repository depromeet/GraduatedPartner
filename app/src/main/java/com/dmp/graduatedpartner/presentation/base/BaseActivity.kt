package com.dmp.graduatedpartner.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.pm.ActivityInfo
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class BaseActivity : AppCompatActivity() {
    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }

    fun <T> Single<T>.subscribeIgnoreError(success: (T) -> Unit) =
        observeOn(Schedulers.io()).subscribe(success, {})

    fun Disposable.bind() = apply {
        disposables.add(this)
    }
}